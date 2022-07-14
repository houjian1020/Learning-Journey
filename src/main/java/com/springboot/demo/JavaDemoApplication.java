package com.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.springboot.demo.mapper")  // Mapper包扫描：不需要在Mapper类上加@Mapper
@EntityScan("com.springboot.demo.entry")
public class JavaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDemoApplication.class, args);
    }

}
