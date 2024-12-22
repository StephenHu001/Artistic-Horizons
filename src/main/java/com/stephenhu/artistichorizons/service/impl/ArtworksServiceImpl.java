package com.stephenhu.artistichorizons.service.impl;

import com.stephenhu.artistichorizons.dao.ArtworksDao;
import com.stephenhu.artistichorizons.pojo.Artworks;
import com.stephenhu.artistichorizons.service.ArtworksService;
import com.stephenhu.artistichorizons.utils.DateUtil;
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
public final class ArtworksServiceImpl implements ArtworksService {

    @Autowired
    private ArtworksDao artworksDao;

    @Override
    public ResultUtil<Integer> insert(String artworkName, Date createTime, String description, long materialId, long colorId, long artistId, long eventId, long collectionId, long themeId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //用findRepeat方法检查数据库中是否存在相同
            if (artworksDao.findRepeat(artworkName) == null) {
                //用insert方法添加记录
                artworksDao.insert(SnowFlakeUtil.getID(), artworkName, DateUtil.parseYear("1992"), description, materialId, colorId, artistId, eventId, collectionId, themeId);
                return ResultUtil.success(200);
            } else {
                return ResultUtil.fail(400, "repeat");
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> delById(long artworkId) {
        try {
            if (artworksDao.findById(artworkId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给干没了，测试的时候闲着干掉了0这个数据，直接崩了
                //判断删的是不是0，那就直接报警告
                if (artworkId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't delete original by zero");
                } else {
                    //执行删除操作，并返回200状态码
                    artworksDao.delById(artworkId);
                    return ResultUtil.success(200);
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> updateById(long artworkId, String artworkName,Date createTime, String description, long materialId, long colorId, long artistId, long eventId, long collectionId, long themeId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (artworksDao.findById(artworkId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                if (artworkId == 0L) {
                    //别TM把id为0这条原始数据给改了
                    //判断删的是不是0，那就直接报警告
                    return ResultUtil.fail(400, "Warring, can't update original by zero");
                } else {
                    //先删除此条数据
                    artworksDao.delById(artworkId);
                    if (artworksDao.findRepeat(artworkName) != null) {
                        artworksDao.rollbackById(artworkId);
                        return ResultUtil.fail(400, "repeat");
                    } else {
                        //再添加新的数据
                        artworksDao.insert(SnowFlakeUtil.getID(), artworkName, createTime, description, materialId, colorId, artistId, eventId, collectionId, themeId);
                        return ResultUtil.success(200);
                    }
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<List<Artworks>> selectAll() {
        try {
            return ResultUtil.success(artworksDao.findAll());
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Artworks> selectById(long artworkId) {
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (artworksDao.findById(artworkId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给拿出来了
                //判断是不是0，那就直接报警告
                if (artworkId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't find original by zero");
                } else {
                    //返回查询结果
                    return ResultUtil.success(artworksDao.findById(artworkId));
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }
}
