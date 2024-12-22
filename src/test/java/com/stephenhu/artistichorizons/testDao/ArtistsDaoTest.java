package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.ArtistsDao;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtistsDaoTest {
    @Autowired
    private ArtistsDao artistsDao;


    @Test
    public void testInsert() {
        try {
            boolean result = artistsDao.insert(123L, "Stephen Hu", DateUtil.parseDate("1988-01-01"), DateUtil.parseDate("2023-01-01"), "A software engineer", 1L, 1L, 1L);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            System.out.println(artistsDao.findById(123L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            System.out.println(artistsDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        try {
            boolean result = artistsDao.delById(123L);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
