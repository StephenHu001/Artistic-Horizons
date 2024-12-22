package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Countries;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 国家表业务逻辑层
 */
public abstract interface CountriesService {

    /**
     * 插入一条数据
     * @param countryName 国家名称
     * @param description 国家描述
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> insert(String countryName, String description);

    /**
     * 删除一条数据
     * @param countryId 国家ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> delById(long countryId);

    /**
     * 更新一条数据
     * @param countryId 国家ID
     * @param countryName 国家名称
     * @param description 国家描述
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> updateById(long countryId, String countryName, String description);

    /**
     * 查询所有数据
     * @return ResultUtil
     * */
    abstract ResultUtil<List<Countries>> selectAll();

    /**
     * 根据ID查询一条数据
     * @param countryId 国家ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Countries> selectById(long countryId);
}
