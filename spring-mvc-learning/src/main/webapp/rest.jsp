<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/12
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<%--使用REST风格的url规定地址--%>
<a href="rest/1">查询用户</a><br/>

<form action="rest/1" method="post">
    <input type="submit" value="添加id=1的用户">
</form><br/>

<form action="rest/1" method="post">
    <input name="_method" value="DELETE">
    <input type="submit" value="删除id=1的用户">
</form><br/>

<form action="rest/1" method="post">
    <input name="_method" value="PUT">
    <input type="submit" value="修改id=1的用户">
</form><br/>

</body>
</html>
