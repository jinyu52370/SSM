<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/18
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<head>
    <title>用户列表页面</title>
    <%--<script type="text/javascript" src="${ctp}/webjars/jquery/3.5.1/jquery.min.js"/>--%>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>用户列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>birthday</th>
        <th>password</th>
        <th>money</th>
        <th>address</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthday}</td>
            <td>${user.password}</td>
            <td>${user.money}</td>
            <td>${user.address}</td>
            <td>
                <a href="${ctp}/user/${user.id}">EDIT</a>
            </td>
            <td>
                <a href="${ctp}/user/${user.id}" class="delBtn">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${ctp}/toAddPage">添加用户</a>
<form action="${ctp}/quickAdd">
    <input name="userInfo" value="name/20/2020-05-20/password/200.5/西安666"><br/>
    <input type="submit" value="快速添加">
</form>

<form id="deleteForm" action="${ctp}/user/${user.id}" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<script>
    $(function () {
        $(".delBtn").click(function () {
            //1.改变表单的action指向
            $("#deleteForm").attr("action", this.href);
            //2.提交表单
            $("#deleteForm").submit();
            return false;
        });
    });
</script>
</body>
</html>
