package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.ColorsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ColorServiceTest {
    @Autowired
    private ColorsService colorsService;

    @Test
    void testInsert(){
        System.out.println(colorsService.insert("test","test"));
    }
    @Test
    void testDelete() {
        System.out.println(colorsService.delById(0L));
    }

    @Test
    void testUpdate() {
        System.out.println(colorsService.updateById(0,"updateTest","updateTest"));
    }

    @Test
    void testSelectAll() {
        System.out.println(colorsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(colorsService.selectById(0L));
    }
}
