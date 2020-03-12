package com.teachermanage.demo.Service;

import com.teachermanage.demo.Bean.Curriculum;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Bean.TeacherMsg;

import java.util.List;

public interface TeacherService{
    public Teacher getTeacher(String username);
    public TeacherMsg getTeacherMsg(Integer teacher_id);
    public void upDateTeacher(String username,String password);
    public List<Curriculum> getCurriculum(Integer tid);
}
