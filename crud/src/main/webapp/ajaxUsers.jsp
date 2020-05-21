<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/21
  Time: 13:49
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
<%= new Date()%>
<a href="${ctp}/ajax/users">ajax获取所有用户</a>
<div>
    <script>
        $("a:first").click(function () {
            // 发送ajax获取所有用户
            $.ajax({
                url:"${ctp}/ajax/users",
                type:"GET",
                success:function (data) {
                    // console.log(data);
                    $.each(data, function () {
                        var userInfo = "User{" +
                            "id=" + this.id +
                            ", name='" + this.name + '\'' +
                            ", age=" + this.age +
                            ", birthday=" + this.birthday +
                            ", password='" + this.password + '\'' +
                            ", money=" + this.money +
                            ", address='" + this.address + '\'' +
                            '}';

                        $("div").append(userInfo + "<br/>");
                    });
                }
            });
            return false;
        });
    </script>
</div>
</body>
</html>
