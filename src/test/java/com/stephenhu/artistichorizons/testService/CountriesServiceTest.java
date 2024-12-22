package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.CountriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountriesServiceTest {
    @Autowired
    private CountriesService countriesService;

    @Test
    void testInsert(){
        System.out.println(countriesService.insert("test","test"));
    }
    @Test
    void testDeleteColor() {
        System.out.println(countriesService.delById(654113124391194624L));
    }

    @Test
    void testUpdateColor() {
        System.out.println(countriesService.updateById(654113124391194624L,"updateTest","updateTest"));
    }

    @Test
    void testSelectAll() {
        System.out.println(countriesService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(countriesService.selectById(654113124391194624L));
    }
}
