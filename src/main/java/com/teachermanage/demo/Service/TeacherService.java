package com.teachermanage.demo.Service;

import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Bean.TeacherMsg;

public interface TeacherService{
    public Teacher getTeacher(String username);
    public TeacherMsg getTeacherMsg(Integer teacher_id);
}
