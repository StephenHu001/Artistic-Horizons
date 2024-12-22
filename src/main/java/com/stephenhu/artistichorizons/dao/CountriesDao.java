package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Countries;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 国家表实现基本的增加记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface CountriesDao extends BaseMapper<Countries> {
    /**
     * 插入国家记录
     * @param countryId 国家id
     * @param countryName 国家名称
     * @param description 国家描述
     * @return 更新成功返回True，否则返回False
     * */
    boolean insert(Long countryId,String countryName,String description);

    /**
     * 查询所有国家及其详细信息记录
     * @return 所有国家
     * */
    List<Countries> findAll();

    /**
     * 根据id查询记录及其详细信息
     * @param countryId 国家国家id
     * @return 国家
     * */
    Countries findById(Long countryId);

    /**
     * 根据id删除国家记录（逻辑意义上）
     * @param countryId 国家id
     * @return 删除成功返回True，否则返回False
     * */
    boolean delById(Long countryId);

    /**
     * 回滚国家记录（逻辑意义上）
     * @param countryId 国家id
     * @return 回滚成功返回True，否则返回False
     * */
    boolean rollbackById(Long countryId);

    /**
     * 查询是否存在规定不重复字段重复
     * @param cityName 国家名称
     * @return 国家
     * */
    Countries findRepeat(String cityName);
}
