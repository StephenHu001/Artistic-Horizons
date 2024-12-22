package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.Events;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 事件表业务逻辑层
 */
public abstract interface EventsService {

    /**
     * 插入事件
     * @param eventName 事件名称
     * @param description 事件描述
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> insert(String eventName, String description);

    /**
     * 删除事件
     * @param eventId 事件ID
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> delById(long eventId);

    /**
     * 更新事件
     * @param eventId 事件ID
     * @param eventName 事件名称
     * @param description 事件描述
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> updateById(long eventId, String eventName, String description);

    /**
     * 查询所有事件
     * @return ResultUtil<List<Events>>
     */
    abstract ResultUtil<List<Events>> selectAll();

    /**
     * 根据事件ID查询事件
     * @param eventId 事件ID
     * @return ResultUtil<Events>
     */
    abstract ResultUtil<Events> selectById(long eventId);
}
