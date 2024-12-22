package com.stephenhu.artistichorizons.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stephenhu.artistichorizons.pojo.Imgs;
import com.stephenhu.artistichorizons.pojo.Keys;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Stephen Hu
 */
@Mapper
public interface KeysDao extends BaseMapper<Keys> {
    /**
     * 通过ID查询钥匙
     * @param keyId 钥匙ID
     * @return keys
     * */
    Keys findById(Long keyId);
}
