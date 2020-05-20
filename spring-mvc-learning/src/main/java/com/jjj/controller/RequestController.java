package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/13 14:23
 */
@Controller
@RequestMapping("/request")
public class RequestController {
    /**
     * SpringMVC获取请求带来的信息
     *
     * 原生携带请求参数：<a href="handler01?name=jjj>handler01</a>"
     * 给方法的形参列表中写上和请求参数名相同的变量，此变量即可接收请求参数
     *
     * * @RequestParam：获取请求参数；参数默认必须携带
     *      * 例：@RequestParam("username") String name
     *          name = request.getParameter("username);
     *      value()：指定要获取的参数的key
     *      required()：参数是否必须携带
     *      defaultValue()：若没携带的默认值
     *
     * * @RequestHeader：获取请求头中的某个key值
     *      原生：request.getHeader("User-Agent")
     *      * 例：@RequestHeader("User-Agent") String userAgent
     *          userAgent = request.getHeader("User-Agent")
     *
     * * @CookieValue：获取某个cookie的值
     *      原生：Cookie[] cookies = request.getCookies();
     *      for(Cookie c : cookies){
     *          if("JSESSIONID".equals(c.getName())){
     *              String cv = c.getValue();
     *          }
     *      }
     *      * 例：@CookieValue("JSESSIONID") String jsessionid
     *
     */
    @RequestMapping("/handler01")
    public String handler01(
            @RequestParam(value = "username", defaultValue = "没有带参数") String name,
            @RequestHeader("User-Agent") String userAgent,
            @CookieValue("JSESSIONID") String jsessionid
    ){
        System.out.println("获取请求参数name = " + name);
        System.out.println("获取请求头参数userAgent = " + userAgent);
        System.out.println("cookie中的JSESSIONID = " + jsessionid);
        return "success";
    }
}
