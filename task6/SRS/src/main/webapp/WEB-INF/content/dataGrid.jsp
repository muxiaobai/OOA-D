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
			url:'${basePath}/section_query.action',
			//width:200,
			frozenColumns:[[
				  {field:'checkbox',checkbox:true},//复选框
			     {field:'id',title:'课程id',width:200}//冻结列
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
		        {field:'sectionNo',title:'课程编号',width:100},
		        {field:'dayOfWeek',title:'星期几上课',width:100},
		        {field:'timeOfDay',title:'时间',width:200},
		        {field:'instructor',title:'任课教师',width:200,
		        	formatter: function(value){
		        			//console.info(value);
		        			//console.info(value.instructor);
		        			return value.name;
		        	}
		        },
		        {field:'representedCourse',title:'归属课Course',width:300,
		        	formatter: function(value){
	        			//console.info(value);
	        			//console.info(value.instructor);
	        			return value.courseName;
	        	}	
		        },
		        {field:'room',title:'教室',width:200},
		        {field:'seatingCapacity',title:'学分',width:200,align:'right',
		        	// rowStyler: 设置行的样式的, 返回样式对于当前正行,返回数据是交给  style 
		        	// formatter: 仅仅给当前列设置数据的格式,返回数据是会显示当前列中
					rowStyler:function(value,row,index){
						//console.info(typeof(true));
						console.info("当前行索引:" + index +",当前行的对象:" + row + ",单元格值:" + value);
		        		return "background-color:#629388,color:#ff0000";
					}
					
		        },
		        {field:'noid',title:'操作',width:200,
		          formatter:function rowformater(value,row,index)
		        	 {
		        	 return "<a href='${basePath}/student_enroll.action?sectionId="+row.id+"' target='_blank'>选课</a>";
		        	 }
		        }
		    ]]

		});
	//
		

	});
</script>
</body>
</html>