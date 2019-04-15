<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理</title>
    <link rel="stylesheet" href="resources/lib/css/layui.css">
</head>
<body>
<blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">学生管理</blockquote>
<div class="layui-tab-item layui-show" style="margin-left: 10px">
    <div>
        <form class="layui-form">
            <div class="layui-inline">
                <input class="layui-input" name="username" id="username" placeholder="用户名（英文或数字）" autocomplete="off">
            </div>
            <button class="layui-btn" lay-submit lay-filter="search" data-type="reload">搜索</button>
            <button type="button" class="layui-btn" id="importExcel"style="position: absolute;right: 200px"><i class="layui-icon"></i>上传文件</button>
            <button class="layui-btn layui-btn-normal" id="addStudent" style="position: absolute;right: 100px">添加学生</button>
        </form>
        <table class="layui-table" id="studentInfoTable" lay-filter="dateTables"></table>
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
        
      //指定允许上传的文件类型
        upload.render({
          elem: '#importExcel'
          ,url: 'uploadSt'
          ,accept: 'file' //普通文件
          ,done: function(res){
	       	  if(res.data== "success"){
	        		layer.msg('提交成功');
	        	}
          }
        });

        //第一个实例
        var tableIns = table.render({
            elem: '#studentInfoTable'
            ,height: 315
            ,url: 'selectStudent' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'username',align:'center',edit:'text', title: '用户名'}
                ,{field: 'password',align:'center',edit:'text', title: '密码'}
                ,{field: 'student_name',align:'center',edit:'text', title: '姓名', sort: true}
                ,{field: 'role', align:'center',title: '角色'}
            ]]
        });
        $("#addStudent").click(function(){
            layer.open({
                type: 2,
                scriptCharset : 'utf-8',
                content: 'addStudent',//此处后期要改为地址映射
                contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
                maxmin: true,
                title:'添加学生',
                area: ['800px', '350px'],
                end: function(index, layero){
                    tableIns.reload();
                }
            });
            return false;
        });

        $("#importExcel").click(function(){

            return false;
        });
        form.on('submit(search)',function(data){
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    username: data.field.username
                }
            });
            return false;
        });

    });
</script>
</body>
</html>