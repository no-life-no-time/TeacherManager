package com.teachermanage.demo.Mapper;

import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Bean.TeacherMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper {
    public Teacher getTeacher(String username);
    public TeacherMsg getTeacherMsg(Integer teacher_id);
}
