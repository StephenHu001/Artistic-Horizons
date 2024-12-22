package com.stephenhu.artistichorizons.service.impl;

import com.stephenhu.artistichorizons.dao.CollectionsDao;
import com.stephenhu.artistichorizons.pojo.Collections;
import com.stephenhu.artistichorizons.service.CollectionsService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import com.stephenhu.artistichorizons.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 */
@Service
public final class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    private CollectionsDao collectionsDao;

    @Override
    public ResultUtil<Integer> insert(String collectionName, String description, Date createTime, long cityId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //findRepeat方法检查数据库中是否存在相同记录
            if (collectionsDao.findRepeat(collectionName) == null) {
                //insert方法添加记录
                collectionsDao.insert(SnowFlakeUtil.getID(), collectionName, description, createTime, cityId);
                return ResultUtil.success(200);
            } else {
                return ResultUtil.fail(400, "repeat");
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> delById(long collectionId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //先进行判断，是否存在此颜色，不存在直接报400状态码（内部逻辑中止）
            if (collectionsDao.findById(collectionId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给干没了，测试的时候闲着干掉了0这个数据，直接崩了
                //判断删的是不是0，那就直接报警告
                if (collectionId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't delete original by zero");
                } else {
                    //执行删除操作，并返回200状态码
                    collectionsDao.delById(collectionId);
                    return ResultUtil.success(200);
                }

            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> updateById(long collectionId, String collectionName, String description, Date createTime,long cityId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (collectionsDao.findById(collectionId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                if (collectionId == 0L) {
                    //别TM把id为0这条原始数据给改了
                    //判断删的是不是0，那就直接报警告
                    return ResultUtil.fail(400, "Warring, can't update original by zero");
                } else {
                    //先删除此条数据
                    collectionsDao.delById(collectionId);
                    if (collectionsDao.findRepeat(collectionName) != null) {
                        collectionsDao.rollbackById(collectionId);
                        return ResultUtil.fail(400, "repeat");
                    } else {
                        //再添加新的数据
                        collectionsDao.insert(SnowFlakeUtil.getID(), collectionName, description, createTime, cityId);
                        return ResultUtil.success(200);
                    }
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<List<Collections>> selectAll() {
        try {
            return ResultUtil.success(collectionsDao.findAll());
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Collections> selectById(long collectionId) {
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (collectionsDao.findById(collectionId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给拿出来了
                //判断是不是0，那就直接报警告
                if (collectionId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't find original by zero");
                } else {
                    //返回查询结果
                    return ResultUtil.success(collectionsDao.findById(collectionId));
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }
}
