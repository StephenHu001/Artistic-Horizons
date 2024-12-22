package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.ThemesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThemesDaoTest {
    @Autowired
    private ThemesDao themesDao;

    @Test
    public void testInsert() {
        try {
            long themeId = 123L;
            String themeName = "文艺复兴";
            boolean result = themesDao.insert(themeId, themeName);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long themeId = 123L;
            System.out.println(themesDao.findById(themeId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = themesDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long themeId = 123L;
        try {
            boolean result = themesDao.delById(themeId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
