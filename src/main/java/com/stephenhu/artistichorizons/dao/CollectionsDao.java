package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Collections;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 藏馆表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface CollectionsDao extends BaseMapper<Collections> {
    /**
     * 插入集合记录
     *
     * @param collectionId   藏馆id
     * @param collectionName 藏馆名称
     * @param description    藏馆描述
     * @param createTime     创建时间
     * @param cityId         城市id
     * @return 插入成功返回True，否则返回False
     */
    boolean insert(long collectionId, String collectionName, String description, Date createTime, long cityId);

    /**
     * 查询所有藏馆记录及其详细信息
     * @return 藏馆列表
     */
    List<Collections> findAll();

    /**
     * 根据id查询藏馆记录及其详细信息
     * @param collectionId 藏馆id
     * @return 藏馆
     */
    Collections findById(long collectionId);

    /**
     * 根据id删除藏馆记录（逻辑意义上）
     *
     * @param collectionId 藏馆id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long collectionId);

    /**
     * 根据id回滚藏馆记录（逻辑意义上）
     *
     * @param collectionId 藏馆id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(long collectionId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param collectionName 艺术品名称
     * @return 藏馆
     */
    Collections findRepeat(String collectionName);
}
