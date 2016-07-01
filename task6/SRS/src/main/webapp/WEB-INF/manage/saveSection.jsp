<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="/public/head.jspf"%>
</head>
<body>
<form id="ff" method="post" action="section_save">
			<label for="instructor.id">任课教师:</label> 
			<input class="easyui-combobox" 
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
			<input class="easyui-combobox" 
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
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a>
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>

<script type="text/javascript">
$(function(){
	$("[name=name]").validatebox({
		required:true,
		invalidMessage:'对不起此用户名已存在'
	});
	$("[name=sectionNo]").validatebox({
		required:true,
		validType: 'number' ,
		invalidMessage:'只能填写数字'
	});
	// form指定的无刷新提交
	$("#submit").click(function(){
		$("#ff").form("enableValidation");
		// 默认是ajax提交,提交之前会自动进行表达验证
		$('#ff').form('submit', {    
		    url:'${basePath}/section_save.action',    
		    success:function(result){
		       // 如果成功 则重置表单数据
		       $("#ff").form("disableValidation");
		       $("#ff").form("reset");
		       // 关闭更新的窗体
		       parent.$("#win").window("close");
			    // 让数据重新检索一次
			   parent.$('#dg').datagrid('reload'); 
		    }    
		});  
	});
	//重置按钮
	$("#reset").click(function(){
		$("#ff").form("reset");
	});
	$("#ff").form("disableValidation");
});
</script>
</body>
</html>