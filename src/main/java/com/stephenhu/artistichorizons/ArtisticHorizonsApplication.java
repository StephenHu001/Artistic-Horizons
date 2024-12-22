package com.stephenhu.artistichorizons;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Stephen Hu
 */
@SpringBootApplication
@MapperScan("com.stephenhu.artistichorizons.dao")
public class ArtisticHorizonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtisticHorizonsApplication.class, args);
    }

}
