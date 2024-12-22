package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.MaterialsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MaterialsServiceTest {
    @Autowired
    private MaterialsService materialsService;

    @Test
    void testInsert(){
        System.out.println(materialsService.insert("test"));
    }
    @Test
    void testDelete() {
        System.out.println(materialsService.delById(654253723039698944L));
    }

    @Test
    void testUpdate() {
        System.out.println(materialsService.updateById(654253723039698944L, "test"));
    }

    @Test
    void testSelectAll() {
        System.out.println(materialsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(materialsService.selectById(654253723039698944L));
    }
}
