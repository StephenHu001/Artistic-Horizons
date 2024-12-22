package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.ColorsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ColorsDaoTest {

    @Autowired
    private ColorsDao colorsDao;

    @Test
    public void testInsert() {
        try {
            long colorId = 123L;
            String colorName = "test";
            String colorRgb = "#test";
            boolean result = colorsDao.insert(colorId, colorName, colorRgb);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long colorId = 1345L;
            System.out.println(colorsDao.findById(colorId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = colorsDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long colorId = 123L;
        try {
            boolean result = colorsDao.delById(colorId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
