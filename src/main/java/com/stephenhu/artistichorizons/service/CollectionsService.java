package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Collections;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 藏馆表业务逻辑
 */
public abstract interface CollectionsService {

    /**
     * 插入
     * @param collectionName 藏馆名称
     * @param description 藏馆描述
     * @param cityId 城市主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> insert(String collectionName, String description, Date createTime,long cityId);

    /**
     * 删除
     * @param collectionId 藏馆主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> delById(long collectionId);

    /**
     * 更新
     * @param collectionId 藏馆主键ID
     * @param collectionName 藏馆名称
     * @param description 藏馆描述
     * @param cityId 城市主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> updateById(long collectionId, String collectionName, String description, Date createTime, long cityId);

    /**
     * 查询
     * @return ResultUtil
     * */
    abstract ResultUtil<List<Collections>> selectAll();

    /**
     * 查询
     * @param collectionId 藏馆主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Collections> selectById(long collectionId);
}
