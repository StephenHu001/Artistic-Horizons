package com.stephenhu.artistichorizons.service.impl;

import com.stephenhu.artistichorizons.dao.KeysDao;
import com.stephenhu.artistichorizons.pojo.Keys;
import com.stephenhu.artistichorizons.service.KeysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stephen Hu
 */
@Service
public final class KeysServiceImpl implements KeysService {
    @Autowired
    private KeysDao keysDao;

    @Override
    public Keys findById(Long keyId) {
        return keysDao.findById(keyId);
    }
}
