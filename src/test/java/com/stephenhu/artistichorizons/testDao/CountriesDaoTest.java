package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.CountriesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountriesDaoTest {
    @Autowired
    private CountriesDao countriesDao;

    @Test
    public void testInsert() {
        try {
            long countryId = 123L;
            String countryName = "America";
            String description = "美利坚合众国";
            boolean result = countriesDao.insert(countryId, countryName, description);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long countryId = 123L;
            System.out.println(countriesDao.findById(countryId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = countriesDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long colorId = 123L;
        try {
            boolean result = countriesDao.delById(colorId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
