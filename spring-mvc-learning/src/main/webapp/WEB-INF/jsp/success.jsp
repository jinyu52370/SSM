<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/11
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>跳转成功</h1>

请求：${requestScope.get("request")}：${requestScope.reqParam}<br/>
session：${sessionScope.get("session")}：${sessionScope.sessionParam}<br/>
<%System.out.println("页面完成");%>
</body>
</html>
