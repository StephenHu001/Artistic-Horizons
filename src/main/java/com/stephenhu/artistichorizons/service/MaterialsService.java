package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.Materials;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 材质表业务逻辑层
 */
public abstract interface MaterialsService {

    /**
     * 插入
     * @param materialName 材质名称
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> insert(String materialName);

    /**
     * 删除
     * @param materialId 材质id
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> delById(long materialId);

    /**
     * 更新
     * @param materialId 材质id
     * @param materialName 材质名称
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> updateById(long materialId, String materialName);

    /**
     * 查询所有
     * @return ResultUtil<List<Materials>>
     * */
    abstract ResultUtil<List<Materials>> selectAll();

    /**
     * 根据id查询
     * @param materialId 材质id
     * @return ResultUtil<Materials>
     * */
    abstract ResultUtil<Materials> selectById(long materialId);
}
