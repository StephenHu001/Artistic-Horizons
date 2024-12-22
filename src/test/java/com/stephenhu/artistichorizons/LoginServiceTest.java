package com.stephenhu.artistichorizons;

import com.stephenhu.artistichorizons.dao.AdminsDao;
import com.stephenhu.artistichorizons.dao.KeysDao;
import com.stephenhu.artistichorizons.pojo.Admins;
import com.stephenhu.artistichorizons.pojo.Keys;
import com.stephenhu.artistichorizons.service.AdminsService;
import com.stephenhu.artistichorizons.service.KeysService;
import com.stephenhu.artistichorizons.utils.ResultUtil;
import com.stephenhu.artistichorizons.utils.StephenHuEncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private AdminsService adminsService;

    @Autowired
    private KeysService keysService;

    @Autowired
    private KeysDao keysDao;
    @Autowired
    private AdminsDao adminsDao;

    @Test
    public void testService() {
        try {
            Admins admin = adminsDao.findAdmin(3474584031L);
            System.out.println(admin);
            if (admin != null) {
                System.out.println(admin.getKeyId());
//                Keys key = keysService.findById(Long.valueOf(admin.getKeyId()));
//                System.out.println(key.getPublicKey());
            } else {
                System.out.println("Wrong, Please Check Your Account And Password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testDao() {
        System.out.println(adminsDao.findAdmin(3474584031L));
    }

    @Test
    public void testGetKey() {
        Map<String, String> keyMap = StephenHuEncryptUtil.generateKey();
        String publicKeyStr = keyMap.get("publicKeyStr");
        String privateKeyStr = keyMap.get("privateKeyStr");
        System.out.println(publicKeyStr);
        System.out.println(privateKeyStr);
    }

    @Test
    public void loginTest() throws Exception {
        //前端模拟账号密码
        long account = 3474584031L;
        String password = "20021004@Dahuzi";

        //这是登录第一步，先要验证账号存在,存在后端就给出公钥给前端
        ResultUtil<String> result1 = adminsService.toFindAccount(account);
        //给出的公钥是以下
        System.out.println(result1.getData().toString());

        //模拟前端根据公钥加密后的密码
        String encrypt = StephenHuEncryptUtil.encryptByPublicKey(password, result1.getData().toString());
        //前端加密后打给后端的密码
        System.out.println(encrypt);

        //这是登录第二步，后端根据账户名和加密的密码，去进行验证
        ResultUtil<Integer> result2 = adminsService.doLogin(account, encrypt);
        //得到状态
        System.out.println(result2);
    }
    @Test
    public void test() throws Exception {
        String publicKey1 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzcQW4ntkv6JyFciN2F4hxNLirkJM62MKkECAhYKqxb1RU8Uo493pnZPe8lAuHmFWta8VIkmnC65QxnJWuDmCuEtIG0XIYWtJy/TprA+Ybgji+53eiujhzPl3YPdOFK86gT3V0XF5FiIGUZeUWrgirQuVnKAIfCoAaESXA7I4cTa24t1IZENrGW7CIpbAW5ktZ8HR+KVa6uQHObR6N";
        String publicKey2 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzcQW4ntkv6JyFciN2F4hxNLirkJM62MKkECAhYKqxb1RU8Uo493pnZPe8lAuHmFWta8VIkmnC65QxnJWuDmCuEtIG0XIYWtJy/TprA+Ybgji+53eiujhzPl3YPdOFK86gT3V0XF5FiIGUZeUWrgirQuVnKAIfCoAaESXA7I4cTa24t1IZENrGW7CIpbAW5ktZ8HR+KVa6uQHObR6N5ycZafjavj3FbdJmomyE/JOTax8FRfYIt895IJAtdF5ckSLyRrJQ4fSV0+W+7qTUVSGCeLtpQrTGSv0rIO6eQp/ghlj281i9okFxli6aS5Dp4g5Z9n9XMJNmzD8VfmQY+y4wIDAQAB";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTNxBbie2S/onIVyI3YXiHE0uKuQkzrYwqQQICFgqrFvVFTxSjj3emdk97yUC4eYVa1rxUiSacLrlDGcla4OYK4S0gbRchha0nL9OmsD5huCOL7nd6K6OHM+Xdg904UrzqBPdXRcXkWIgZRl5RauCKtC5WcoAh8KgBoRJcDsjhxNrbi3UhkQ2sZbsIilsBbmS1nwdH4pVrq5";
        String Data = "OmcpDQidHUY61b8ZWoPn0Ic7dFnBiIxV2PflS3pN/EGe91yRSy65Lk9d7D4U56KTcxyvuQ0xTdZn72h0XsZF+VI2d6uB4bR5dXxfXsbMq3UFVOQpihExvnSFfQhjHkRRi5kx7ZW51sgt76ME7Cq37FenLy8DsuV72H2h/q8ajLxXcSmen7z66vDBVFPgeQzxB48xwdTLZSLWujQdbCv+2bx3fr8u8XI1iIltAzIf5kxZ8O04OSHIKrnu+UUIk8lXqPy5+IVgcolBXAM3apViewW7ku4fknAGn1iQdhA5G+mpgxhxsVxQissEc0YK1tXd10QSCkp+q6ZSdOOwWsCEnA==";
        // 私钥解密
        String decrypt = StephenHuEncryptUtil.decryptByPrivateKey(Data, privateKey);
    }
}
