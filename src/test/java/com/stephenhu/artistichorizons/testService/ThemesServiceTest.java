package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.ThemesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThemesServiceTest {
    @Autowired
    private ThemesService themesService;

    @Test
    void testInsert() {
        System.out.println(themesService.insert("三战"));
    }

    @Test
    void testDelete() {
        System.out.println(themesService.delById(654271599595360256L));
    }

    @Test
    void testUpdate() {
        System.out.println(themesService.updateById(654272758594801664L, "二战"));
    }

    @Test
    void testSelectAll() {
        System.out.println(themesService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(themesService.selectById(654271599595360256L));
    }
}
