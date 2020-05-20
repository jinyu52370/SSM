<%--
  Created by IntelliJ IDEA.
  User: 金俊杰
  Date: 2020/5/18
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<%--<form action="/user">--%>
    <%--name:<input type="text" name="name"><br/>--%>
    <%--gender:--%>
        <%--男:<input type="radio" name="gender">--%>
        <%--女:<input type="radio" name="gender"><br/>--%>
    <%--age:<input type="number" name="age"><br/>--%>
    <%--birthday:<input type="date" name="birthday"><br/>--%>
    <%--password:<input type="password" name="password"><br/>--%>
    <%--money:<input type="text" name="money"><br/>--%>
    <%--address:--%>
    <%--<select name="address.id">--%>
        <%--<c:forEach items="${address}" var="add">--%>
            <%--<option value="${add.id}">${add.addressName}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>

<%--表单标签
    通过SpringMVC的表单标签可以实现将模型数据中的属性和HTML表单元素相绑定，以实现表单数据更便捷编辑和表单值的回显
    SpringMVC认为，表单数据中的每一项自重都是要回显的；
        path指定的是一个属性，这个属性是从隐含模型(请求域中取出的某个对象的属性)；
        path指定的是一个属性，请求域中必须有一个对象拥有这个属性；
        这个对象就是请求域中的command
    modelattribute=
        1.以前我们表单标签会从请求域中获取一个command对象；把这个对象中的每一个属性对应的显示出来
        2.可以使用modelattribute指定一个自定义的对象，使SpringMVC不要去取command的值
--%>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<form:form action="${ctp}/user" modelAttribute="user" method="post">
    <%--path
        作用：
            1.当作原生的input的name项
            2.可以自动回显隐含模型中某个对象对应的属性的值
    --%>
    id:<form:input path="id"/><br/>
    name:<form:input path="name"/><br/>
    <%--gender: 男:<form:radiobutton path="gender" value="1"/>--%>
            <%--女:<form:radiobutton path="gender" value="0"/><br/>--%>
    age:<form:input path="age"/><br/>
    birthday:<form:input path="birthday"/><br/>
    password:<form:input path="password"/><br/>
    money:<form:input path="money"/><br/>
    <%--address:--%>
    <%--items:指定要遍历的集合；自动遍历，每一个元素是Address对象
        itemLabel:属性:指定遍历出的这个对象的哪个属性是作为option标签体的值
        itemValue:属性:指定遍历出的这个对象的哪个属性是作为option要提交的value值
    --%>
    <%--<form:select path="address.id" items="${address}" itemLabel="addressName" itemValue="id"/>--%>
    address:<form:input path="address"/><br/>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
