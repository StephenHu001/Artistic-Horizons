package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.ArtworksDao;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtworksDaoTest {

    @Autowired
    private ArtworksDao artworksDao;

    @Test
    public void testInsert() {
        try {
            boolean result = artworksDao.insert(123L, "Test Artwork", DateUtil.parseYear("1992"), "Test artwork description", 0L, 0L, 0L, 0L, 0L, 0L);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            System.out.println(artworksDao.findById(123L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            System.out.println(artworksDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        try {
            boolean result = artworksDao.delById(123L);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
