package com.stephenhu.artistichorizons.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

/**
 * @author Stephen Hu
 */
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Artistic Horizons")
                        .description("Swagger3接口文档")
                        .version("v1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Artistic Horizons项目API文档")
                        .url("/"));
    }
}
