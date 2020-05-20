package com.jjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/13 18:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String province;
    private String city;
    private String area;
}
