package com.jjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/14 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String birthday;
    private String password;
    private Double money;
    private String address;
}
