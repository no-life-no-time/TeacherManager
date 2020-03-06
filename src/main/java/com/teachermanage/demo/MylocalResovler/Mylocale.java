package com.teachermanage.demo.MylocalResovler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class Mylocale implements LocaleResolver {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String I=httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();
        if (!StringUtils.isEmpty(I)){
            String[] split=I.split("_");
            locale=new Locale(split[0],split[1]);
            logger.trace("成功获取");
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
