package com.teachermanage.demo.Controller;

import com.teachermanage.demo.Bean.Curriculum;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Service.TeacherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    TeacherServiceImp teacherServiceImp;
    @GetMapping("/TeacherMsg")
    public String TeacherMsg(){
        return "Teacher/Teachers";
    }
    @GetMapping("/ChangePassword")
    public String ChangePassword(){
        return "Teacher/ChangePassword";}
    @PutMapping("/UpdatePassword")
    public String UpdatePassword(@RequestParam("username") String username,
                                 @RequestParam("password_old") String password_old,
                                 @RequestParam("password_new") String password_new,
                                 Map<String,Object> map, Model model){
        Teacher teacher=teacherServiceImp.getTeacher(username);
        if (!teacher.getTeacher_password().equals(password_old)){
            model.addAttribute("msg","密码错误");
            return "Teacher/ChangePassword";
        }
        if (teacher.getTeacher_password().equals(password_new)){
            model.addAttribute("msg","新密码不能和旧密码一样");
            return "Teacher/ChangePassword";
        }
       teacherServiceImp.upDateTeacher(username,password_new);
        model.addAttribute("msg","密码修改成功请重新登录");
        return "Login";
    }
    @GetMapping("TeacherCl")
    public String Curriculum(HttpSession session,Model model){
//        teacherServiceImp.getCurriculum();
        String username=(String)session.getAttribute("TUN");
        Teacher teacher=teacherServiceImp.getTeacher(username);
        List<Curriculum> CL=teacherServiceImp.getCurriculum(teacher.getTeacher_id());
        int x= CL.size();
        System.out.println(x);
        Object[][] strings=new Object[x][3];
        int y=0;
        String[][] KB=new String[6][7];
        for (Curriculum curriculum : CL) {
            strings[y][0]= curriculum.getJieci();
            strings[y][1]=curriculum.getWeek();
            strings[y][2]=curriculum.getCname()+" "+curriculum.getClassname()+" "+curriculum.getAddress();
            y++;
            System.out.println(curriculum);
        }
        for (Object[] string : strings) {
            Integer xIndex= (Integer) string[0];
            Integer yIndex=(Integer)string[1];
            int xFor=(int)xIndex-1;
            int yFor=(int)yIndex-1;
            KB[xFor][yFor]=string[2].toString();
        }
        for (String[] objects : KB) {
            for (String object : objects) {
                System.out.print(object+"   ");
            }
            System.out.println(0);
        }
        model.addAttribute("KB",KB);
        return "Teacher/curriculum";
    }
}
