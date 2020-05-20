package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/17 22:55
 *
 * 自定义视图解析器和视图对象
 */
@Controller
@RequestMapping("/my")
public class MyViewResolverController {
    @RequestMapping("/handler01")
    public String handler01(Model model){
        List<String> pictures = new ArrayList<>();

        pictures.add("蕾姆");
        pictures.add("爱蜜莉雅");
        pictures.add("こいし");

        model.addAttribute("pictures", pictures);
        return "hso:/setu";
    }
}
