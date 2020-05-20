<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/18
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户页面</title>
</head>
<body>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<form:form action="${ctp}/user/${user.id}" modelAttribute="user" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="id" value="${user.id}"/>
    name:<form:input path="name"/><br/>
    age:<form:input path="age"/><br/>
    birthday:<form:input path="birthday"/><br/>
    password:<form:input path="password"/><br/>
    money:<form:input path="money"/><br/>
    address:<form:input path="address"/><br/>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
