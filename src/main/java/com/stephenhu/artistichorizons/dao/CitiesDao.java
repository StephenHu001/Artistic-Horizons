package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Cities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 城市表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface CitiesDao extends BaseMapper<Cities> {
    /**
     * 插入城市记录
     * @param cityId 城市id
     * @param cityName 城市名称
     * @param description 城市描述
     * @param districtId 区域id
     * @param postalCodeId 邮政编码
     * @return 插入成功返回True，否则返回False
     */
    boolean insert(long cityId, String cityName, String description, Long districtId, Long postalCodeId);

    /**
     * 查询所有城市记录及其详细信息
     * @return 城市列表
     */
    List<Cities> findAll();

    /**
     * 根据id查询城市记录及其详细信息
     * @param cityId 城市id
     * @return 城市
     */
    Cities findById(long cityId);

    /**
     * 根据id删除城市记录（逻辑意义上）
     * @param cityId 城市id
     * @return 删除成功返回True，否则返回False
     */
    boolean delById(long cityId);

    /**
     * 根据id回滚删除记录（逻辑意义上）
     *
     * @param cityId 城市id
     * @return 回滚成功返回True，否则返回False
     */
    boolean rollbackById(long cityId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param cityName 艺术品名称
     * @return 城市
     */
    Cities findRepeat(String cityName);
}
