<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<body>
<a href="/hello/hello">Hello World!</a>
<br/>
<a href="/handler01">写在方法上的@RequestMapping注解</a>
<br/>
<a href="/lol/handler01">写在类上的@RequestMapping注解</a>

<br/><br/><br/>

<h1>测试@RequestMapping的属性</h1>
<a href="/lol/handler02">handler02</a>
<br/>
<form action="/lol/handler02" method="post">
    <input type="submit">
</form>
<br/>
<a href="/lol/handler03">handler03</a>
<br/>
<a href="/lol/handler04">handler04</a>

<br/><br/><br/>

<h1>测试@RequestMapping-Ant风格的URL</h1>
<a href="/ant/antTest01">精确请求地址 antTest01</a>
</body>

<br/><br/><br/>

<h1>测试@PathVariable</h1>
<a href="/rest/jjj">jjj</a><br/>

<a href="/request/handler01?name=jjj">request/handler01</a><br/>

<form action="/rest/student">
    id:<input type="text" name="id"><br/>
    name:<input type="text" name="name"><br/>
    age:<input type="text" name="age"><br/>
    <%--birthday:<input type="text" name="birthday"><br/>--%>
    password:<input type="text" name="password"><br/>
    money:<input type="text" name="money"><br/>
    address:<br/>
    省:<input type="text" name="address.province"><br/>
    市:<input type="text" name="address.city"><br/>
    区:<input type="text" name="address.area"><br/>
    <input type="submit" name="submit"><br/>
</form>

<br/><br/><br/>

<h1>测试修改User</h1>
<form action="/user/update" method="post">
    name:     <input type="text" name="name" value="jjj1" readonly><br/>
    age:      <input type="number" name="age"><br/>
    birthday: <input type="date" name="birthday"><br/>
    password: <input type="password" name="password"><br/>
    money:    <input type="text" name="money"><br/>
    address:  <input type="text" name="address"><br/>
    <input type="submit" name="submit">
</form>

<br/><br/><br/>

<h1>测试ModelAttribute修改User</h1>
<form action="/ma/update" method="post">
    name:     <input type="text" name="name" value="jjj1" readonly><br/>
    age:      <input type="number" name="age"><br/>
    birthday: <input type="date" name="birthday"><br/>
    password: <input type="password" name="password"><br/>
    money:    <input type="text" name="money"><br/>
    address:  <input type="text" name="address"><br/>
    <input type="submit" name="submit">
</form>

<br/><br/><br/>

<a href="/hello/login">登录jjj</a>

<br/><br/><br/>

<a href="/my/handler01">涩图hso</a>
</html>
