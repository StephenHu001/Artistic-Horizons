package com.stephenhu.artistichorizons.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stephen Hu
 * Knife4j整合Swagger3 Api接口文档
 */
@Configuration
@EnableKnife4j
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi adminApi() { // 创建了一个api接口的分组
        return GroupedOpenApi.builder()
                .group("admin-api") // 分组名称
                .pathsToMatch("/**") // 接口请求路径规则
                .build();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                // 基本信息配置
                .info(new Info()
                        .title("Knife4j加强接口文档")
                        .description("Knife4j加强Swagger后端接口服务")
                        .version("v1.0.0")
                        // 设置OpenAPI文档的联系信息，包括联系人姓名为"patrick"，邮箱为"patrick@gmail.com"。
                        .contact(new Contact().name("Stephen Hu").email("stephenhu031028@gmail.com"))
                        // 设置OpenAPI文档的许可证信息，包括许可证名称为"Apache 2.0"，许可证URL为"http://springdoc.org"。
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Artistic Horizons项目API文档")
                        .url("/"));
    }
}
