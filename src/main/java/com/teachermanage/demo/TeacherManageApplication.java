package com.teachermanage.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.teachermanage.demo.Mapper")
public class TeacherManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherManageApplication.class, args);
    }

}
