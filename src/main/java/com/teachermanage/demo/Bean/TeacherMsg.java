package com.teachermanage.demo.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherMsg {
    private Integer teacher_id;
    private String teacher_name;
    private Integer teacher_age;
    private Integer teacher_sex;
    private String  teacher_card;
    private Date teacher_birth;
    private Date teacher_workDate;
    private String teacher_major;
    private String teacher_remark;
}