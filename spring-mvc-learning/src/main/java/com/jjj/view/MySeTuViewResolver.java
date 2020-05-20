package com.jjj.view;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/17 23:00
 */
public class MySeTuViewResolver implements ViewResolver, Ordered {
    private Integer order = 0;

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("hso:")){
            return new MySeTuView();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
