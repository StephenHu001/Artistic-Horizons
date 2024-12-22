package com.stephenhu.artistichorizons.service.impl;

import com.stephenhu.artistichorizons.dao.FiguresDao;
import com.stephenhu.artistichorizons.pojo.Figures;
import com.stephenhu.artistichorizons.service.FiguresService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import com.stephenhu.artistichorizons.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 历史人物实现类
 */
@Service
public final class FiguresServiceImpl implements FiguresService {

    @Autowired
    private FiguresDao figuresDao;
    @Override
    public ResultUtil<Integer> insert(String figureName, Date birthDate, Date deathDate, String description, long cityId, long eventId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //findRepeat方法检查数据库中是否存在相同记录
            if (figuresDao.findRepeat(figureName) == null) {
                //insert方法添加记录
                figuresDao.insert(SnowFlakeUtil.getID(), figureName, birthDate, deathDate, description, cityId, eventId);
                return ResultUtil.success(200);
            } else {
                return ResultUtil.fail(400, "repeat");
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> delById(long figureId) {
        try {
            //先进行判断，是否存在此颜色，不存在直接报400状态码（内部逻辑中止）
            if (figuresDao.findById(figureId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给干没了，测试的时候闲着干掉了0这个数据，直接崩了
                //判断删的是不是0，那就直接报警告
                if (figureId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't delete original by zero");
                } else {
                    //执行删除操作，并返回200状态码
                    figuresDao.delById(figureId);
                    return ResultUtil.success(200);
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> updateById(long figureId, String figureName, Date birthDate, Date deathDate, String description, long cityId, long eventId) {
        //此try-catch块用于捕获整个方法执行过程中可能出现的任何异常。
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (figuresDao.findById(figureId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                if (figureId == 0L) {
                    //别TM把id为0这条原始数据给改了
                    //判断删的是不是0，那就直接报警告
                    return ResultUtil.fail(400, "Warring, can't update original by zero");
                } else {
                    //先删除此条数据
                    figuresDao.delById(figureId);
                    if (figuresDao.findRepeat(figureName) != null) {
                        figuresDao.rollbackById(figureId);
                        return ResultUtil.fail(400, "repeat");
                    } else {
                        //再添加新的数据
                        figuresDao.insert(SnowFlakeUtil.getID(), figureName, birthDate, deathDate, description, cityId, eventId);
                        return ResultUtil.success(200);
                    }
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<List<Figures>> selectAll() {
        try {
            return ResultUtil.success(figuresDao.findAll());
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Figures> selectById(long figureId) {
        try {
            //进行判断是否存在，不存在直接报400状态码（内部逻辑中止）
            if (figuresDao.findById(figureId) == null) {
                return ResultUtil.fail(400, "null");
            } else {
                //别TM把id为0这条原始数据给拿出来了
                //判断是不是0，那就直接报警告
                if (figureId == 0L) {
                    return ResultUtil.fail(400, "Warring, can't find original by zero");
                } else {
                    //返回查询结果
                    return ResultUtil.success(figuresDao.findById(figureId));
                }
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }
}
