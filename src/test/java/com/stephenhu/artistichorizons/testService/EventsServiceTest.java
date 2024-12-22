package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.EventsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventsServiceTest {
    @Autowired
    private EventsService eventsService;

    @Test
    void testInsert(){
        System.out.println(eventsService.insert("test","test"));
    }
    @Test
    void testDelete() {
        System.out.println(eventsService.delById(654125260744036352L));
    }

    @Test
    void testUpdate() {
        System.out.println(eventsService.updateById(654125260744036352L,"updateTest","updateTest"));
    }

    @Test
    void testSelectAll() {
        System.out.println(eventsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(eventsService.selectById(654125260744036352L));
    }
}
