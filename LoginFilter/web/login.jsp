<%--
  Created by IntelliJ IDEA.
  User: wxm-Imperio
  Date: 2015/3/3
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title></title>
</head>
<body>
<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post">
	<table>
		<tr>
			<td>用户名：<input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码：<input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
</body>
</html>
