package com.jjj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toLoginPage(Locale locale){
        System.out.println(locale);
        System.out.println(messageSource.getMessage("welcomeinfo", null, locale));
        return "login";
    }
}
