package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Figures;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Stephen Hu
 * 历史人物表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface FiguresDao extends BaseMapper<Figures> {
    /**
     * 插入历史人物记录
     *
     * @param figureId    历史人物id
     * @param figureName  历史人物名称
     * @param birthDate   出生日期
     * @param deathDate   死亡日期
     * @param description 描述
     * @param cityId      城市id
     * @param eventId     事件id
     * @return 插入成功返回True，否则返回False
     */
    boolean insert(long figureId, String figureName, Date birthDate, Date deathDate, String description, long cityId, long eventId);

    /**
     * 查询所有艺术人物记录及其详细信息
     *
     * @return 历史人物列表
     */
    List<Figures> findAll();

    /**
     * 根据id查询艺术人物记录及其详细信息
     *
     * @param figureId 历史人物id
     * @return 历史人物
     */
    Figures findById(long figureId);

    /**
     * 根据id删除历史人物记录（逻辑意义上）
     *
     * @param figureId 历史人物id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long figureId);

    /**
     * 根据id回滚历史人物记录（逻辑意义上）
     *
     * @param figureId 历史人物id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(long figureId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param figureName 历史人物名称
     * @return 历史人物
     * */
    Figures findRepeat(String figureName);
}
