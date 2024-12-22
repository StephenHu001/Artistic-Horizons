package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.ArtworksService;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtworksServiceTest {
    @Autowired
    private ArtworksService artworksService;

    @Test
    void testInsert() {
        System.out.println(artworksService.insert("test", DateUtil.parseYear("2024"), "test", 0L, 0L, 0L, 0L, 0L, 0L));
    }

    @Test
    void testDelete() {
        System.out.println(artworksService.delById(654050740997853184L));
    }

    @Test
    void testUpdate() {
        System.out.println(artworksService.updateById(654050740997853184L, "testUpdate", DateUtil.parseYear("2024"), "test", 0L, 0L, 0L, 0L, 0L, 0L));
    }

    @Test
    void testSelectAll() {
        System.out.println(artworksService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(artworksService.selectById(654050740997853184L));
    }
}
