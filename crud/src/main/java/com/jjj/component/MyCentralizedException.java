package com.jjj.component;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/24 21:48
 *
 * 1.集中处理所有异常的类
 * 2.加入到ioc中：@ControllerAdvice
 * 3.全局处理异常类和某个bean的处理异常方法同时存在，bean的优先
 */
@ControllerAdvice
public class MyCentralizedException {
    /**
     * 告诉SpringMVC，这个方法专门处理这个类的异常
     * 1.在参数表中写上Exception变量，可以接收发生的异常
     * 2.参数表中不能写Model
     * 3.可以返回ModelAndView
     * 4.精确优先
     */
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception e) {
//        System.out.println("全局handleException..." + e);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("e", e);
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }
}
