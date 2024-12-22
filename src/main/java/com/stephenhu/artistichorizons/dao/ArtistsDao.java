package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Artists;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 艺术家表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface ArtistsDao extends BaseMapper<Artists> {
    /**
     * 插入艺术家记录
     * @param artistId 艺术家id
     * @param artistName 艺术家名称
     * @param birthDate 出生日期
     * @param deathDate 死亡日期
     * @param description 描述
     * @param cityId 城市id
     * @param themeId 主题id
     * @param eventId 事件id
     * @return 插入成功返回True，否则返回False
     */
    boolean insert(long artistId, String artistName, Date birthDate, Date deathDate, String description, long cityId, long themeId, long eventId);

    /**
     * 查询所有艺术家记录及其详细信息
     * @return 艺术家列表
     */
    List<Artists> findAll();

    /**
     * 根据id查询艺术家记录及其详细信息
     * @param artistId 艺术家id
     * @return 艺术家
     */
    Artists findById(long artistId);

    /**
     * 根据id删除艺术家记录（逻辑意义上）
     * @param artistId 艺术家id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long artistId);

    /**
     * 根据id回滚删除记录（逻辑意义上）
     * @param artistId 艺术家id
     * @return 返回true，否则返回false
     * */
    boolean rollbackById(long artistId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param artistName 艺术家名称
     * @return 艺术家
     */
    Artists findRepeat(String artistName);
}
