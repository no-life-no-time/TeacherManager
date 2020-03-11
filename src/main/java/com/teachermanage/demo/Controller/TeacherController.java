package com.teachermanage.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
    @GetMapping("/TeacherMsg")
    public String TeacherMsg(){
        return "Teacher/Teachers";
    }
}
