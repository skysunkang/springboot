package com.sunkang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by changxiang on 2017-03-01.
 * springboot   启动类
 */
@SpringBootApplication
@ServletComponentScan( basePackages = "com.sunkang.*")
@ComponentScan( basePackages = "com.sunkang.*")
@EnableAutoConfiguration
public class SpringBoot {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(SpringBoot.class);
        springApplication.run(args);
    }
}
