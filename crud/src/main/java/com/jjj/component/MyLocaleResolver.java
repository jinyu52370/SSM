package com.jjj.component;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/24 18:01
 *
 * 自定义区域信息解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析返回locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String localeStr = request.getParameter("locale");
        //若携带了locale参数，就使用参数指定的区域信息
        if (localeStr != null && !"".equals(localeStr)){
            return new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
        }
        //否则，使用请求头的locale
        return request.getLocale();
    }

    /**
     * 修改locale
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException(
                "Cannot change HTTP accept header - use a different locale resolution strategy");
    }
}
