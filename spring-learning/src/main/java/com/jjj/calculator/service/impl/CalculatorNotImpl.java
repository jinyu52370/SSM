package com.jjj.calculator.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/5 18:30
 */
@Service
public class CalculatorNotImpl {
    public Double add(Double var0, Double var1) {
        return var0 + var1;
    }
    public Double sub(Double var0, Double var1) {
        return var0 - var1;
    }
    public Double mul(Double var0, Double var1) {
        return var0 * var1;
    }
    public Double div(Double var0, Double var1) {
        return var0 / var1;
    }
}
