package com.stephenhu.artistichorizons.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.stephenhu.artistichorizons.utils.ResultUtil;

/**
 * @author Stephen Hu
 */
public abstract interface AdminsService {

    /**
     * 根据account去判断用户是否存在，并返回带着公钥的ResultUtil
     * @param account 用户名
     * @return ResultUtil<String>
     * */
    abstract ResultUtil<String> toFindAccount(long account);

    /**
     * 登录
     *
     * @param account  用户名
     * @param password 密码
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> doLogin(long account, String password);

    /**
     * 登出
     * @return ResultUtil<Integer>
     * */
    abstract ResultUtil<Integer> logout();

    /**
     * 获取token信息
     *
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<SaTokenInfo> tokenInfo();

    /**
     * 登录校验
     *
     * @return ResultUtil<Integer>
     */
    abstract ResultUtil<Integer> loginCheck();

}
