package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/18 15:14
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello...");
        return "success";
    }
}
