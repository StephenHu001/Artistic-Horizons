package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Districts;

import java.util.List;

/**
 * @author Stephen Hu
 * 区域表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
public interface DistrictsDao extends BaseMapper<Districts> {
    /**
     * 插入区域记录
     * @param districtId   区域id
     * @param districtName 区域名称
     * @param description  区域描述
     * @param countryId    国家id
     * @return 更新成功返回True，否则返回False
     */
    boolean insert(Long districtId, String districtName, String description, Long countryId);

    /**
     * 查询所有区域及其详细信息记录
     * @return 所有区域
     */
    List<Districts> findAll();

    /**
     * 根据id查询事件记录及其详细信息
     *
     * @param districtId 区域id
     * @return 区域
     */
    Districts findById(Long districtId);

    /**
     * 根据id删除事件记录（逻辑意义上）
     *
     * @param districtId 区域id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(Long districtId);

    /**
     * 根据id回滚事件记录（逻辑意义上）
     *
     * @param districtId 区域id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(Long districtId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param districtName 区域名称
     * @return 区域
     * */
    Districts findRepeat(String districtName);
}
