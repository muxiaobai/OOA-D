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
<link href="${basePath}/ooad/css/pagination.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${basePath}/ooad/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/ooad/js/jquery.pagination.js"></script>
<script type="text/javascript">
// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
    $("#stuForm").attr("action","${basePath}/guitar_query.action?pageNum=" +(new_page_index+1));
    $("#stuForm").submit();
    return false;
};
$(function(){
	$("#News-Pagination").pagination(${result.totalRecord}, {
        items_per_page:${result.pageSize}, // 每页显示多少条记录
        current_page:${result.currentPage} - 1, // 当前显示第几页数据
        num_display_entries:8, // 分页显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick});
});
</script>
<body>
<a href="send_save.action">新增保存</a>
	<div style="margin-left: 100px; margin-top: 100px;">
		<div>
			<font color="red">${errorMsg}</font>
		</div>
		<div>
			<form action="${basePath}/guitar_query" id="stuForm" method="post">
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
					<input type="submit" value="查询">
					
			</form>
		</div>
		<br> 列表：<br> <br>
		<!-- 后台返回结果为空 -->
		<c:if test="${fn:length(result.dataList) eq 0 }">
			<span>查询的结果不存在${msg}</span>
		</c:if>

		<!-- 后台返回结果不为空 -->
		<c:if test="${fn:length(result.dataList) gt 0 }">
			<table border="1px" cellspacing="0px"
				style="border-collapse: collapse">
				<thead>
					<tr height="30">
						<th width="130">编号</th>
						<th width="130">价格</th>
						<th width="130">backwood</th>
						<th width="130">topwood</th>
						<th width="130">类型</th>
						<th width="130">建造者</th>
						<th width="130">模型</th>
						<th width="130">操作</th>
					</tr>
				</thead>
				<c:forEach items="${result.dataList}" var="guitar">
					<tr>
						<td><c:out value="${guitar.id }"></c:out></td>
						<td><c:out value="${guitar.price }"></c:out></td>
						<td><c:out value="${guitar.guitarSpecMap['backwood'] }"></c:out></td>
						<td><c:out value="${guitar.guitarSpecMap['topwood'] }"></c:out></td>
						<td><c:out value="${guitar.guitarSpecMap['type'] }"></c:out></td>
						<td><c:out value="${guitar.guitarSpecMap['builder'] }"></c:out></td>
						<td><c:out value="${guitar.guitarSpecMap['guitarmodel'] }"></c:out></td>
						<td><a href="${basePath}/guitar_delete.action?id=${guitar.id }">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div id="News-Pagination"></div>
		</c:if>
		
		
		
	</div>
	
</body>
</html>