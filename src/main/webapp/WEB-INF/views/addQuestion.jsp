<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出题</title>
<%@ include file="head.jsp" %>
</head>
<body>
 <form class="layui-form">
            <div class="layui-form-item" style="margin-top: 20px;">
                <label class="layui-form-label">题目类型</label>
                <div class="layui-input-block">
                    <select   name="question_type" lay-filter="question_type" lay-verify="required" id="question_type">
                        <option value="">题目类型</option>
                        <option value="单选">单选</option>
                        <option value="判断">判断</option>
                        <option value="填空">填空</option>
                        <option value="多选">多选</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">题目阶段</label>
                <div class="layui-input-block">
                    <select   name="question_stage" lay-verify="required" id="question_stage">
                        <option value="">题目阶段</option>
                        <option value="前端">前端</option>
                        <option value="数据库">数据库</option>
                        <option value="J2SE">J2SE</option>
                        <option value="J2EE">J2EE</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">题目题干</label>
                <div class="layui-input-block">
                    <textarea placeholder="题目题干" lay-verify="required"  name="question_body" id="question_body" class="layui-textarea"></textarea>
                </div>
            </div>
            <div id="singleChoice_answer" class="answer" style="display: none">
                <div class="layui-form-item">
                    <label class="layui-form-label">正确选项</label>
                    <div class="layui-input-block">
                        <input type="text" name="singleChoice_rightAnswer" lay-verify="required" placeholder="正确选项" autocomplete="off" class="layui-input required">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">错误选项</label>
                    <div class="layui-input-block">
                        <textarea placeholder="错误选项(答案之间用英文状态的,隔开,否则无法正确识别)" lay-verify="required"   name="singleChoice_wrongAnswer"  class="layui-textarea required"></textarea>
                    </div>
                </div>
            </div>
            <div id="checkChoice_answer" class="answer"  style="display: none">
                <div class="layui-form-item">
                    <label class="layui-form-label">判断题答案</label>
                    <div class="layui-input-block">
                        <input type="radio" name="check_answer" value="0" title="错误" checked>
                        <input type="radio" name="check_answer" value="1" title="正确" >
                    </div>
                </div>
            </div>
            <div id="fillBlank_answer" class="answer"  style="display: none">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">填空答案</label>
                    <div class="layui-input-block">
                        <textarea placeholder="填空答案(答案之间请回车,否则无法正确识别)" lay-verify="required"   name="fillBlank_answer"  class="layui-textarea required"></textarea>
                    </div>
                </div>
            </div>
            <div id="multipleChoice_answer" class="answer"  style="display: none">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">正确选项</label>
                    <div class="layui-input-block">
                        <textarea placeholder="正确选项(答案之间用英文状态的,隔开,否则无法正确识别)" lay-verify="required"  name="multipleChoice_rightAnswer"  class="layui-textarea required"></textarea>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">错误选项</label>
                    <div class="layui-input-block">
                        <textarea placeholder="错误选项(答案之间用英文状态的,隔开,否则无法正确识别)" lay-verify="required"   name="multipleChoice_wrongAnswer"  class="layui-textarea required"></textarea>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="*">提交</button>
                    <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
    </form>
    <script>
        //JavaScript代码区域
        layui.use(['element','layer','form'],function() {
            var element = layui.element;
            var layer = layui.layer;
            var $ = layui.$;
            var form = layui.form;


            form.on('select(question_type)',function(data){
                if(data.value == '单选'){
                    $(".answer").hide();
                    $("#singleChoice_answer").show();
                    $(".required").removeAttr("lay-verify");
                    $("#singleChoice_answer .required").attr("lay-verify","required");
                }else if(data.value == '判断'){
                    $(".answer").hide();
                    $("#checkChoice_answer").show();
                    $(".required").removeAttr("lay-verify");
                    $("#checkChoice_answer .required").attr("lay-verify","required");
                }else if(data.value == '填空'){
                    $(".answer").hide();
                    $("#fillBlank_answer").show();
                    $(".required").removeAttr("lay-verify");
                    $("#fillBlank_answer .required").attr("lay-verify","required");
                }else if(data.value == '多选'){
                    $(".answer").hide();
                    $("#multipleChoice_answer").show();
                    $(".required").removeAttr("lay-verify");
                    $("#multipleChoice_answer .required").attr("lay-verify","required");
                }else{
                    $(".answer").hide();
                }
            });

            $("#reset").click(function(){
                $(".answer").hide();
            });
            // 监听提交
            form.on('submit(*)',function(data){
            	// 获取表单所有值
            	var a = JSON.stringify(data.field);
            	console.log(data.field);
            	alert("提交")
            	
            		
                    if($("#question_type").val() == '单选'){
                    	
                    	$.ajax({
        	            	url:'addSing',
        	            	data:{'data':a},
        	            	success:function(result){
        	            	
        	    	        	if(result== "success"){
        	    	        		
        	    	        		layer.msg(' 提交成功 ', {icon: 1,time:1000},function(){
        	    	        			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	    						parent.layer.close(index);//关闭自身
        	    						location.href="addQuestion";
        	    	        		});
        	    	        		
        	    	        	}
        	    	        	
            	         }});
                    }else if($("#question_type").val() == '判断'){
                    	$.ajax({
        	            	url:'addCheck',
        	            	data:{'data':a},
        	            	success:function(result){
        	    	        	if(result== "success"){
        	    	        		layer.msg(' 提交成功 ', {icon: 1,time:1000},function(){
        	    	        			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	    						parent.layer.close(index);//关闭自身
        	    						location.href="addQuestion";
        	    	        		});
        	    	        	}
            	         }});
                    }else if($("#question_type").val() == '填空'){
                    	$.ajax({
        	            	url:'addFill',
        	            	data:{'data':a},
        	            	success:function(result){
        	    	        	if(result== "success"){
        	    	        		layer.msg(' 提交成功 ', {icon: 1,time:1000},function(){
        	    	        			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	    						parent.layer.close(index);//关闭自身
        	    						location.href="addQuestion";
        	    	        		});
        	    	        	}
            	         }});
                    }else if($("#question_type").val() == '多选'){
                    	$.ajax({
        	            	url:'addMul',
        	            	data:{'data':a},
        	            	success:function(result){
        	            		
        	    	        	if(result== "success"){
        	    	        		layer.msg(' 提交成功 ', {icon: 1,time:1000},function(){
        	    	        			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	    						parent.layer.close(index);//关闭自身
        	    						location.href="addQuestion";
        	    	        		});
        	    	        	}
            	         }});
                    }
            		
            	 return false;
            	
            });
           
        });
    </script>
</body>
</html>