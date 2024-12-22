package com.stephenhu.artistichorizons.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Stephen Hu
 * @since 2024-12-14
 * @description 解决long型在前端精度丢失全局配置问题
 */
@Configuration
public class JacksonToObjectConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.serializerByType(Long.class, ToStringSerializer.instance);
        };
    }
}
