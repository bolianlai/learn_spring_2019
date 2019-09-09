<%--
  Created by IntelliJ IDEA.
  User: 12981
  Date: 2019/9/7
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="pojoType" method="post">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    地址编号：<input type="text" name="address.id"/><br/>
    地址：<input type="text" name="address.name"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
