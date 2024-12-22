package com.stephenhu.artistichorizons;

import com.stephenhu.artistichorizons.utils.SnowFlakeUtil;
import com.stephenhu.artistichorizons.utils.StephenHuEncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAdminInsert {
    @Test
    public void testID(){
        System.out.println(SnowFlakeUtil.getID());
    }
    @Test
    public void testPassword(){
        System.out.println(StephenHuEncryptUtil.mainEncrypt("LiZhenYu"));
    }

    @Test
    public void testRSA(){
        System.out.println(StephenHuEncryptUtil.generateKey());
    }
}
