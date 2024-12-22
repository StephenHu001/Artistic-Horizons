package com.stephenhu.artistichorizons.config;

import cn.dev33.satoken.SaManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author Stephen Hu
 * 伪图形化界面以供快速进入地址，避免重复输入地址
 * @data 2024/10/1 国庆节福利
 * 在国庆节福利基础上进行拓展 2024/11/24
 */
@Configuration
public class ApplicationConfig {

    @Value("${server.port:8888}")
    private String serverPort;

    @Value("${springdoc.swagger-ui.path:/swagger-ui.html}")
    private String swaggerPath;

    @Value("/doc.html")
    private String Knife4jPath;

    @Value("druid")
    private String dataSourceName;

    @Bean
    public ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String applicationName = environment.getProperty("spring.application.name", "SwaggerTest");
            
            System.out.println("----------------------------------------------------------------");
            System.out.printf("       应用(%s)启动成功！%n",applicationName);
            System.out.printf("       本地访问地址: http://localhost:%s\n",serverPort);
            System.out.printf("       外部访问地址: http://%s:%s\n","10.10.59.116",serverPort);
            System.out.printf("       druid访问地址: http://%s:%s/%s/login.html\n","10.10.59.116",serverPort,dataSourceName);
            System.out.printf("       Swagger文档: http://%s:%s%s\n","10.10.59.116",serverPort,swaggerPath);
            System.out.printf("       Knife4j加强Swagger文档: http://%s:%s%s\n","10.10.59.116",serverPort,Knife4jPath);
            System.out.printf("       启动成功，Sa-Token配置如下:%s",SaManager.getConfig());
            System.out.println("-----------------------------------------------------------------");
        };
    }
} 