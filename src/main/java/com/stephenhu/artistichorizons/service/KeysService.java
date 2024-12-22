package com.stephenhu.artistichorizons.service;

import com.stephenhu.artistichorizons.pojo.Keys;

/**
 * @author Stephen Hu
 */
public interface KeysService {
    /**
     * 根据主键查询密钥
     * @param keyId 主键
     * @return 密钥
     * */
    Keys findById(Long keyId);
}
