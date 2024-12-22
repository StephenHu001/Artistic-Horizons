package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Districts;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 区域表业务逻辑层
 */
public abstract interface DistrictsService {

    /**
     * 插入数据
     * @param districtName 区域名称
     * @param description 区域描述
     * @param countryId 外键，关联国家主键ID
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String districtName, String description, long countryId);

    /**
     * 删除数据
     * @param districtId 主键ID
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> delById(long districtId);

    /**
     * 更新数据
     * @param districtId 主键ID
     * @param districtName 区域名称
     * @param description 区域描述
     * @param countryId 外键，关联国家主键ID
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> updateById(long districtId, String districtName, String description, long countryId);

    /**
     * 查询所有数据
     * @return ResultUtil<List<Districts>>
     */
    abstract ResultUtil<List<Districts>> selectAll();

    /**
     * 查询数据
     * @param districtId 主键ID
     * @return ResultUtil<Districts>
     */
    abstract ResultUtil<Districts> selectById(long districtId);
}
