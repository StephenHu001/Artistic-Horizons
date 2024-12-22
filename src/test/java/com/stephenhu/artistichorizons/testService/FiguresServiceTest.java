package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.FiguresService;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FiguresServiceTest {
    @Autowired
    private FiguresService figuresService;

    @Test
    void testInsert(){
        System.out.println(figuresService.insert("test", DateUtil.parseYear("1992"),DateUtil.parseYear("1992"),"test",0,0));
    }
    @Test
    void testDelete() {
        System.out.println(figuresService.delById(654130903521562624L));
    }

    @Test
    void testUpdate() {
        System.out.println(figuresService.updateById(554130903521562624L,"testUpdate", DateUtil.parseYear("1992"),DateUtil.parseYear("1992"),"test",0,0));
    }

    @Test
    void testSelectAll() {
        System.out.println(figuresService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(figuresService.selectById(654130903521562624L));
    }
}
