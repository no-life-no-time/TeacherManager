package com.teachermanage.demo.Controller;
import com.teachermanage.demo.Bean.Announcement;
import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Mapper.AnnouncementMapper;
import com.teachermanage.demo.Mapper.TeacherMapper;
import com.teachermanage.demo.Service.AnnouncementServiceImp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
@Controller
public class LoginController {
    @Autowired
    AnnouncementServiceImp announcementServiceImp;
    Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("sex") String identity,
                        Map<String,Object> map) {
        System.out.println("3");
        //缓3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("".equals(username) || "".equals(password)) {
            map.put("msg", "账号或密码为空");
            return "Login";
        }
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken Token = new UsernamePasswordToken(username, password);
        try{subject.login(Token);}
        catch (UnknownAccountException e){
            map.put("msg","用户名不存在");
            return "Login";
        }catch (IncorrectCredentialsException e){
            map.put("msg","密码错误");
            return "Login";
        }
        return "teacher/Announcement.html";
//       session.setAttribute("loginteacher","1");
    }
        //"teacher".equals(identity)&&"admin".equals(username.trim())&&"123456".equals(password.trim())
//        if (teacher!=null){
//            System.out.println(teacher.getTeacher_id());
           //登录成功后,防止表单重复提交进行重定向到主页
//            session.setAttribute("loginteacher","1");
//            return "redirect:/teacher/teacher.html";
//        }
//        else{
//            map.put("msg","账号或密码错误");
//            return "Login";
//        }
    @GetMapping(value = "/Logout/teacher")
    public String Logout(){
            Subject subject=SecurityUtils.getSubject();
            subject.logout();
            System.out.println("进来了");
            subject.getSession().setTimeout(0);
            logger.trace("注销登录");
        return "redirect:/";
    }
}
