package com.jjj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/3 21:29
 */
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Student {
    private User user;
    private String school;
    private List<String> classes;
    private Map<String, Integer> users;
}
