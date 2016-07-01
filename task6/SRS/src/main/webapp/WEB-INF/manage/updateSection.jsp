<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
</head>
<body>
<form id="ff" method="post" action="section_save">
			<label for="instructor.id">任课教师:</label> 
			<input id="instructor" class="easyui-combobox" 
			name="instructor.id"
			data-options="
					url:'${basePath}/professor_queryList.action',
					method:'get',
					valueField:'id',
					textField:'name',
					multiple:false,
					panelHeight:'auto'
			">
			<div>
		<input type="hidden" name="id" />
	</div>

	<div>
		<label for="sectionNo">sectionNo（数字）:</label> 
		<input type="text" name="sectionNo" />
	</div>
	<div>
		<label for="dayOfWeek">dayOfWeek(一个字母):</label> 
		<input type="text" name="dayOfWeek" />
	</div>
	<div>
		<label for="timeOfDay">timeOfDay:</label> 
		<input type="text" name="timeOfDay" />
	</div>
	<div>
		<label for="room">room:</label> 
		<input type="text" name="room" />
	</div>
		<div>
		<label for="seatingCapacity">学分（数字）:</label> 
		<input type="text" name="seatingCapacity" />
	</div>
	
	<div>
				<label for="representedCourse.id">所属Course:</label> 
			<input id="representedCourse" class="easyui-combobox" 
			name="representedCourse.id"
			data-options="
					url:'${basePath}/course_queryList.action',
					method:'get',
					valueField:'id',
					textField:'courseName',
					multiple:false,
					panelHeight:'auto'
			">
	</div>
	
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">修改</a>
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>

<script type="text/javascript">
$(function(){	
	// iframe中获取框架外面的值需要parent
	var rows=parent.$("#dg").datagrid("getSelections");
	$("#ff").form("load",{
		id:rows[0].id,
		name:rows[0].name,
		sectionNo:rows[0].sectionNo,
		dayOfWeek:rows[0].dayOfWeek,
		timeOfDay:rows[0].timeOfDay,
		room:rows[0].room,
		seatingCapacity:rows[0].seatingCapacity,
		instructor:rows[0].instructor
	});
	
	// form指定的无刷新提交
	$("#submit").click(function(){
		
		$("#ff").form("submit", {    
		    url:'${basePath}/section_update.action',
		    success:function(data){    
		       // 关闭更新的窗体
		       parent.$("#win").window("close");
		       // 让数据重新检索一次
		       parent.$("#dg").datagrid("reload");
		    }    
		});
		
		
		
	});
	//重置按钮
	$("#reset").click(function(){
		$("#ff").form("reset");
	});
	
});
</script>
</body>
</html>