package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.CollectionsDao;
import com.stephenhu.artistichorizons.pojo.Collections;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CollectionsDaoTest {

    @Autowired
    private CollectionsDao collectionsDao;

    @Test
    public void testInsert() {
        try {
            long collectionId = 123456789L;
            String collectionName = "Beijing Museum";
            String description = "A famous museum in Beijing";
            Date createTime = DateUtil.parseYear("2024");
            long cityId = 1L;
            boolean result = collectionsDao.insert(collectionId, collectionName, description, createTime, cityId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            long collectionId = 123456789L;
            System.out.println(collectionsDao.findById(collectionId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            List<Collections> collectionsList = collectionsDao.findAll();
            System.out.println(collectionsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long collectionId = 123456789L;
        try {
            boolean result = collectionsDao.delById(collectionId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
