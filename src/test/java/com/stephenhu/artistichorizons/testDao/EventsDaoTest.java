package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.EventsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventsDaoTest {
    @Autowired
    private EventsDao eventsDao;

    @Test
    public void testInsert() {
        try {
            long eventId = 123L;
            String eventName = "二战同盟国";
            String description = "This a test";
            boolean result = eventsDao.insert(eventId,eventName,description);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindById() {
        try {
            long eventId = 123L;
            System.out.println(eventsDao.findById(eventId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAll() {
        try {
            String result = eventsDao.findAll().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        long eventId = 123L;
        try {
            boolean result = eventsDao.delById(eventId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
