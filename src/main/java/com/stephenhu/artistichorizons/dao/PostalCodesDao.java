package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.PostalCodes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Stephen Hu
 * 邮政编码表实现基本的插入记录，删除记录（指逻辑意义上），更新记录，查询记录
 */
@Mapper
public interface PostalCodesDao extends BaseMapper<PostalCodes> {

    /**
     * 插入邮政编码记录
     * @param postalCodeId 邮政编码id
     * @param postalCode 邮政编码
     * @param description 邮政编码描述
     * @return 更新成功返回True，否则返回False
     * */
    boolean insert(long postalCodeId,String postalCode,String description);

    /**
     * 查询所有邮政编码及其详细信息记录
     * @return 所有邮政编码
     * */
    List<PostalCodes> findAll();

    /**
     * 根据id查询邮政编码记录及其详细信息
     * @param postalCodeId 邮政编码id
     * @return 邮政编码
     * */
    PostalCodes findById(long postalCodeId);

    /**
     * 根据id删除邮政编码记录（逻辑意义上）
     * @param postalCodeId 邮政编码id
     * @return 删除成功返回True，否则返回False
     * */
    boolean delById(long postalCodeId);

    /**
     * 根据id回滚邮政编码记录（逻辑意义上）
     * @param postalCodeId 邮政编码id
     * @return 回滚成功返回True，否则返回False
     * */
    boolean rollbackById(long postalCodeId);
    /**
     * 根据邮政编码查询邮政编码记录及其详细信息
     * @param postalCode 邮政编码
     * @return 邮政编码
     * */
    PostalCodes findRepeat(String postalCode);
}
