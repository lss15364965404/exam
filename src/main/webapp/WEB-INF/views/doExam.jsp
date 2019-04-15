<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>学生考试页面</title>
     <script src="../layui-v2.2.3/layui/layui.js" charset="utf-8"></script>
     <script src="../layui-v2.2.3/layui/layui.all.js" charset="utf-8"></script>
 
<%@ include file="head.jsp" %>
<script language="javascript">
        window.onload = function ()
        {
            var oCountDown = document.getElementById("countdown");
            var aInput = oCountDown.getElementsByTagName("input")[0];
            var timer = null;
            aInput.onclick = function ()
            {
                this.className == "" ? (timer = setInterval(updateTime, 1000), updateTime()) : (clearInterval(timer));
                this.className = this.className == '' ? "cancel" : '';
            };
            function format(a)
            {
                return a.toString().replace(/^(\d)$/,'0$1');
            }
            function updateTime ()
            {
                var aSpan = oCountDown.getElementsByTagName("span");
                var anniu = document.getElementById("anniu");
                
                var oRemain = aSpan[0].innerHTML.replace(/^0/,'') * 60 + parseInt(aSpan[1].innerHTML.replace(/^0/,''));
                if(oRemain <= 0)
                {
                    clearInterval(timer);
                    anniu.disabled=true; 
                    anniu.innerHTML="不可提交"; 
                    anniu.className="layui-btn layui-btn-danger"; 
                    
                    layui.use(['form','layer','element'],function() {
                        var element = layui.element;
                        var layer = layui.layer;
                        var $ = layui.$; 
                        var form = layui.form;
/**
 * 自动提交未解决**********************************************************
 */
                        /* 提交事件的触发     */
                        form.ready('submit(formDemo)', function(data){
                          	
                          	layer.msg(JSON.stringify(data.field));
                          	
              	        	var a = JSON.stringify(data.field);
              	        	console.log(a);
              	        	$.ajax({
              	        	url:'${pageContext.request.contextPath}/map ',
              	        	type:"POST",
              	        	data:{'data':a},
              	        	success:function(result){
              		        	if(result=="success"){
              		        		//弹出框
              						layer.msg('时间到，试卷提交成功', {icon: 1,time:1000},function(){
              							alert("试卷已自动提交");
              						});
              		        	}
              		         }});
              			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
              			});  
                    });
                    
                    return;
                }
                oRemain--;
                aSpan[0].innerHTML = format(parseInt(oRemain / 60));
                oRemain %= 60;
                aSpan[1].innerHTML = format(parseInt(oRemain));
            }
            
            // 加上此句即可。
            aInput.click();
            aInput.style.display="none";
        }
    </script>
</head>
<body>
    <blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;"><span style="font-size: 20px">试卷名称：${list_paperName}<span style="position: absolute;right: 120px;">考生：<%=(String)session.getAttribute("username")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考试倒计时：</span>
    <div id="countdown" style="float:right;position:relative;right:60px;">
    	<span id="time" style="color: red;">01</span>:<span style="color: red;">00</span><input type="button" value="开始" />
    </div>
    </blockquote>

    <form class="layui-form">
    	<!-- 学生id -->
        <input type="hidden" name="student_id" value="1" id="student_id"/>
        <!-- 试卷id  -->
        <input type="hidden" name="paper_id" value="1" id="paper_id"/>
		
        <ul style="margin-left: 20px">
           <h3>一、单选题</h3>
          <%
          	int i = 0;
          %>
           <c:forEach items="${list_single}"  var="single">
           			<!-- 选项题目 -->
           			<li style="margin-left: 30px"><span style="display: inline;"><%= ++i %></span>.<p style="display: inline;">${single[0].singleChoice_question}</p>
                   		<!-- 循环遍历所有的选项  -->
                   		<div class="layui-form-item" style="margin-left: -80px">
	                   		<c:forEach items="${single[1]}"  var="single1">
			                    <div class="layui-input-block">
			                        <input type="radio" name="singleChoice_choice<%= i %>" value="${single1.singleChoices_id}" title="${single1.singleChoice_choice }">
			                    </div>
		                    </c:forEach>
	                    </div>
                     </li>
	       </c:forEach>
        </ul>
		
       <ul style="margin-left: 20px">
           <h3>二、多选题</h3>
          <%
          	int d = 0;
            int a = 0;
          %>
           <c:forEach items="${list_multiple}"  var="single">
           			<!-- 选项题目 -->
           			<li style="margin-left: 30px"><span style="display: inline;"><%= ++d %></span>.<p style="display: inline;">${single[0].multipleChoice_question}</p>
                   		<!-- 循环遍历所有的选项  -->
                   		<div class="layui-form-item" style="margin-left: -80px">
	                   		<c:forEach items="${single[1]}"  var="single1">
			                    <div class="layui-input-block">
			                        <input type="checkbox" name="multipleChoice_choice[<%= d %>][<%= a++ %>]" value="${single1.multipleChoices_id }" title="${single1.multipleChoice_choice }">
			                    </div>
		                    </c:forEach>
	                    </div>
	                 </li>   
	       </c:forEach>
        </ul>
		<%
          	int t = 1;
          %>
		<ul style="margin-left: 20px">
            <h3>三、填空题</h3>
            <c:forEach items="${list_fillBlank}"  var="single">
           			<!-- 题目 -->
           			<li style="margin-left: 30px"><span style="display: inline;"><%= t++ %></span>.
           			<p style="display: inline;">
           			${single[0].fillBlank_question}
           			</p>
           			<div class="layui-input-inline" style="background-color: red;">
           				<input type="text" name="fillBlank_choice<%= t %>" style="border:none;">
           			</div>
                   	</li>	
	       </c:forEach>
        </ul>
		<%
          	int p = 0;
          %>
		<ul style="margin-left: 20px">
            <h3>四、判断题</h3>
            <c:forEach items="${list_check}"  var="single">
           			<!-- 题目 -->
           			<li style="margin-left: 30px"><span style="display: inline;"><%= ++p %></span>.<p style="display: inline;">${single[0].check_question}</p>
                   		<div class="layui-form-item" style="margin-left: -80px">
	                   		<div class="layui-input-block">
				                  <input type="radio" name="check_choice<%= p %>" value="T" title="T">
				                  <input type="radio" name="check_choice<%= p %>" value="F" title="F">
		                    </div>	
	                    </div>
                     </li>
	       </c:forEach>
        </ul>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="anniu" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </form>
    <script>
   
        //JavaScript代码区域
        layui.use(['form','layer','element'],function() {
            var element = layui.element;
            var layer = layui.layer;
            var $ = layui.$; 
            var form = layui.form;

            /* 提交事件的触发     */
            form.on('submit(formDemo)', function(data){
              	
              	layer.msg(JSON.stringify(data.field));
              	
  	        	var a = JSON.stringify(data.field);
  	        	console.log(a);
  	        	$.ajax({
  	        	url:'${pageContext.request.contextPath}/map ',
  	        	type:"POST",
  	        	data:{'data':a},
  	        	success:function(result){
  		        	if(result=="success"){
  		        		//弹出框
  						layer.msg('提交成功', {icon: 1,time:1000},function(){
  							alert("试卷提交成功");
  						});
  		        	}
  		        		
  		         }});
  			 
  			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  			});  
            
            // 动态渲染   登录成功 根据登录名进行赋值
            $("#paper_id").val();
            $("#student_id").val();
           
        });
    </script>
</body>
</html>