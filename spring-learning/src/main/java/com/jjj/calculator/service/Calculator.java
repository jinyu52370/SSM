package com.jjj.calculator.service;

/**
 * 接口不应加载进容器，因为得到bean时需要创建对象，而接口无法创建
 *
 * 但实际可以加入，且不会创建对象：只要这个bean是个接口，相当于告诉spring，IOC容器中可能有此种类型的bean
 */
public interface Calculator {
    Double add(Double var0, Double var1);
    Double sub(Double var0, Double var1);
    Double mul(Double var0, Double var1);
    Double div(Double var0, Double var1);
}
