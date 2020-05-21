<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/21
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctp}/ajax/requestBody" method="post" enctype="multipart/form-data">
    <input name="user" value="jjj">
    <input name="age" value="21">
    <input name="sex" value="男">
    <input type="file" name="file">
    <input type="submit">
</form>
<a href="${ctp}/ajax/requestBodyUser">ajax发送json数据</a>
</body>
<script>
    $("a:first").click(function () {
        // 点击发送ajax请求，请求带的数据是json
        var user = {
            id:"666",
            name:"jjj",
            age:"21",
            birthday:"1999-05-07",
            password:"password",
            money:"100.3",
            address:"xian"
        };
        var userStr = JSON.stringify(user);
        $.ajax({
            url:"${ctp}/ajax/requestBodyUser",
            type:"POST",
            data:userStr,
            contentType:"application/json",
            success:function (data) {
                alert(data);
            }
        });
        return false;
    });
</script>
</html>
