package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.Themes;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 主题表业务逻辑层
 */
public abstract interface ThemesService {

    /**
     * 主题表插入数据
     * @param themeName 主题名称
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String themeName);

    /**
     * 主题表删除数据
     * @param themeId 主题id
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> delById(long themeId);

    /**
     * 主题表修改数据
     * @param themeId 主题id
     * @param themeName 主题名称
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> updateById(long themeId, String themeName);

    /**
     * 主题表查询数据
     * @return ResultUtil<List<Themes>>
     */
    abstract ResultUtil<List<Themes>> selectAll();

    /**
     * 主题表查询数据
     * @param themeId 主题id
     * @return ResultUtil<Themes>
     */
    abstract ResultUtil<Themes> selectById(long themeId);
}
