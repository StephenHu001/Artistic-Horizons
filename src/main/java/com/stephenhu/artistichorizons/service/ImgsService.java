package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.Imgs;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 图片表业务逻辑层
 */
public abstract interface ImgsService {

    /**
     * 插入图片
     * @param imgPath 图片路径
     * @param colorId 颜色主键ID
     * @param materialId 材质主键ID
     * @param countryId 国家主键ID
     * @param districtId 地区主键ID
     * @param cityId 城市主键ID
     * @param collectionId 艺术集主键ID
     * @param figureId 艺术家主键ID
     * @param artistId 艺术主题主键ID
     * @param themeId 艺术主题主键ID
     * @param eventId 事件主键ID
     * @param artworkId 艺术作品主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> insert(String imgPath, long colorId, long materialId, long countryId, long districtId, long cityId, long collectionId, long figureId, long artistId, long themeId, long eventId, long artworkId);

    /**
     * 删除图片
     * @param imgId 图片主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> delById(long imgId);

    /**
     * 更新图片
     * @param imgId 图片主键ID
     * @param imgPath 图片路径
     * @param colorId 颜色主键ID
     * @param materialId 材质主键ID
     * @param countryId 国家主键ID
     * @param districtId 地区主键ID
     * @param cityId 城市主键ID
     * @param collectionId 艺术集主键ID
     * @param figureId 艺术家主键ID
     * @param artistId 艺术主题主键ID
     * @param themeId 艺术主题主键ID
     * @param eventId 事件主键ID
     * @param artworkId 艺术作品主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Integer> updateById(long imgId, String imgPath, long colorId, long materialId, long countryId, long districtId, long cityId, long collectionId, long figureId, long artistId, long themeId, long eventId, long artworkId);

    /**
     * 查询所有图片
     * @return ResultUtil
     * */
    abstract ResultUtil<List<Imgs>> selectAll();

    /**
     * 查询图片
     * @param imgId 图片主键ID
     * @return ResultUtil
     * */
    abstract ResultUtil<Imgs> selectById(long imgId);

}
