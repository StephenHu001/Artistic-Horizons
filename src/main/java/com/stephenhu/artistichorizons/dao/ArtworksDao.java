package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Artworks;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 艺术品表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface ArtworksDao extends BaseMapper<Artworks> {
    /**
     * 插入艺术家记录
     *
     * @param artworkId    艺术品id
     * @param artworkName  艺术品名称
     * @param createTime   创建时间
     * @param description  艺术品描述
     * @param materialId   材质id
     * @param colorId      颜色id
     * @param artistId     艺术家id
     * @param eventId      事件id
     * @param collectionId 藏馆id
     * @param themeId      主题id
     * @return 插入成功返回True，否则返回False
     */
    boolean insert(long artworkId, String artworkName, Date createTime, String description, long materialId, long colorId, long artistId, long eventId, long collectionId, long themeId);

    /**
     * 查询所有艺术家记录及其详细信息
     *
     * @return 艺术家列表
     */
    List<Artworks> findAll();

    /**
     * 根据id查询艺术家记录及其详细信息
     *
     * @param artworkId 艺术家id
     * @return 艺术家
     */
    Artworks findById(long artworkId);

    /**
     * 根据id删除艺术家记录（逻辑意义上）
     *
     * @param artworkId 艺术家id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long artworkId);

    /**
     * 根据id回滚删除记录（逻辑意义上）
     *
     * @param artworkId 艺术品id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(long artworkId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param artworkName 艺术品名称
     * @return 艺术品
     */
    Artworks findRepeat(String artworkName);
}
