<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<h3>用户注册</h3>
<form action="student_login" method="post">
<input type="text" name="ssn"/>
<input type="password" name="password"/>
<input type="submit" value="提交"/>
</body>
</html>
