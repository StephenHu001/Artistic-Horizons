package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.CitiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CitiesServiceTest {
    @Autowired
    private CitiesService citiesService;

    @Test
    void testInsert(){
        System.out.println(citiesService.insert("test","test",0L,0L));
    }
    @Test
    void testDelete() {
        System.out.println(citiesService.delById(654070146960330752L));
    }

    @Test
    void testUpdate() {
        System.out.println(citiesService.updateById(654070146960330752L,"testUpdate","test",0L,0L));
    }

    @Test
    void testSelectAll() {
        System.out.println(citiesService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(citiesService.selectById(0L));
    }
}
