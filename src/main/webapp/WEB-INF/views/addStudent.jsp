<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加学生</title>
    <%@ include file="head.jsp" %>
   <!--  <link rel="stylesheet" href="lib/css/layui.css"> -->
</head>
<body>
	<form class="layui-form">
	  <div class="layui-form-item">
	    <label class="layui-form-label">学生姓名</label>
	    <div class="layui-input-block">
	      <input name="student_name" lay-verify="title" autocomplete="off" placeholder="姓名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">学生班级</label>
	    <div class="layui-input-block">
	      <input name="class_name" lay-verify="title" autocomplete="off" placeholder="班级" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">学生用户名</label>
	    <div class="layui-input-block">
	      <input name="username" lay-verify="title" autocomplete="off" placeholder="用户名" class="layui-input" type="text">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">学生密码</label>
	    <div class="layui-input-inline">
	      <input name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
	    </div>
	    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
	  </div>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	  
    </form>
    <script src="resources/lib/layui.js"></script>
	<script>
		layui.use(['form', 'layedit', 'laydate'], function(){
		  var form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit;
		  var $ = layui.$; 
		  
		  //创建一个编辑器
		  var editIndex = layedit.build('LAY_demo_editor');
		 
		  //自定义验证规则
		  form.verify({
		    username: [/^[\u4E00-\u9FA5]{2,4}$/, '用户名必须2到4个汉字，且不能出现空格']
		    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
		    ,content: function(value){
		      layedit.sync(editIndex);
		    }
		  });
		  
		  //监听提交
		  form.on('submit(demo1)', function(data){
		  	layer.msg(JSON.stringify(data.field));
        	var a = JSON.stringify(data.field);
        	console.log(a);
           	
           	$.ajax({
            	url:'${pageContext.request.contextPath}/addSU',
            	type:"POST",
            	data:{'data':a},
            	success:function(result){
    	        	if(result== "success"){
    	        		layer.msg('提交成功', {icon: 1,time:1000},function(){
    	        			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    						parent.layer.close(index);//关闭自身
    						location.href="studentsManage";
    	        		});
    	        	}
    	        	
   	         }});
		    
		    return false;
		  });
		  
		});
	</script>
    
</body>
</html>