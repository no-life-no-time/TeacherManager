package com.teachermanage.demo.Config;

import com.teachermanage.demo.HandlerInterceptor.LoginHandler;
import com.teachermanage.demo.MylocalResovler.Mylocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class Myconfig {
    Logger logger = LoggerFactory.getLogger(getClass());
    //设置映射,将所有组件注册在容器
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("Login");
                registry.addViewController("/index.html").setViewName("Login");
                //防止表单重复提交加映射
                registry.addViewController("/teacher/teacher.html").setViewName("Teachers");
            }
           //静态资源注入
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }

            //登录拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                   registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/static/**");
                logger.trace("拦截成功");
            }
        };
        return webMvcConfigurer;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new Mylocale();
    }
}
