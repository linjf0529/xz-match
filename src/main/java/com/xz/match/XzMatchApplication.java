package com.xz.match;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xz.**.mapper")
public class XzMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzMatchApplication.class, args);
    }

}
