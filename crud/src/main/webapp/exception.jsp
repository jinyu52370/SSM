<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/24
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${ctp}/exception/test01?i=0">test01</a><br/>
<a href="${ctp}/exception/responseStatus?username=jjj">responseStatus</a><br/>
<a href="${ctp}/exception/handle03">handle03</a><br/>
</body>
</html>
