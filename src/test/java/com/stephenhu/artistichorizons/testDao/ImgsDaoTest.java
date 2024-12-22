package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.ImgsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImgsDaoTest {
    @Autowired
    private ImgsDao imgsDao;

    @Test
    public void testInsert() {
        try {
            boolean result = imgsDao.insert(123L, "imgPath", 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            String result = imgsDao.findById(123L).toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            System.out.println(imgsDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long imgId = 123L;
        try {
            boolean result = imgsDao.delById(imgId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
