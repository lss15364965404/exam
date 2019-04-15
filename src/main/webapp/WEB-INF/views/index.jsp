<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试管理系统</title>
<%@ include file="head.jsp" %>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
	    <div class="layui-header">
	        <div class="layui-logo">考试管理系统</div>
	
	        <ul class="layui-nav layui-layout-right">
	            <li class="layui-nav-item">
	                <a href="javascript:;">
	                    <%=(String)session.getAttribute("username")%>
	                </a>
	                <dl class="layui-nav-child">
	                    <dd><a href="javascript:;" class="option" id=changePassword>修改密码</a></dd>
	                </dl>
	            </li>
	            <li class="layui-nav-item"><a href="login">退了</a></li>
	        </ul>
	    </div>
	
	    <div class="layui-side layui-bg-cyan">
	        <div class="layui-side-scroll">
	            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
	            <ul class="layui-nav layui-nav-tree layui-bg-cyan" >
	                <!--超级管理员的功能-->
	                <li class="layui-nav-item admin"><a href="javascript:;" class="option" id="teachersManage">老师管理</a></li>
	                <!--老师的功能-->
	                <li class="layui-nav-item teacher"><a href="javascript:;" class="option" id="myQuestions">我出的题</a></li>
	                <li class="layui-nav-item teacher"><a href="javascript:;" class="option" id="myPapers">我组的卷</a></li>
	                <li class="layui-nav-item teacher"><a href="javascript:;" class="option" id="classesManage">班级管理</a></li>
	                <li class="layui-nav-item teacher"><a href="javascript:;" class="option" id="studentsManage">学生管理</a></li>
	                <li class="layui-nav-item teacher"><a href="javascript:;" class="option" id="viewQuestions">查看题库</a></li>
	                <!--学生的功能-->
	                <li class="layui-nav-item student"><a href="javascript:;" class="option" id="doExam">考试</a></li>
	                <li class="layui-nav-item student"><a href="javascript:;" class="option" id="viewScores">查看成绩</a></li>
	            </ul>
	        </div>
	    </div>
	
	    <div class="layui-body">
	        <!-- 内容主体区域 -->
	        <iframe  src="welcome" frameborder="0" id="iframe" style="width: 100%; height: 100%;"></iframe>
	    </div>
	
	    <div class="layui-footer">
	        <!-- 底部固定区域 -->
	        © ychs.com - 考试管理系统
	    </div>
	</div>
	<script src="resources/lib/layui.js"></script>
	
	<script>
	    //JavaScript代码区域
	    layui.use(['element','layer'],function(){
	        var element = layui.element;
	        var layer = layui.layer;
	        var $ = layui.$;
	        //进行角色判断
	        $(document).ready(function(){
	    	  	var role_id=<%=session.getAttribute("role_id")%>
	    		if(role_id != null){
	    			if(role_id===1){
	    				//当登录者为教师时，不显示（教师管理）与（考试、查看成绩）
	    				  $(".admin,.teacher,.student").css("display","block");
	    			}else if(role_id===2){
	    				//当登录者为教师时，不显示（教师管理）与（考试、查看成绩）
	    				  $(".admin,.student").css("display","none");
	    				  $(".teacher").css("display","block");
	    			}else if(role_id===3){
	    				//当登录者为学生时，不显示（教师功能）与（管理员功能）
	    				  $(".admin,.teacher").css("display","none");
	    				  $(".student").css("display","block");
	    			}
	    		}
	      	}); 
	
	        $(".option").click(function(){
	            $("#iframe").attr("src",$(this).attr('id'));
	        });
	    });
	</script>
</body>
</html>