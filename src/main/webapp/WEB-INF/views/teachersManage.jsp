<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>老师管理</title>
    <%@ include file="head.jsp" %>
   <!--  <link rel="stylesheet" href="lib/css/layui.css"> -->
</head>
<body>
    <blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">老师管理</blockquote>
    <div class="layui-tab-item layui-show" style="margin-left: 10px">
        <div>
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="username" id="teacher_name" placeholder="用户名（英文或数字）" autocomplete="off">
                </div>
                <button class="layui-btn" lay-submit lay-filter="search" data-type="reload">搜索</button>
               	<button type="button" class="layui-btn" id="importExcel"style="position: absolute;right: 200px"><i class="layui-icon"></i>上传文件</button>
                <button class="layui-btn layui-btn-normal" id="addTeacher" style="position: absolute;right: 100px">添加老师</button>
            </form>
            <table class="layui-table" id="teacherInfoTable" lay-filter="dateTables"></table>
        </div>
    </div>
    <script src="resources/lib/layui.js"></script>

    <script>
        //JavaScript代码区域
        layui.use(['element','layer','form','table','upload'],function(){
            var element = layui.element;
            var layer = layui.layer;
            var $ = layui.$;
            
            var upload = layui.upload;
            var form = layui.form;
            var table = layui.table;

            
            //table处的js
            var tableIns = table.render({
                elem: '#teacherInfoTable'
                ,height: 315
                ,url: 'selectTeacher' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {type:'numbers',title:'序号'}
                    ,{field: 'username',align:'center',edit:'text', title: '用户名'}
                    ,{field: 'password',align:'center',edit:'text', title: '密码'}
                    ,{field: 'teacher_name',align:'center',edit:'text', title: '姓名', sort: true}
                    ,{field: 'role', align:'center',title: '角色'}
                ]]
            });
            
          //指定允许上传的文件类型
            upload.render({
              elem: '#importExcel'
              ,url: 'uploadTe'
              ,accept: 'file' //普通文件
              ,done: function(res){
    	       	  if(res.data== "success"){
    	        		layer.msg('提交成功');
    	        	}
              }
            });
            
            //搜索框的数据设置
            form.on('submit(search)',function(data){
            	tableIns.reload({
                    where: { //设定异步数据接口的额外参数，任意设
                    	username: data.field.username
                    }
                });
                return false;
            });
            
            //添加老师
            $("#addTeacher").click(function(){
                layer.open({
                    type: 2,
                    content: 'addTeacher',//此处后期要改为地址映射
                    maxmin: true,
                    title:'添加老师',
                    area: ['800px', '300px'],
                    end: function(index, layero){
                        tableIns.reload();
                    }
                });
                return false;
            });

            //监听工具条
            table.on('tool(dateTables)', function(obj){
                var data = obj.data;
                if(obj.event === 'detail'){
                    layer.open({
                        type: 2,
                        content: 'editTeacherInfo.html?user_id='+data.user_id,
                        maxmin: true,
                        area: ['800px', '300px'],
                        end: function(index, layero){
                            tableIns.reload();
                        }
                    });
                }
            });

            

        });
    </script>
</body>
</html>