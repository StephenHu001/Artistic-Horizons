package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.PostalCodesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostalCodesDaoTest {

    @Autowired
    private PostalCodesDao postalCodesDao;

    @Test
    public void testInsert() {
        try {
            long id = 123L;
            String postalCode = "china:123456";
            String description = "This a test";
            boolean result = postalCodesDao.insert(id,postalCode,description);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long id = 123L;
            System.out.println(postalCodesDao.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = postalCodesDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long id = 123L;
        try {
            boolean result = postalCodesDao.delById(id);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
