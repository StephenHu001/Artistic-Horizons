package com.stephenhu.artistichorizons.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.stephenhu.artistichorizons.dao.AdminsDao;
import com.stephenhu.artistichorizons.pojo.Admins;
import com.stephenhu.artistichorizons.pojo.Keys;
import com.stephenhu.artistichorizons.service.AdminsService;
import com.stephenhu.artistichorizons.service.KeysService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import com.stephenhu.artistichorizons.utils.StephenHuEncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stephen Hu
 */
@Service
public final
class AdminsServiceImpl implements AdminsService {

    @Autowired
    private AdminsDao adminsDao;
    @Autowired
    private KeysService keysService;

    @Override
    public ResultUtil<String> toFindAccount(long account) {
        try {
            Admins admin = adminsDao.findAdmin(account);
            if (admin != null) {
                Keys key = keysService.findById(Long.valueOf(admin.getKeyId()));
                return ResultUtil.success(key.getPublicKey());
            } else {
                return ResultUtil.fail(400, "Wrong, Please Check Your Account");
            }
        } catch (Exception e) {
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> doLogin(long account, String password) {
        try {
            // 再查找一遍
            Admins admin = adminsDao.findAdmin(account);
            if (admin == null) {
                return ResultUtil.fail(400, "Wrong, Please Check Your Account And Password");
            }
            // 得到用户钥匙信息
            Keys key = keysService.findById(Long.valueOf(admin.getKeyId()));
            if (key == null) {
                return ResultUtil.fail(400, "Key not found");
            }
            // 通过私钥解密，获得未加密的用户原始信息
            String decrypt = StephenHuEncryptUtil.decryptByPrivateKey(password, key.getPrivateKey());
            // 通过MD5加密，得到加密后的密码与数据库比对
            if (StephenHuEncryptUtil.mainEncrypt(decrypt).equals(admin.getPassword())) {
                StpUtil.login(admin.getAdminId());
                return ResultUtil.success(200);
            } else {
                return ResultUtil.fail(400, "Wrong, Please Check Your Account And Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail(401, e.toString());
        }
    }

    @Override
    public ResultUtil<Integer> logout() {
        try {
            StpUtil.logout();
            return ResultUtil.success(200);
        } catch (Exception e) {
            return ResultUtil.fail(400, "Please Login First");
        }
    }

    @Override
    public ResultUtil<SaTokenInfo> tokenInfo() {
        return ResultUtil.success(StpUtil.getTokenInfo());
    }

    @Override
    public ResultUtil<Integer> loginCheck() {
        try {
            // 检查是否已登录
            StpUtil.checkLogin();
            return ResultUtil.success(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // 如果未登录或其他异常，返回未登录的提示
            return ResultUtil.fail(400, "Please Login First");
        }
    }

}
