<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
</head>
<body>
<table id="dg"></table>
<div id="win"></div>  
<script type="text/javascript">
	$(function(){
		//
		$('#dg').datagrid({
			url:'${basePath}/student_queryTranscript.action',
			//width:200,
			frozenColumns:[[
				 {field:'checkbox',checkbox:true},//复选框
			     {field:'id',title:'我的选课编号',width:80}//冻结列
			     	]],
			//queryParams:{type:""}, //第一查询的时候发出额外参数
			//idField:id,
			autoRowHeight:false,   // 固定高度
			striped:true,//是否显示斑马线效果。
			nowrap:true,  //如果为true，则在同一行中显示数据
			loadMsg:"正在加载......",
			singleSelect:false, // 支持单行显示
			rownumbers:true,  //显示行号
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
			pagination:true, //是否支持分页显示
			pageNumber:1,  //初始页码
			pageSize:10,   //每页显示的记录数
			pageList:[5,10,15,20],   // 初始化页面大小选择列表
			toolbar:[{
				iconCls: 'icon-remove',
				text:'删除已选课程',
				handler: function(){
					var rows = $("#dg").datagrid("getSelections");
					if (rows.length == 0) {
						// 错误提示至少选中一行
						$.messager.show({
							title : '删除错误提示!',
							msg : '要删除至少选中一行数据',
							timeout : 2000,
							showType : 'slide'
						});
					} else {
						// 删除提示
						$.messager.confirm('确认对话框','确认要删除选中的行吗?',
										function(r) {
											if (r) {
												var ids = "";
												for ( var i = 0; i < rows.length; i++) {
													ids += rows[i].id + ",";
												}
												ids = ids.substring(0,ids.length - 1);
												$.post("${basePath}/student_deleteTranscript.action",
													{ids : ids}, 
													function(result){
														//alert("已经删除");
														$("#dg").datagrid("reload");
													});
											}
										});
						
					} //if结束
				} //方法结束
			},'-',{
				text:"<input id='ss' name='type' />"
			}],//linkButton
		    columns:[[
		        {field:'student',title:'学生',width:100,formatter:function(value){ return value.id}},
		    
		        {field:'section',title:'已选课程',width:100,formatter: function(value){return value.fullSectionNo}},
// 		         {field:'section',title:'上课教室',width:100, formatter: function(value){ return value.room}},
		       // {field:'section',title:'任课教师',width:200,formatter: function(value){return value.instructor.name}},
		        {field:'grade',hidden:true}
		    ]]

		});
		//搜索事件
		$("#ss").searchbox({
			 // 响应搜索的事件
			searcher:function(value,name){
				//获取当前查询参数
				
				$("#dg").datagrid("load",{type:name});
			//	alert(value + "," + name);
			}, 
			prompt:'Please Input Value' 
		});
		

	});
</script>
</body>
</html>