package com.jjj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/6 17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Air {
    //机长名
    private String jzName;
    //副驾驶名
    private String fjsName;
    //机翼长度
    private Double jyLength;
    //载客量
    private Integer capacity;
}
