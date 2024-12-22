package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Imgs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 图片表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface ImgsDao extends BaseMapper<Imgs> {
    /**
     * 插入图片记录
     *
     * @param imgId        图片id
     * @param imgPath      图片路径
     * @param colorId      颜色id
     * @param materialId   材质id
     * @param countryId    国家id
     * @param districtId   地区id
     * @param cityId       城市id
     * @param collectionId 藏馆id
     * @param figureId     历史人物id
     * @param artistId     艺术家id
     * @param themeId      主题id
     * @param eventId      事件id
     * @param artworkId    作品id
     * @return 更新成功返回True，否则返回False
     */
    boolean insert(long imgId,
                   String imgPath,
                   long colorId,
                   long materialId,
                   long countryId,
                   long districtId,
                   long cityId,
                   long collectionId,
                   long figureId,
                   long artistId,
                   long themeId,
                   long eventId,
                   long artworkId);

    /**
     * 查询所有图片及其详细信息记录
     *
     * @return 所有图片
     */
    List<Imgs> findAll();

    /**
     * 根据id查询图片记录及其详细信息
     *
     * @param imgId 图片id
     * @return 邮政编码
     */
    Imgs findById(Long imgId);

    /**
     * 根据id删除图片记录（逻辑意义上）
     *
     * @param imgId 材质id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(Long imgId);

    /**
     * 根据id恢复图片记录（逻辑意义上）
     *
     * @param imgId 图片id
     * @return 恢复成功返回True，否则返回False
     */
    boolean rollbackById(Long imgId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param imgPath 图片路径
     * @return 图片
     * */
    Imgs findRepeat(String imgPath);
}
