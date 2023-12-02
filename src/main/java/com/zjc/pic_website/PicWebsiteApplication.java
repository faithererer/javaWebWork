package com.zjc.pic_website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjc.pic_website.mapper")
@SpringBootApplication
public class PicWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicWebsiteApplication.class, args);
    }

}
