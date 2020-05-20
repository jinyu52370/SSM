package com.jjj.controller;

import com.jjj.entity.User;
import com.jjj.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/18 16:03
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ModelAndView queryAll(ModelAndView modelAndView){
        modelAndView.addObject("users", userService.queryAll());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String queryById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.queryById(id));
        return "update";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage(Model model){
        //若user对象中某个属性是自定义的引用对象，需先在数据库中查到所有数据再进行添加
//        model.addAttribute("command", new User(1, "jjj", 28, new Date("1999-05-07"), "213", 100.4, "xian"));
//        model.addAttribute("user", new User(1, "jjj", 28, new Date("1999-05-07"), "213", 100.4, "xian"));
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult){
        System.out.println(user);
        if (bindingResult.hasErrors()){
            System.out.println("有校验错误");
            return "add";
        }
        System.out.println("添加了" + userService.addUser(user) + "条数据");
        return "redirect:/users";
    }

    /**
     * userInfo=name/20/2020-05-20/password/200.5/西安666
     */
    @RequestMapping("/quickAdd")
    public String quickAdd(@RequestParam("userInfo") User user){
        System.out.println(user);
        System.out.println("添加了" + userService.addUser(user) + "条数据");
        return "redirect:/users";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id")Integer id, User user){//@ModelAttribute("user") User user){
//        user.setId(id);
        System.out.println(user);
        System.out.println("修改了" + userService.updateUser(user) + "条数据");
        return "redirect:/users";
    }
    
//    @ModelAttribute
//    public void updateFirst(@RequestParam(value = "id", required = false) Integer id, Model model){
//        if (id != null){
//            User user = userService.queryById(id);
//            model.addAttribute("user", user);
//        }
//    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("删除了" + userService.deleteUser(id) + "条数据");
        return "redirect:/users";
    }
}
