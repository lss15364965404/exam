<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <%@ include file="head.jsp" %>
</head>
<body>
    <blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">修改密码</blockquote>
    <div class="layui-tab-item layui-show" style="margin-left: 10px">
        <div>
            <form class="layui-form layui-form-pane" action="">
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名</label>
				    <div class="layui-input-inline">
				      <input name="username" lay-verify="required" value="<%=(String)session.getAttribute("username")%>" autocomplete="off" class="layui-input" type="text" disabled="disabled">
				    </div>
				  </div>
				
				  <div class="layui-form-item">
				    <label class="layui-form-label">原始密码</label>
				    <div class="layui-input-inline">
				      <input name="password" placeholder="请输入密码" autocomplete="off" lay-verify="pass" class="layui-input" type="password">
				    </div>
				    <div class="layui-form-mid layui-word-aux">请输入原始密码</div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">新密码</label>
				    <div class="layui-input-inline">
				      <input name="password_last" placeholder="请输入新密码" autocomplete="off" lay-verify="pass" class="layui-input" type="password" id = "firstPass">
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">再次输入新密码</label>
				    <div class="layui-input-inline">
				      <input name="password_last_again" placeholder="请输入新密码" autocomplete="off" lay-verify="two" class="layui-input" type="password">
				    </div>
				    <div class="layui-form-mid layui-word-aux">新密码必须相同</div>
				  </div>
				  
				  <div class="layui-form-item">
				    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				  </div>
			</form>
        </div>
    </div>
    <script src="resources/lib/layui.js"></script>

    <script>
        //JavaScript代码区域
        layui.use(['element','layer','form','table'],function(){
            var layer = layui.layer;
            var $ = layui.$;
            var form = layui.form;
          //输入验证
            form.verify({
            	pass: function(value, item){ //value：表单的值、item：表单的DOM对象
                    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                        return '密码不能有特殊字符';
                    }
                    if(!new RegExp("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$").test(value)){
                        return '密码首尾不能出现下划线\'_\'';
                    }
                    if(!new RegExp(/^[\S]{5,12}$/).test(value)){
                        return '密码必须6到12位，且不能出现空格';
                    }
                }
                //我们既支持上述函数式的方式，也支持下述数组的形式
                //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                ,two: function(value, item){ //value：表单的值、item：表单的DOM对象
                    if(value != null){
                    	if(value != ($('#firstPass').val())){
                            return '两次输入的新密码不同！请重新输入！';
                        }
                    } 
                }
            });

          //监听提交
            /* 提交事件的触发     */
            form.on('submit(demo1)', function(data){
              	
              	layer.msg(JSON.stringify(data.field));
              	var a = JSON.stringify(data.field);
  	        	console.log(a);
  	        	
  	        	$.ajax({
  	        	url:'${pageContext.request.contextPath}/changePassword',
  	        	type:"POST",
  	        	data:{'data':a},
  	        	success:function(result){
  		        	if(result=="success"){
  		        		//弹出框
  						layer.msg('密码修改成功', {icon: 1,time:1000},function(){
  							alert("密码修改成功");
  							window.location.href='welcome';
  						});
  		        	}else if(result=="false"){
  		        		//弹出框
  						layer.msg('原密码错误，请重试！', {icon: 1,time:1000},function(){
  							alert("原密码错误，请重试！");
  						})
  		        	}
  		         }});
  			 	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  			});  
           
        });
    </script>
</body>
</html>