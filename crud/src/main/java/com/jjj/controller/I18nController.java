package com.jjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/23 22:30
 */
@Controller
@RequestMapping("/i18n")
public class I18nController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/toLoginPage")
    public String toLoginPage(@RequestParam(value = "locale", defaultValue = "en_US") String localeStr, Locale locale, HttpSession session){
        System.out.println(locale);
        System.out.println(messageSource.getMessage("welcomeinfo", null, locale));

//        Locale l = null;
//        if (localeStr != null && !"".equals(localeStr)){
//            l = new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
//        } else {
//            l = locale;
//        }
//        session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE", l);
        return "login";
    }
}
