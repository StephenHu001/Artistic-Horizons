package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Materials;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 材质表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface MaterialsDao extends BaseMapper<Materials> {
    /**
     * 插入材质记录
     * @param materialId 材质id
     * @param materialName 材质名称
     * @return 更新成功返回True，否则返回False
     * */
    boolean insert(Long materialId,String materialName);

    /**
     * 查询所有材质及其详细信息记录
     * @return 所有材质
     * */
    List<Materials> findAll();

    /**
     * 根据id查询材质记录及其详细信息
     * @param materialId 材质id
     * @return 邮政编码
     * */
    Materials findById(Long materialId);

    /**
     * 根据id删除材质记录（逻辑意义上）
     * @param materialId 材质id
     * @return 删除成功返回True，否则返回False
     * */
    boolean delById(Long materialId);

    /**
     * 根据id回滚材质记录（逻辑意义上）
     * @param materialId 材质id
     * @return 回滚成功返回True，否则返回False
     * */
    boolean rollbackById(Long materialId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param materialName 材质名称
     * @return 材质
     * */
    Materials findRepeat(String materialName);
}
