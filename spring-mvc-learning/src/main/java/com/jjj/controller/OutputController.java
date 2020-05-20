package com.jjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/14 10:20
 *
 * SpringMVC除过使用原生的request和session，还能将数据带给页面的办法
 *
 *  1.在方法形参表中传入Map、Model或ModelMap：这些参数里保存的数据都会放在请求域中，可以再页面获取
 *
 *      org.springframework.validation.support.BindingAwareModelMap
 *      BindingAwareModelMap中保存的数据都会放在请求域中
 *
 *      Map(interface(jdk))     Model(interface(spring))
 *            ↓                |
 *      ModelMap(class)         |
 *               ↓          ↓
 *               ExtendedModelMap
 *                         ↓
 *               BindingAwareModelMap
 *
 * 2.方法的返回值可以变为ModelAndView
 *      既包含视图信息(页面地址)，也包含模型数据(给页面带的数据)，数据放在请求域中
 *
 * 3.SpringMVC提供了可以临时给Session域中保存数据的方式
 *      * @SessionAttributes(只能标在类上)
 *      * @SessionAttributes(value="msg")
 *          给BindingAwareModelMap中保存数据，或ModelAndView中的数据，同时给session中放一份
 *          value：指定保存数据时要给session中放的数据的key
 *          types：指定保存数据时要给session中放的数据的class
 *      * @SessionAttributes不推荐使用，会引发异常；建议使用原生API：Session
 */
@Controller
@RequestMapping("/output")
@SessionAttributes(value = "key", types = String.class)
public class OutputController {

    @RequestMapping("/handle01")
    public String handle01(Map<String, Object> map){
        map.put("key", "value1");
        System.out.println(map.getClass());
        System.out.println("handle01...");
        return "output";
    }

    @RequestMapping("/handle02")
    public String handle02(Model model){
        model.addAttribute("key", "value2");
        System.out.println(model.getClass());
        System.out.println("handle02...");
        return "output";
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        modelMap.addAttribute("key", "value3");
        System.out.println(modelMap.getClass());
        System.out.println("handle03...");
        return "output";
    }

    @RequestMapping("/handle04")
    public ModelAndView handle04(){
        ModelAndView mv = new ModelAndView("output");
        mv.addObject("key", "value4");
        System.out.println("handle04...");
        return mv;
    }
}
