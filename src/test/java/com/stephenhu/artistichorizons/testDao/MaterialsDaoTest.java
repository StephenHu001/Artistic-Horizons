package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.MaterialsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MaterialsDaoTest {

    @Autowired
    private MaterialsDao materialsDao;

    @Test
    public void testInsert() {
        try {
            long materialId = 123L;
            String materialName = "印刷";
            boolean result = materialsDao.insert(materialId, materialName);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long materialId = 123L;
            System.out.println(materialsDao.findById(materialId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = materialsDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long materialId = 123L;
        try {
            boolean result = materialsDao.delById(materialId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
