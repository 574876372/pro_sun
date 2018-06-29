package com.org.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 应用启动
 * Created by paopaobing on 2017/8/17.
 */
@SpringBootApplication
@ImportResource({"classpath:spring-web.xml","classpath:spring.xml"})
public class AppService {

    public static void main(String[] args) {
        SpringApplication.run(AppService.class, args);
    }

}
