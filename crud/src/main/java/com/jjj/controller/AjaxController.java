package com.jjj.controller;

import com.jjj.entity.User;
import com.jjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/21 12:10
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @Autowired
    private UserService userService;

    /**
     * 将返回的数据放在响应体中，如果是对象，jackson自动将对象转换为json格式
     */
    @ResponseBody
    @RequestMapping("/users")
    public List<User> ajaxQueryAll(){
        return userService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/user/{id}")
    public User ajaxQueryById(@PathVariable("id") Integer id){
        return userService.queryById(id);
    }

    /**
     * 请求体
     */
    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody String body){
        System.out.println("请求体：" + body);
        return "success";
    }

    /**
     * ResponseBody：返回json数据
     * RequestBody：接收json数据
     */
    @RequestMapping("/requestBodyUser")
    public String requestBody(@RequestBody User user){
        System.out.println("请求体：" + user);
        return "success";
    }

    /**
     * HttpEntity比@RequestBody更强大，可以拿到(所有)请求头
     * *@RequestHeader只能拿到一个请求头
     */
    @RequestMapping("/httpEntity")
    public String httpEntity(HttpEntity<String> str){
        System.out.println(str);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "<h1>test</h1>";
    }

    @ResponseBody
    @RequestMapping("/test1")
    public ResponseEntity<String> test1(){
        String body = "<h1>test1</h1>";

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Set-Cookie", "user=jjj");

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }


}
