<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="/public/head.jspf"%>
</head>
<body>
<form id="ff" method="post" action="section_save">
	
	<div>
		<label for="ssn">ssn:</label> 
		<input type="text" name="ssn" />
	</div>
	<div>
		<label for="department">department:</label> 
		<input type="text" name="department" />
	</div>
	<div>
		<label for="name">name:</label> 
		<input type="text" name="name" />
	</div>
	<div>
		<label for="title">简称:</label> 
		<input type="text" name="title" />
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
	// form指定的无刷新提交
	$("#submit").click(function(){
		$("#ff").form("enableValidation");
		// 默认是ajax提交,提交之前会自动进行表达验证
		$('#ff').form('submit', {    
		    url:'${basePath}/professor_save.action',    
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