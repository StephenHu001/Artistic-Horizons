package com.stephenhu.artistichorizons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author Stephen Hu
 */
@Configuration
public class ApplicationConfig {

    @Value("${server.port:8888}")
    private String serverPort;

    @Value("${springdoc.swagger-ui.path:/swagger-ui.html}")
    private String swaggerPath;

    @Bean
    public ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String applicationName = environment.getProperty("spring.application.name", "SwaggerTest");
            
            System.out.println("----------------------------------------------------------------");
            System.out.printf("       应用(%s)启动成功！%n",applicationName);
            System.out.printf("       本地访问地址: http://localhost:%s\n",serverPort);
            System.out.printf("       外部访问地址: http://%s:%s\n",hostAddress,serverPort);
            System.out.printf("       Swagger文档: http://localhost:%s%s\n",serverPort,swaggerPath);
            System.out.println("-----------------------------------------------------------------");
        };
    }
} 