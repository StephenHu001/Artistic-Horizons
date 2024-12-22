package com.stephenhu.artistichorizons.testDao;

import com.stephenhu.artistichorizons.dao.FiguresDao;
import com.stephenhu.artistichorizons.pojo.Figures;
import com.stephenhu.artistichorizons.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class FiguresDaoTest {

    @Autowired
    private FiguresDao figuresDao;

    @Test
    public void testInsert() {
        try {
            long figureId = 123L;
            String figureName = "Vincent van Gogh";
            Date birthDate = DateUtil.parseDate("1853-03-30");
            Date deathDate = DateUtil.parseDate("1890-07-29");
            String description = "Dutch post-impressionist painter";
            long cityId = 1L;
            long eventId = 1L;
            boolean result = figuresDao.insert(figureId, figureName, birthDate, deathDate, description, cityId, eventId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            long figureId = 123L;
            System.out.println(figuresDao.findById(figureId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            List<Figures> figuresList = figuresDao.findAll();
            System.out.println(figuresList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelById() {
        try {
            long figureId = 123L;
            boolean result = figuresDao.delById(figureId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
