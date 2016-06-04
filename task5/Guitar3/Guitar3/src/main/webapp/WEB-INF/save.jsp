<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>

		<form action="${basePath}/guitar_save" id="stuForm" method="post">
<!-- 				<input type="hidden" name="pageNum" value="1"> -->
				ID:<input type="text"name="id" id="id" style="width: 120px"
					value="${id}"  placeholder="id" errormsg="范围之间！" sucmsg="验证通过！"> &nbsp; 
				price:<input type="text" name="price" id="price" style="width: 120px"
					value="${price}" placeholder="价格" /> &nbsp; 
				topwood:<input type="text" name="guitarSpecMap.topwood" id="topwood" style="width: 120px"
					value="${backwood}" placeholder="topwood" /> &nbsp;
				backwood:<input type="text" name="guitarSpecMap['backwood']" id="backwood" style="width: 120px"
					value="${backwood}" placeholder="backwood" /> &nbsp;
				type:<input type="text" name="guitarSpecMap['type']" id="type" style="width: 120px"
					value="${type}" placeholder="类型" /> &nbsp;
				builder:<input type="text" name="guitarSpecMap['builder']" id="builder" style="width: 120px"
					value="${builder}" placeholder="builder" /> &nbsp;
				model:<input type="text" name="guitarSpecMap['guitarmodel']" id="model" style="width: 120px"
					value="${guitarmodel}" placeholder="model" /> &nbsp;
					<input type="submit" value="保存">
					
		</form>
</body>
</html>