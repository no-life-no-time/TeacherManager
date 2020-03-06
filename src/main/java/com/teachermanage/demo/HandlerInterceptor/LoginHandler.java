package com.teachermanage.demo.HandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("1".equals(request.getSession().getAttribute("loginteacher"))) {
            return true;
        }
        request.setAttribute("msg","没有权限请先登录");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
