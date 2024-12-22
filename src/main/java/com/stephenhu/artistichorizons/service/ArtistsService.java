package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Artists;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 作家表业务逻辑层
 */
public abstract interface ArtistsService{

    /**
     * 插入作家数据
     * @param artistName 作家姓名
     * @param birthDate 出世日期
     * @param deathDate 逝世日期
     * @param description 描述
     * @param cityId 城市id
     * @param themeId 风格id
     * @param eventId 事件id
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> insert(String artistName,Date birthDate, Date deathDate, String description, long cityId, long themeId, long eventId);

    /**
     * 删除作家数据
     * @param artistId 作家id
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> delById(long artistId);

    /**
     * 更新作家数据
     * @param artistId 作家id
     * @param artistName 作家姓名
     * @param birthDate 出世日期
     * @param deathDate 逝世日期
     * @param description 描述
     * @param cityId 城市id
     * @param themeId 风格id
     * @param eventId 事件id
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> updateById(long artistId, String artistName, Date birthDate, Date deathDate, String description, long cityId, long themeId, long eventId);

    /**
     * 查询作家数据
     * @return ResultUtil
     * */
    abstract ResultUtil<List<Artists>> selectAll();

    /**
     * 查询作家数据
     * @param artistId 作家id
     * @return ResultUtil
     * */
    abstract ResultUtil<Artists> selectById(long artistId);
}
