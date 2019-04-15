<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <link href="<%=path %>/css/component.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=path %>/css/common.css"/><!-- 基本样式 -->

	<link rel="stylesheet" href="<%=path %>/css/animate.min.css"/> <!-- 动画效果 -->
	
    <link rel="stylesheet" href="<%=path %>/css/bootstrap.css">
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">
    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap/js/bootstrap.js"></script>
    <script src="<%=path %>/js/bootstrap-table.min.js"></script>
    <script src="<%=path %>/js/bootstrap-table-zh-CN.js"></script>
    
    <script src="<%=path %>/js/bootstrap-table-export.js"></script>
    <script src="<%=path %>/js/jquery.base64.js"></script>
    <script src="<%=path %>/js/tableExport.js"></script>
  </head>
  
  <body>

<div class="table-responsive container-fluid">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form class="form-horizontal">
                <div class="col-xs-6">
                    <label class="col-sm-2 control-label col-md-push-5">学校名称</label>
                    <div class="col-md-4 col-sm-2 col-md-push-5">
                        <select id = "school" name = "school" class="form-control haha">
                        	<option value = "">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-6">
                    <label class="col-sm-2 control-label col-md-push-2">院系名称</label>
                    <div class="col-md-4 col-sm-2 col-md-push-2">
                        <input class="form-control haha" type="text" id="name" name="name" placeholder="院系名称"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <input type="hidden" id="edit"  class="btn btn-default" />
    <div id="toolbar" class="btn-group ">
        <a href="page/Colleage/addColleage.jsp" >
        	<button id="btn_add" type="button" class="btn btn-default zoomIn dialog">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
       	    </button>
        </a>
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>

    </div>
    <table id="table">
    </table>
</div>
<div id="HBox" >
	<div style="height:30px"></div>
			
			<h3 style="margin:30px">确定删除吗？</h3>
			<input style="width:70px;height:40px" type="submit" value="确认" id="yes" /> &nbsp
			<input style="width:70px;height:40px" type="submit" value="取消" id="no" />
		</div><!-- HBox end -->	
<script src="<%=path %>/js/jquery.hDialog1.js"></script>

<script>
    $(function () {
		$.ajax({
			timeout: 3000,
            async: false,
            type: "POST",
            url: "<%=path%>/servlet/ColleageServlet",
            dataType: "json",
            data: {
                warehouse: $("#school").val(),
            },
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    $("#school").append("<option value = "+data[i].id+">" + data[i].name + "</option>");
                }
            }
        });
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    });
	$(".haha").change(function(){
  			$("#table").bootstrapTable('refresh'); 			
  	});

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#table').bootstrapTable({
                url: '<%=path%>/servlet/ColleageServlet?flag=query',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortName: 'id', // 要排序的字段
                sortOrder: 'desc', // 排序规则
                queryParamsType : "limit",//"",limit 
					queryParams: function (params) {
						return {  
							pageSize : params.limit,  
							rowoffset : params.offset,  
							pageNumber : params.offset/params.limit+1, //当前页面,默认是上面设置的1(pageNumber)
							name : $("#name").val(),
							school : $("#school").val()

				    	};
					},
                
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 20,                       //每页的记录行数（*）
                pageList: [2, 3, 5, 10],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                showExport: true,
                exportTypes: ['csv', 'txt', 'xml'],
                columns: [{
                    checkbox: true
                }, {
                    field: 'name',
                    title: '院系名称'
                }, {
                    field: 'school.name',
                    title: '所在学校'
                }, {
                    field: 'contact',
                    title: '院系联系人'
                }, {
                    field: 'memo',
                    title: '院系备注'
                }, ]

            });
        };
        return oTableInit;
    };


    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };
</script>

<script>
   	$(function(){
   	var $el = $('#edit');
   		$el.hDialog();
   	
   	
   	$('#yes').click(function() {

				var tab = $("#table").bootstrapTable('getSelections');
				var num = '';
   				 for(var i=0; i<tab.length; i++){
   					num = num + "," + tab[i].id;
   				} 
   				$.ajax({
		   		    type: "POST",
		    		url: "<%= path %>/servlet/ColleageServlet?flag=del",
		    		data: "ids="+num,
		   	  	    dataType: "json",
		    		//contentType:"application/json",
		    		success: function(b){
		        	if(b == true){
		        		alert("删除成功");
		        		window.location.href="<%= path %>/page/Colleage/showColleage.jsp";
		        	} else {
		        		alert("删除失败");
		        	}
		     		}
		    	});
					
   				setTimeout(function(){ 					 					
   					 $el.hDialog('close',{box:'#HBox'}); 
   					$("#table").bootstrapTable('refresh'); 		
   				},200);
   			
   		});
   		$('#no').click(function() {
   			
   				//$.tooltip('删除中...',200,true);

   				setTimeout(function(){ 					 					
   					 $el.hDialog('close',{box:'#HBox'}); 
   					$("#table").bootstrapTable('refresh'); 		
   				},10);
   			
   		});
   		$("#btn_delete").click(function(){
   			var tab = $("#table").bootstrapTable('getSelections');
   			
   			if(tab.length > 0){
   				$("#edit").click();
   			}else if(tab.length == 0){
   				alert("请选择信息！");
   				
   			}
   			
   		});
   			
   			
   		$("#btn_edit").click(function(){
   			var tab = $("#table").bootstrapTable('getSelections');
   			
   			if(tab.length != 1){
   				alert("请选择一条信息！");
   			}else{
			 	window.location.href="<%=path%>/servlet/ColleageServlet?flag=queryById&id="+tab[0].id;   	   				
   			}
   		});
   	});
  </script>
  </body>
</html>
