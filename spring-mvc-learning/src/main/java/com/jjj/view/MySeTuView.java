package com.jjj.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/5/17 23:02
 */
public class MySeTuView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("之前保存的数据:" + model);

        List<String> pictures = (List<String>) model.get("pictures");

        response.setContentType(getContentType());
        response.getWriter().write("<h1>即将展示涩图</h1>");
        for (String str : pictures){
            response.getWriter().write("<a>下载"+ str +".jpeg</a><br/>");
        }
    }
}
