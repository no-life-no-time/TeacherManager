package com.teachermanage.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;


import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping(value = "/user/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("sex") String identity,
                        Map<String,Object> map, HttpSession session){
        if ("teacher".equals(identity)&&"admin".equals(username.trim())&&"123456".equals(password.trim())){
           //登录成功后,防止表单重复提交进行重定向到主页
            session.setAttribute("loginteacher","1");
            return "redirect:/teacher/teacher.html";
        }
        else{
            map.put("msg","账号或密码错误");
            return "Login";
        }
    }
    @GetMapping(value = "/Logout/teacher")
    public String Logout(@RequestParam("msg") String msg, HttpSession session, SessionStatus sessionStatus){
        logger.trace("msg值为:"+msg);
        if (msg=="Logout"){
            session.removeAttribute("loginteacher");
            sessionStatus.setComplete();
            logger.trace("注销登录");
        }
        return "redirect:/index.html";
    }
}
