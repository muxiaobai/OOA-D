<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
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
			url:'${basePath}/section_studentTranscript.action'+window.location.search+'',
			//width:200,
			frozenColumns:[[
				  {field:'checkbox',checkbox:true},//复选框
			     {field:'id',title:'选课唯一编号',width:200}//冻结列
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
		    columns:[[
		        {field:'section',title:'课程',width:100,formatter: function(value){return value.fullSectionNo}},
		        {field:'student',title:'学生ssn号',width:100,
		        	formatter: function(value,row,index){
// 		        		//return value.ssn;
		        		return row.student.ssn;
		        		}
		        }
// 		        {field:'student',title:'学生姓名',width:100
// 		        	formatter: function(value,row,index){
// 		        		console.log("row"+row);
// 		        		console.log("value"+value);
//                         return row.name;
// 		        	}
// 		        }
// 		        {field:'student',title:'学分',width:200,align:'right',
// 		        	// rowStyler: 设置行的样式的, 返回样式对于当前正行,返回数据是交给  style 
// 		        	// formatter: 仅仅给当前列设置数据的格式,返回数据是会显示当前列中
// 					rowStyler:function(value,row,index){
// 						//console.info(typeof(true));
// 						console.info("当前行索引:" + index +",当前行的对象:" + row + ",单元格值:" + value);
// 		        		return "background-color:#629388,color:#ff0000";
// 					}
					
// 		        }
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