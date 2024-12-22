package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Colors;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 颜色表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface ColorsDao extends BaseMapper<Colors> {

    /**
     * 根据id查询颜色记录及其详细信息
     * @param colorId 颜色id
     * @param colorName 颜色名称
     * @param colorRgb 颜色RGB
     * @return 颜色
     */
    boolean insert(long colorId, String colorName, String colorRgb);

    /**
     * 查询所有颜色记录及其详细信息
     * @return 颜色
     */
    List<Colors> findAll();

    /**
     * 根据id查询颜色记录及其详细信息
     * @param colorId 颜色id
     * @return 颜色
     */
    Colors findById(long colorId);

    /**
     * 根据id删除颜色记录（逻辑意义上）
     * @param colorId 颜色id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long colorId);

    /**
     * 根据id回滚颜色记录（逻辑意义上）
     * @param colorId 颜色id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(long colorId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param colorName 颜色名称
     * @param colorRgb 颜色RGB
     * @return 颜色
     * */
    Colors findRepeat(String colorName,String colorRgb);
}
