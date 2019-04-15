<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>登录页面</title>
   <%@ include file="head.jsp" %>
    <style>
        *{
            margin: 0px auto;
        }
        body{
            background-image: url("images/login/login.jpg");
            background-size: 1570px,1000px;
            background-repeat:no-repeat
        }
        #top{
            width: 300px;
            height: 130px;
            margin-top: 30px;
            margin-left: 530px;
        }
        #top img{
            width: 100%;
            height: 100%;
        }
        #biao{
            width: 450px;
            height: 200px;
            border: none;
            margin-top: 50px;
            margin-left: 450px;
        }
    </style>
</head>
<body>
    <div>
            <div id="top">
                 <img src="images/login/login_top.png">
            </div>
            <div id="biao" class="layui-tab layui-tab-card">
                <ul class="layui-tab-title">
                    <li class="layui-this">学生登录</li>
                    <li>教师登录</li>
                    <li>管理员登录</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                    
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="username" required  lay-verify="username" placeholder="请输入你的姓名" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="pass" placeholder="请输入密码(班级名称)" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">如：1420333</div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <input type="hidden" name="role" required lay-verify="role" value="学生" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="layui-tab-item">
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="username" required  lay-verify="username" placeholder="请输入你的姓名" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="pass" placeholder="请输入(教师)登录密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux"></div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <input type="hidden" name="role" required lay-verify="role" value="教师" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="layui-tab-item">
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="username" required  lay-verify="username" placeholder="请输入你的姓名" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="pass" placeholder="请输入(管理员)登录密码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux"></div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <input type="hidden" name="role" required lay-verify="role" value="管理员" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
            <script>
                layui.use('element', function(){
                    var $ = layui.jquery
                            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
                    //触发事件
                    var active = {
                        tabAdd: function(){
                            //新增一个Tab项
                            element.tabAdd('demo', {
                                title: '新选项'+ (Math.random()*1000|0) //用于演示
                                ,content: '内容'+ (Math.random()*1000|0)
                                ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                            })
                        }
                        ,tabDelete: function(othis){
                            //删除指定Tab项
                            element.tabDelete('demo', '44'); //删除：“商品管理”
                            othis.addClass('layui-btn-disabled');
                        }
                        ,tabChange: function(){
                            //切换到指定Tab项
                            element.tabChange('demo', '22'); //切换到：用户管理
                        }
                    };
                    $('.site-demo-active').on('click', function(){
                        var othis = $(this), type = othis.data('type');
                        active[type] ? active[type].call(this, othis) : '';
                    });
                    //Hash地址的定位
                    var layid = location.hash.replace(/^#test=/, '');
                    element.tabChange('test', layid);
                    element.on('tab(test)', function(elem){
                        location.hash = 'test='+ $(this).attr('lay-id');
                    });
                });
            </script>
            <script>
                //Demo
                layui.use(['form','layer','element'], function(){
                    var form = layui.form;
                    var $ = layui.$; 
                    var element = layui.element;
                    var layer = layui.layer;
                    //输入验证
                    form.verify({
                        username: function(value, item){ //value：表单的值、item：表单的DOM对象
                            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                                return '用户名不能有特殊字符';
                            }
                            if(!new RegExp("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$").test(value)){
                                return '用户名首尾不能出现下划线\'_\'';
                            }
                            if(!new RegExp(/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{2,16}$/gi).test(value)){
                                return '用户名必须2到4个汉字，且不能出现空格';
                            }
                        }
                        //我们既支持上述函数式的方式，也支持下述数组的形式
                        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                        ,pass: [
                            /^[\S]{5,12}$/
                            ,'密码必须6到12位，且不能出现空格'
                        ]
                    });
                    
                    //监听提交
                    /* 提交事件的触发     */
                    form.on('submit(formDemo)', function(data){
                      	
                      	layer.msg(JSON.stringify(data.field));
                      	
          	        	var a = JSON.stringify(data.field);
          	        	console.log(a);
          	        	$.ajax({
          	        	url:'${pageContext.request.contextPath}/selectUser',
          	        	type:"POST",
          	        	data:{'data':a},
          	        	success:function(result){
          		        	if(result=="index_1"){
          		        		//弹出框
          						layer.msg('管理员用户登录成功', {icon: 1,time:1000},function(){
          							alert("管理员用户登录成功");
              		        		window.location.href='index';
          						});
          		        	}else if(result=="index_2"){
          		        		//弹出框
          						layer.msg('教师用户登录成功', {icon: 1,time:1000},function(){
          							alert("教师用户登录成功");
              		        		window.location.href='index';
          						});
          		        	}else if(result=="doExam"){
          		        		//弹出框
          						layer.msg('学生用户登录成功', {icon: 1,time:1000},function(){
          							alert("学生用户登录成功");
              		        		window.location.href='index';
          						});
          		        	}else if(result=="noUser"){
          		        		//弹出框
          						layer.msg('登录失败,请重新登录！', {icon: 1,time:1000},function(){
          						});
          		        	}
          		         }});
          			 	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
          			});  
                });
            </script>
      </div>
</body>
</html>