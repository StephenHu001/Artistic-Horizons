package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.PostalCodesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostalCodesServiceTest {
    @Autowired
    private PostalCodesService postalCodesService;

    @Test
    void testInsert() {
        System.out.println(postalCodesService.insert("123", "test"));
    }

    @Test
    void testDelete() {
        System.out.println(postalCodesService.delById(654262221697847296L));
    }

    @Test
    void testUpdate() {
        System.out.println(postalCodesService.updateById(654262221697847296L, "123456789", "test"));
    }

    @Test
    void testSelectAll() {
        System.out.println(postalCodesService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(postalCodesService.selectById(654262221697847296L));
    }
}
