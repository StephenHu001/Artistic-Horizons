package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.Figures;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 历史人物表业务逻辑层
 */
public abstract interface FiguresService {

    /**
     * 插入历史记录
     * @param figureName 历史名称
     * @param birthDate 出生日期
     * @param deathDate 逝世日期
     * @param description 历史描述
     * @param cityId 城市外键
     * @param eventId 历史事件外键
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String figureName, Date birthDate, Date deathDate, String description, long cityId, long eventId);

    /**
     * 删除历史记录
     * @param figureId 历史主键
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> delById(long figureId);

    /**
     * 更新历史记录
     * @param figureId 历史主键
     * @param figureName 历史名称
     * @param birthDate 出生日期
     * @param deathDate 逝世日期
     * @param description 历史描述
     * @param cityId 城市外键
     * @param eventId 历史事件外键
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> updateById(long figureId, String figureName, Date birthDate, Date deathDate, String description, long cityId, long eventId);

    /**
     * 查询所有历史记录
     * @return ResultUtil<List<Figures>>
     */
    abstract ResultUtil<List<Figures>> selectAll();

    /**
     * 根据历史主键查询历史记录
     * @param figureId 历史主键
     * @return ResultUtil<Figures>
     */
    abstract ResultUtil<Figures> selectById(long figureId);
}
