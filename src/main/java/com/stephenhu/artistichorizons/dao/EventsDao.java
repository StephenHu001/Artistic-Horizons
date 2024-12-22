package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Events;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 事件表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface EventsDao extends BaseMapper<Events> {
    /**
     * 插入事件记录
     * @param eventId     事件id
     * @param eventName   事件名称
     * @param description 事件描述
     * @return 更新成功返回True，否则返回False
     */
    boolean insert(Long eventId, String eventName, String description);

    /**
     * 查询所有事件及其详细信息记录
     * @return 所有事件
     */
    List<Events> findAll();

    /**
     * 根据id查询事件记录及其详细信息
     * @param eventId 事件id
     * @return 事件
     */
    Events findById(Long eventId);

    /**
     * 根据id删除事件记录（逻辑意义上）
     * @param eventId 事件id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(Long eventId);

    /**
     * 根据id回滚事件记录（逻辑意义上）
     * @param eventId 事件id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(Long eventId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param eventName 事件名称
     * @return 事件
     * */
    Events findRepeat(String eventName);
}
