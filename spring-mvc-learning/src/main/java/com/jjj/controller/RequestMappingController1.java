package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/12 16:48
 *
 * RequestMapping的模糊匹配功能
 *
 * URL地址可以写模糊的通配符：
 *  ? : 能替代任意一个字符
 *  * : 能替代任意多个字符，和一层路径
 *  ** : 能替代多层路径
 */
@Controller
@RequestMapping("/ant")
public class RequestMappingController1 {
    @RequestMapping("/antTest01")
    public String antTest01() {
        System.out.println("antTest01...");
        return "success";
    }

    /**
     * ? : 匹配任意一个字符
     * 模糊和精确多个匹配情况下，精确优先
     */
    @RequestMapping("/antTest0?")
    public String antTest02() {
        System.out.println("antTest02...");
        return "success";
    }

    /**
     * * : 匹配任意多个字符，和一层路径
     *
     * 例：
     * /
     * ""
     * adadadads
     */
    @RequestMapping("/antTest0*")
    public String antTest03() {
        System.out.println("antTest03...");
        return "success";
    }

    @RequestMapping("/a/*/antTest04")
    public String antTest04() {
        System.out.println("antTest04...");
        return "success";
    }

    /**
     * ** : 能替代多层路径
     */
    @RequestMapping("/a/**/antTest05")
    public String antTest05() {
        System.out.println("antTest05...");
        return "success";
    }

    /**
     * /a/{dynamicParam}
     */
    @RequestMapping("/a/{name}")
    public String pathVariableTest(@PathVariable("name") String name){
        System.out.println("路径上的占位符为：" + name);
        System.out.println("pathVariableTest...");
        return "success";
    }
}
