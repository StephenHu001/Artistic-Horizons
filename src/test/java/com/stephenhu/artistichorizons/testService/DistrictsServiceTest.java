package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.DistrictsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictsServiceTest {
    @Autowired
    private DistrictsService districtsService;

    @Test
    void testInsert(){
        System.out.println(districtsService.insert("test","test",0));
    }
    @Test
    void testDelete() {
        System.out.println(districtsService.delById(654119296028512256L));
    }

    @Test
    void testUpdate() {
        System.out.println(districtsService.updateById(654119296028512256L,"updateTest","updateTest",0));
    }

    @Test
    void testSelectAll() {
        System.out.println(districtsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(districtsService.selectById(654119296028512256L));
    }
}
