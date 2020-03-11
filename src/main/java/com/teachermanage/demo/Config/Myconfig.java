package com.teachermanage.demo.Config;

//import com.teachermanage.demo.HandlerInterceptor.LoginHandler;
import com.teachermanage.demo.MylocalResovler.Mylocale;
import com.teachermanage.demo.Realm.TeahcerRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class Myconfig {
    Logger logger = LoggerFactory.getLogger(getClass());
    //设置映射,将所有组件注册在容器
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            //添加映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("Login");
                registry.addViewController("/index.html").setViewName("Login");
                registry.addViewController("/teacher/teacher.html").setViewName("/Teacher/Teachers");
                registry.addViewController("/teacher/Announcement.html").setViewName("/Teacher/Announcement");
            }
           //静态资源注入
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }

            //登录拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                   registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/static/**");
//                logger.trace("拦截成功");
//            }
        };
        return webMvcConfigurer;
    }
    //国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new Mylocale();
    }
    /*shiro三大核心对象
    1.Subject 用户
    2.SecurityManager 管理所用用户
    3.Realm 连接数据
    * */
    //1
    @Bean
    public TeahcerRealm teacherRealm(){
        return new TeahcerRealm();
    }
    //2
    @Bean(name = "dfwm")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("teacherRealm") TeahcerRealm teahcerRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(teahcerRealm);
        return securityManager;
    }
      //3.设置安全管理器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("dfwm") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
        1.anon   无需认证就可以访问
        2.authc  必须认证了才能访问
        3.user   必须拥有 记住我 功能才能使用
        4.perms  拥有对某个资源的权限才能访问
        5.role   拥有某个角色权限才能访问
        * */
        Map<String,String> filterMap=new LinkedHashMap<>();
        filterMap.put("/teacher/teacher.html","authc");
        //无权限跳转的url
        System.out.println("4");
        shiroFilterFactoryBean.setLoginUrl("/index.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
      return shiroFilterFactoryBean;
    }
}
