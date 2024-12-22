package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.ImgsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImgsServiceTest {
    @Autowired
    private ImgsService imgsService;

    @Test
    void testInsert(){
        System.out.println(imgsService.insert("test",0,0,0,0,0,0,0,0,0,0,0));
    }
    @Test
    void testDelete() {
        System.out.println(imgsService.delById(654138794953543680L));
    }

    @Test
    void testUpdate() {
        System.out.println(imgsService.updateById(654138794953543680L, "testUpdate",0,0,0,0,0,0,0,0,0,0,0));
    }

    @Test
    void testSelectAll() {
        System.out.println(imgsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(imgsService.selectById(654130903521562624L));
    }
}
