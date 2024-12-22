package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Themes;

import java.util.List;

/**
 * @author Stephen Hu
 * 主题表实现基本的插入记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
public interface ThemesDao extends BaseMapper<Themes> {
    /**
     * 插入主题记录
     * @param themeId 主题id
     * @param themeName 主题名称
     * @return 更新成功返回True，否则返回False
     * */
    boolean insert(long themeId,String themeName);

    /**
     * 查询所有主题及其详细信息记录
     * @return 所有主题
     * */
    List<Themes> findAll();

    /**
     * 根据id查询主题记录及其详细信息
     * @param themeId 主题id
     * @return 主题
     * */
    Themes findById(long themeId);

    /**
     * 根据id删除主图记录（逻辑意义上）
     * @param themeId 主题id
     * @return 删除成功返回True，否则返回False
     * */
    boolean delById(long themeId);

    /**
     * 根据id回滚主题记录（逻辑意义上）
     * @param themeId 主题id
     * @return 回滚成功返回True，否则返回False
     * */
    boolean rollbackById(long themeId);

    /**
     * 查询重复的主题记录
     * @param themeName 主题名称
     * @return 主题
     * */
    Themes findRepeat(String themeName);
}
