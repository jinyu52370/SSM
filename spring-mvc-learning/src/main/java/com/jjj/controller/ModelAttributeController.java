package com.jjj.controller;

import com.jjj.entity.User;
import com.jjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/14 14:05
 *
 * 执行全更新的sql时会有风险：
 *  例：修改User
 *      表单中未填入的money，则SpringMVC自动创建的User对象的money将为null，
 *      此时会覆盖掉数据库中原先的money字段，本意是不修改money，但执行全更新sql后会覆盖掉原字段
 *
 *  解决方法：
 *      执行更新sql时，SpringMVC不创建User对象，而是从数据库中取出相应id的一个User对象，且携带数据库中的值，
 *      然后根据表单中携带的数据决定是否进行数据更新，携带了就覆盖，没携带就保持原值
 *
 * * @ModelAttribute
 *      参数：告诉SpringMVC无需创建对象，而是使用注解了@ModelAttributeTes方法中查询了的相应的对象
 *      方法：这个方法会提前于目标方法之前运行，
 *          1.可以提前查出数据库中的数据
 *          2.保存数据
 */
@Controller
@RequestMapping("/ma")
public class ModelAttributeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        System.out.println(user);
        userService.updateUser(user);
        return "success";
    }

    @ModelAttribute
    public void modelAttributeTest(Model model){
        User user = new User();
        user.setId(28)
                .setName("jjj1")
                .setAge(20)
                .setBirthday("1999-05-07")
                .setPassword("password")
                .setMoney(1000.1)
                .setAddress("西安");
        System.out.println("数据库中的user信息" + user);
        model.addAttribute("user", user);
        System.out.println("modelAttribute查询了信息并保存在model中");
    }

}
