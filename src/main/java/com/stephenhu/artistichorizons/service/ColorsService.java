package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Colors;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 颜色表业务逻辑层
 */
public abstract interface ColorsService {
    /**
     * 添加颜色详细信息操作
     *
     * @param colorName 颜色名称
     * @param colorRgb  颜色RGB
     * @return ResultUtil
     */
    abstract ResultUtil<Integer> insert(String colorName, String colorRgb);

    /**
     * 删除颜色（逻辑上）详细信息操作
     *
     * @param colorId 颜色主键ID
     * @return ResultUtil
     */
    abstract ResultUtil<Integer> delById(long colorId);

    /**
     * 更新颜色详细信息操作
     * @param colorId 颜色主键ID
     * @param colorName 颜色名称
     * @param colorRgb  颜色RGB
     * @return ResultUtil
     */
    abstract ResultUtil<Integer> updateById(long colorId, String colorName, String colorRgb);

    /**
     * 更新颜色详细信息操作
     * @return ResultUtil
     */
    abstract ResultUtil<List<Colors>> selectAll();

    /**
     * 根据颜色主键ID查询颜色详细信息操作
     * @param colorId 颜色主键ID
     * @return ResultUtil
     */
    abstract ResultUtil<Colors> selectById(long colorId);
}
