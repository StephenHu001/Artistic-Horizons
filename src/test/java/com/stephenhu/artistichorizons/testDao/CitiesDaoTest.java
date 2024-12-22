package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.CitiesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CitiesDaoTest {

    @Autowired
    private CitiesDao citiesDao;

    @Test
    public void testInsert() {
        try {
            long cityId = 123456789L;
            String cityName = "保山";
            String description = "Test";
            Long districtId = 1L;
            Long postalCodeId = 1L;
            boolean result = citiesDao.insert(cityId, cityName, description, districtId, postalCodeId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            long cityId = 123456789L;
            System.out.println(citiesDao.findById(cityId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            String result = citiesDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long cityId = 123456789L;
        try {
            boolean result = citiesDao.delById(cityId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
