package com.jjj.controller;

import com.jjj.component.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/24 19:09
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/test01")
    public String test01(Integer i){
        System.out.println("test01...");
        System.out.println(5 / i);
        return "success";
    }

    /**
     * 告诉SpringMVC，这个方法专门处理这个类的异常
     * 1.在参数表中写上Exception变量，可以接收发生的异常
     * 2.参数表中不能写Model
     * 3.可以返回ModelAndView
     * 4.精确优先
     */
//    @ExceptionHandler(ArithmeticException.class)
//    public ModelAndView arithmeticException(ArithmeticException e) {
//        System.out.println("handleException01..." + e);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("e", e);
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public ModelAndView nullPointerException(NullPointerException e) {
//        System.out.println("handleException01..." + e);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("e", e);
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }

    @RequestMapping("/responseStatus")
    public String responseStatus(@RequestParam("username") String username){
        if (!"jjj".equals(username)){
            throw new UserNameNotFoundException("用户名错误...");
        }
        System.out.println("登录成功...");
        return "success";
    }

    @RequestMapping(value = "/handle03", method = RequestMethod.POST)
    public String handle03(){
        return "success";
    }
}
