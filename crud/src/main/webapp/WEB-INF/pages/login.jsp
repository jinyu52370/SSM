<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/23
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <fmt:message key="welcomeinfo"/>
</h1>
<form action="">
    <fmt:message key="username"/>：<input type="text"><br/>
    <fmt:message key="password"/>：<input type="text"><br/>
    <input type="submit" value="<fmt:message key="loginbtn"/>">
</form>

<a href="/i18n/toLoginPage?locale=zh_CN">中文</a>|<a href="/i18n/toLoginPage?locale=en_US">English</a>
</body>
</html>
