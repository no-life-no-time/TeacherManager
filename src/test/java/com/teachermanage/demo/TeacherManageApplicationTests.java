package com.teachermanage.demo;

import com.teachermanage.demo.Bean.Announcement;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Mapper.TeacherMapper;
import com.teachermanage.demo.Service.AnnouncementServiceImp;
import com.teachermanage.demo.Service.SalaryServiceImp;
import com.teachermanage.demo.Service.TeacherServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;
import java.util.List;


@SpringBootTest
class TeacherManageApplicationTests {
    @Autowired
    SalaryServiceImp salaryServiceImp;
    @Test
    void contextLoads() {
        System.out.println(salaryServiceImp.getSalaryByTid(1));


    }

}
