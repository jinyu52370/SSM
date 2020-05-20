package com.jjj.component;

import com.jjj.entity.User;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/19 21:30
 */
public class MyStringToUser implements Converter<String, User> {
    @Override
    public User convert(String s) {
        User user = new User();
        System.out.println("页面提交的将要转换的字符串:" + s);
        if (s.contains("/")){
            String[] split = s.split("/");
            user.setName(split[0]);
            user.setAge(Integer.parseInt(split[1]));
            user.setBirthday(new Date(split[2]));
            user.setPassword(split[3]);
            user.setMoney(Double.valueOf(split[4]));
            user.setAddress(split[5]);
            return user;
        }
        return null;
    }
}
