<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/21
  Time: 22:18
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
<!--
    1.文件上传：enctype="multipart/form-data"
    2.导入fileupload包
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
        </dependency>
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
        </dependency>
    3.配置文件上传解析器(MultipartResolver)
    4.文件上传请求处理
-->
<form action="${ctp}/file/upload" enctype="multipart/form-data" method="post">
    头像：<input type="file" name="headerImg"><br/>
    头像：<input type="file" name="headerImg"><br/>
    头像：<input type="file" name="headerImg"><br/>
    头像：<input type="file" name="headerImg"><br/>
    头像：<input type="file" name="headerImg"><br/>
    用户名：<input type="text" name="name"><br/>
    <input type="submit">
</form>
</body>
</html>
