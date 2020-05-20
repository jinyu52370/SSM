package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/11 21:16
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        /*
         * 摄图解析器自动拼串
         *
         * <property name="prefix" value="/WEB-INF/jsp/"/>
         * <property name="suffix" value=".jsp"/>
         */
        return "success";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        System.out.println("hello1");
        return "../../hello";
    }

    /**
     * forward：转发到一个页面
     *      forward:/hello.jsp：转发到当前项目下的hello.jsp
     *      不会使用视图解析器进行拼串
     */
    @RequestMapping("/hello2")
    public String hello2() {
        System.out.println("hello2");
        return "forward:/hello.jsp";
    }

    /**
     * forward：多次转发
     */
    @RequestMapping("/hello3")
    public String hello3() {
        System.out.println("hello3");
        return "forward:hello2";
    }

    /**
     * redirect：重定向
     *      原生的Servlet重定向/路径需要加上项目名
     *          response.sendRedirect("/hello.jsp")
     *      SpringMVC会自动为路径拼接项目名
     */
    @RequestMapping("/hello4")
    public String hello4() {
        System.out.println("hello4");
        return "redirect:/hello.jsp";
    }

    /**
     * redirect：多次重定向
     */
    @RequestMapping("/hello5")
    public String hello5() {
        System.out.println("hello5");
        return "redirect:hello4";
    }

    @RequestMapping("/me")
    public String user(Model model) {
        model.addAttribute("name", "jjj");
        model.addAttribute("age", "21");
        return "me";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }
}