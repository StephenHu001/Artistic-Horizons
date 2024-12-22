package com.stephenhu.artistichorizons.service.impl;

import com.stephenhu.artistichorizons.dao.ImgsDao;
import com.stephenhu.artistichorizons.pojo.Imgs;
import com.stephenhu.artistichorizons.service.ImgsService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import com.stephenhu.artistichorizons.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stephen Hu
 * 业务实现类
 */
@Service
public final class ImgsServiceImpl implements ImgsService {
    @Autowired
    private ImgsDao imgsDao;
    @Override
    public ResultUtil<Integer> insert(String imgPath, long colorId, long materialId, long countryId, long districtId, long cityId, long collectionId, long figureId, long artistId, long themeId, long eventId, long artworkId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //findRepeat方法检查数据库中是否存在相同记录
            if (imgsDao.findRepeat(imgPath) == null) {
                //insert方法添加记录
                imgsDao.insert(SnowFlakeUtil.getID(), imgPath, colorId, materialId, countryId, districtId, cityId, collectionId, figureId, artistId, themeId, eventId, artworkId);
                return ResultUtil.success(200);
            } else {
                return ResultUtil.fail(400, "repeat");
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> delById(long imgId) {
        try {
            //先进行判断，是否存在此颜色，不存在直接报400状态码（内部逻辑中止）
            if (imgsDao.findById(imgId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给干没了，测试的时候闲着干掉了0这个数据，直接崩了
                //判断删的是不是0，那就直接报警告
                if (imgId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't delete original by zero");
                } else {
                    //执行删除操作，并返回200状态码
                    imgsDao.delById(imgId);
                    return ResultUtil.success(200);
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> updateById(long imgId, String imgPath, long colorId, long materialId, long countryId, long districtId, long cityId, long collectionId, long figureId, long artistId, long themeId, long eventId, long artworkId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (imgsDao.findById(imgId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                if (imgId == 0L) {
                    //别TM把id为0这条原始数据给改了
                    //判断删的是不是0，那就直接报警告
                    return ResultUtil.fail(400, "Warring, can't update original by zero");
                } else {
                    //先删除此条数据
                    imgsDao.delById(imgId);
                    if (imgsDao.findRepeat(imgPath) != null) {
                        imgsDao.rollbackById(imgId);
                        return ResultUtil.fail(400, "repeat");
                    } else {
                        //再添加新的数据
                        imgsDao.insert(SnowFlakeUtil.getID(), imgPath, colorId, materialId, countryId, districtId, cityId, collectionId, figureId, artistId, themeId, eventId, artworkId);
                        return ResultUtil.success(200);
                    }
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<List<Imgs>> selectAll() {
        try {
            return ResultUtil.success(imgsDao.findAll());
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Imgs> selectById(long imgId) {
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (imgsDao.findById(imgId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给拿出来了
                //判断是不是0，那就直接报警告
                if (imgId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't find original by zero");
                } else {
                    //返回查询结果
                    return ResultUtil.success(imgsDao.findById(imgId));
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }
}
