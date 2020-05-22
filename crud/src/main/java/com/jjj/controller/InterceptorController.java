package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/22 22:30
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/test01")
    public String test01(){
        System.out.println("test01...");
        return "success";
    }
}
