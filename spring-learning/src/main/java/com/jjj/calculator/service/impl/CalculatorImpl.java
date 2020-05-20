package com.jjj.calculator.service.impl;


import com.jjj.calculator.service.Calculator;
import com.jjj.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/4 22:52
 */
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public Double add(Double var0, Double var1) {
        return var0 + var1;
    }

    @Override
    public Double sub(Double var0, Double var1) {
        return var0 - var1;
    }

    @Override
    public Double mul(Double var0, Double var1) {
        return var0 * var1;
    }

    @Override
    public Double div(Double var0, Double var1) {
        return var0 / var1;
    }
}
