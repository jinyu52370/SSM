package com.jjj.controller;

import com.jjj.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/12 18:56
 */
@Controller
@RequestMapping("/rest")
public class RestController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Integer id){
        System.out.println("查询到了" + id + "号用户");
        return "success";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public String addUser(@PathVariable("id") Integer id){
        System.out.println("添加了" + id + "号用户");
        return "success";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除了" + id + "号用户");
        return "success";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Integer id){
        System.out.println("修改了" + id + "号用户");
        return "success";
    }

    /**
     * 提交的数据可能有乱码
     *  请求乱码：
     *      GET：
     *          修改server.xml，添加URIEncoding="UTF-8"
     *          <Connector port="8080" protocol="HTTP/1.1"
     *                URIEncoding="UTF-8"
     *                connectionTimeout="20000"
     *                redirectPort="8443" useBodyEncodingForURI="true"/>
     *      POST：
     *          在第一次获取请求之前设置
     *          request.setCharacterEncoding("UTF-8");
     *  响应乱码：
     *      response.setContentType("text/html;charset=utf-8);
     */
    @RequestMapping(value = "/student")
    public String addStudent(Student student){
        System.out.println(student);
        return "success";
    }

    /**
     * SpringMVC可以直接在参数上写原生API
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     *
     * java.security.Principal
     * Locale：国际化有关的区域信息对象
     * InputStream
     *      ServletInputStream inputStream = request.getInputStream();
     * OutputStream
     *      ServletOutputStream outputStream = response.getOutputStream();
     * Reader
     *      BufferedReader reader = request.getReader();
     * Writer
     *      PrintWriter writer = response.getWriter();
     */
    @RequestMapping(value = "/nativeAPI")
    public String nativeAPI(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response){
        httpSession.setAttribute("session", "session域");
        request.setAttribute("request", "请求域");
        return "success";
    }
}
