<%--
  Created by IntelliJ IDEA.
  User: 12981
  Date: 2019/9/7
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="mapType" method="post">
    用户1姓名：<input type="text" name="userMap['a'].name"/><br/>
    用户1年龄：<input type="text" name="userMap['a'].age"/><br/>
    用户2姓名：<input type="text" name="userMap['b'].name"/><br/>
    用户2年龄：<input type="text" name="userMap['b'].age"/><br/>
    用户3姓名：<input type="text" name="userMap['c'].name"/><br/>
    用户3年龄：<input type="text" name="userMap['c'].age"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
