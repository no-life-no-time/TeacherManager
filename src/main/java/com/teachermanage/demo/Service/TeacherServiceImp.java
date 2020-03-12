package com.teachermanage.demo.Service;

import com.teachermanage.demo.Bean.Curriculum;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Bean.TeacherMsg;
import com.teachermanage.demo.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public Teacher getTeacher(String username) {
       return teacherMapper.getTeacher(username);
    }

    @Override
    public TeacherMsg getTeacherMsg(Integer teacher_id) {
        return teacherMapper.getTeacherMsg(teacher_id);
    }

    @Override
    public void upDateTeacher(String username, String password) {
       teacherMapper.upDateTeacher(username,password);
    }
    @Override
    public List<Curriculum> getCurriculum(Integer tid){
        return teacherMapper.getCurriculum(tid);
    };
}
