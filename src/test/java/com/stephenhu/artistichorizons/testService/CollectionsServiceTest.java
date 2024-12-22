package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.CollectionsService;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CollectionsServiceTest {
    @Autowired
    private CollectionsService collectionsService;

    @Test
    void testInsert(){
        System.out.println(collectionsService.insert("test","test", DateUtil.parseYear("2024"),0L));
    }
    @Test
    void testDelete() {
        System.out.println(collectionsService.delById(654105530985484288L));
    }

    @Test
    void testUpdate() {
        System.out.println(collectionsService.updateById(654070146960330752L,"testUpdate","test",DateUtil.parseYear("2024"),0L));
    }

    @Test
    void testSelectAll() {
        System.out.println(collectionsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(collectionsService.selectById(6541055309854842888L));
    }
}
