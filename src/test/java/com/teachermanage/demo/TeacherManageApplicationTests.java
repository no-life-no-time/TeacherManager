package com.teachermanage.demo;

import com.teachermanage.demo.Bean.Announcement;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Mapper.TeacherMapper;
import com.teachermanage.demo.Service.AnnouncementServiceImp;
import com.teachermanage.demo.Service.TeacherServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;
import java.util.List;


@SpringBootTest
class TeacherManageApplicationTests {
    @Autowired
    AnnouncementServiceImp announcementServiceImp;
    @Test
    void contextLoads() {
        List<Announcement> a=announcementServiceImp.getAll();
        System.out.println(a);


    }

}
