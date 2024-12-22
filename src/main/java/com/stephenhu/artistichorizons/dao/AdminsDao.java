package com.stephenhu.artistichorizons.dao;

import com.stephenhu.artistichorizons.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Stephen Hu
 */
@Mapper
public interface AdminsDao {
    /**
     * 获得管理员
     * @param account 账号
     * @return Admins
     */
    Admins findAdmin(long account);
}
