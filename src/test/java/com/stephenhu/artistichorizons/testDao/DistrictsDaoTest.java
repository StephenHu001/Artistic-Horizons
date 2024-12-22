package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.DistrictsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictsDaoTest {
    @Autowired
    private DistrictsDao districtsDao;

    @Test
    public void testInsert() {
        try {
            long districtId = 123L;
            String districtName = "test";
            String description = "test";
            long countryId = 1L;
            boolean result = districtsDao.insert(districtId, districtName, description, countryId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long distinctId = 123L;
            System.out.println(districtsDao.findById(distinctId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = districtsDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long distinctId = 123L;
        try {
            boolean result = districtsDao.delById(distinctId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
