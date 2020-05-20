package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/12 9:27
 */
@Controller
@RequestMapping("/lol")
public class RequestMappingController {
    @RequestMapping("/handler01")
    public String  handler01() {
        System.out.println("handler01...");
        return "success";
    }

    @RequestMapping(value = "/handler02", method = RequestMethod.POST)
    public String  handler02() {
        System.out.println("handler02...");
        return "success";
    }

    @RequestMapping(value = "/handler03", params = {"username=123"})
    public String  handler03() {
        System.out.println("handler03...");
        return "success";
    }

    /**
     * User-Agent：浏览器信息
     *
     * 谷歌User-Agent：
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36
     *
     * 火狐User-Agent：
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0
     *
     *
     */
    @RequestMapping(
            value = "/handler04",
            headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0"}
    )
    public String  handler04() {
        System.out.println("handler04...");
        return "success";
    }
}
