package com.jjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/3 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private String password;
    private double money;
    private String address;

    public void myInit(){
        System.out.println("user的初始化方法");
    }

    public void myDestroy() {
        System.out.println("user的销毁方法");
    }
}
