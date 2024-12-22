package com.stephenhu.artistichorizons.service;
import com.stephenhu.artistichorizons.pojo.PostalCodes;
import com.stephenhu.artistichorizons.utils.ResultUtil;

import java.util.List;

/**
 * @author Stephen Hu
 * 邮政编码表业务逻辑层
 */
public abstract interface PostalCodesService {

    /**
     * 插入数据
     * @param postalCode 邮政编码
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> insert(String postalCode, String description);

    /**
     * 删除数据
     * @param postalCodeId 邮政编码id
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> delById(long postalCodeId);

    /**
     * 更新数据
     * @param postalCodeId 邮政编码id
     * @param postalCode 邮政编码
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> updateById(long postalCodeId, String postalCode,String description);

    /**
     * 查询数据
     * @return ResultUtil<List<PostalCodes>>
     * */
    abstract ResultUtil<List<PostalCodes>> selectAll();

    /**
     * 查询数据
     * @param postalCodeId 邮政编码id
     * @return ResultUtil<PostalCodes>
     * */
    abstract ResultUtil<PostalCodes> selectById(long postalCodeId);
}
