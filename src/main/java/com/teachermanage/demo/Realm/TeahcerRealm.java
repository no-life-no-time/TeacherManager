package com.teachermanage.demo.Realm;

import com.teachermanage.demo.Bean.Teacher;
import com.teachermanage.demo.Bean.TeacherMsg;
import com.teachermanage.demo.Mapper.TeacherMapper;
import com.teachermanage.demo.Service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class TeahcerRealm extends AuthorizingRealm {
    @Autowired
    TeacherService teacherService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }
     //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        Teacher teacher=teacherService.getTeacher(token.getUsername());
        if(teacher==null){
            return null;
        }
        Integer teacher_id=teacher.getTeacher_id();
        TeacherMsg teacherMsg=teacherService.getTeacherMsg(teacher_id);
        Subject subject=SecurityUtils.getSubject();
        Session teacherMsgSession=subject.getSession();
        teacherMsgSession.setAttribute("Tid",teacher_id);
        teacherMsgSession.setAttribute("TUN",token.getUsername());
        teacherMsgSession.setAttribute("MsgTN",teacherMsg.getTeacher_name());
        return new SimpleAuthenticationInfo("",teacher.getTeacher_password(),"");
    }
}
