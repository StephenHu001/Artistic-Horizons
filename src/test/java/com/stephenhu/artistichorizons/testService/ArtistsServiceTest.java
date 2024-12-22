package com.stephenhu.artistichorizons.testService;

import com.stephenhu.artistichorizons.service.ArtistsService;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtistsServiceTest {
    @Autowired
    private ArtistsService artistsService;

    @Test
    public void testInsert() {
        System.out.println(artistsService.insert("Stephen Hu", DateUtil.parseYearMonth("2024-10"), DateUtil.parseYearMonth("2023-06"), "A painter", 0, 0, 0));
    }

    @Test
    public void testDelete() {
        System.out.println(artistsService.delById(653758848280170496L));
    }

    @Test
    public void testUpdate() {
        System.out.println(artistsService.updateById(654383431379193856L, "Ste", DateUtil.parseYearMonth("2024-10"), DateUtil.parseYearMonth("2023-06"), "A painter", 0, 0, 0));
    }
    @Test
    void testSelectAll() {
        System.out.println(artistsService.selectAll());
    }

    @Test
    void testSelectById() {
        System.out.println(artistsService.selectById(653760091857752064L));
    }
}
