package com.stephenhu.artistichorizons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stephenhu.artistichorizons.pojo.Artworks;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 艺术品表业务逻辑层
 */
public abstract interface ArtworksService{

    /**
     * 插入一条艺术品数据
     *
     * @param artworkName  艺术品名称
     * @param createTime   艺术品创建时间
     * @param description  艺术品描述
     * @param materialId   艺术品材质编号
     * @param colorId      艺术品颜色编号
     * @param artistId     艺术品作者编号
     * @param eventId      艺术品事件编号
     * @param collectionId 艺术品收藏编号
     * @param themeId      艺术品主题编号
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String artworkName, Date createTime, String description, long materialId, long colorId, long artistId, long eventId, long collectionId, long themeId);

    /**
     * 删除一条艺术品数据
     *
     * @param artworkId 艺术品编号
     */
    abstract ResultUtil<Integer> delById(long artworkId);

    /**
     * 更新一条艺术品数据
     *
     * @param artworkName  艺术品名称
     * @param description  艺术品描述
     * @param materialId   艺术品材质编号
     * @param colorId      艺术品颜色编号
     * @param artistId     艺术品作者编号
     * @param eventId      艺术品事件编号
     * @param collectionId 艺术品收藏编号
     * @param themeId      艺术品主题编号
     */
    abstract ResultUtil<Integer> updateById(long artworkId,String artworkName, Date createTime,String description, long materialId, long colorId, long artistId, long eventId, long collectionId, long themeId);

    /**
     * 查询所有艺术品数据
     *
     * @return ResultUtil<List < Artworks>>
     */
    abstract ResultUtil<List<Artworks>> selectAll();

    /**
     * 根据艺术品编号查询艺术品数据
     *
     * @param artworkId 艺术品编号
     * @return ResultUtil<Artworks>
     */
    abstract ResultUtil<Artworks> selectById(long artworkId);
}
