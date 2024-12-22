package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Cities;
import com.stephenhu.artistichorizons.utils.ResultUtil;


import java.util.List;

/**
 * @author Stephen Hu
 * 城市表业务逻辑
 */
public abstract interface CitiesService {

    /**
     * 插入一条数据
     *
     * @param cityName     城市名
     * @param description  城市描述
     * @param postalCodeId 邮政编码
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String cityName, String description, long districtId, long postalCodeId);

    /**
     * 删除一条数据
     *
     * @param cityId 城市id
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> delById(long cityId);

    /**
     * 更新一条数据
     *
     * @param cityId       城市id
     * @param cityName     城市名
     * @param description  城市描述
     * @param postalCodeId 邮政编码
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> updateById(long cityId, String cityName, String description, long districtId, long postalCodeId);

    /**
     * 查询全部数据
     *
     * @return ResultUtil<List < Cities>>
     */
    abstract ResultUtil<List<Cities>> selectAll();

    /**
     * 根据id查询一条数据
     *
     * @param cityId 城市id
     * @return ResultUtil<Cities>
     */
    abstract ResultUtil<Cities> selectById(long cityId);
}
