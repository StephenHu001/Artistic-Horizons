package com.stephenhu.artistichorizons.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Hu
 */
@Component
@ConfigurationProperties(prefix = "snowflake")
@Data
public class SnowFlakeConfig {
    private long startTimeStamp;
    private long workID;
    private long dataCenterID;
}
