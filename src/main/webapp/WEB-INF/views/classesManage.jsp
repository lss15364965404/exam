<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>班级管理</title>
    <link rel="stylesheet" href="resources/lib/css/layui.css">
</head>
<body>
<blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">班级管理</blockquote>
<div class="layui-tab-item layui-show" style="margin-left: 10px">
    <div>
        <form class="layui-form">
            <div class="layui-inline">
                <input class="layui-input" name="class_name" id="class_name" placeholder="班级名称" autocomplete="off">
            </div>
            <button class="layui-btn" lay-submit lay-filter="search" data-type="reload">搜索</button>
            <button type="button" class="layui-btn" id="importExcel"style="position: absolute;right: 200px"><i class="layui-icon"></i>上传文件</button>
            <button class="layui-btn layui-btn-normal" id="addClass" style="position: absolute;right: 100px">添加班级</button>
        </form>
        <table class="layui-table" id="classInfoTable" lay-filter="dateTables"></table>
    </div>
</div>
<script src="resources/lib/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use(['element','layer','form','table','upload'],function(){
        var element = layui.element;
        var layer = layui.layer;
        //var $ = layui.$;
        var $ = layui.jquery
        ,upload = layui.upload;
        var form = layui.form;
        var table = layui.table;
        
        //指定允许上传的文件类型
        upload.render({
          elem: '#importExcel'
          ,url: 'uploadCl'
          ,accept: 'file' //普通文件
          ,done: function(res){
	       	  if(res.data== "success"){
	        		layer.msg('提交成功');
	        	}
          }
        });

        //第一个实例
        var tableIns = table.render({
            elem: '#classInfoTable'
            ,height: 315
            ,url: 'selectClass' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'class_name',align:'center',edit:'text', title: '班级名称', sort: true}
                ,{field: 'class_student_num',align:'center',edit:'text', title: '学生数', sort: true}
            ]]
        });
        $("#addClass").click(function(){
            layer.open({
                type: 2,
                content: 'addClass',//此处后期要改为地址映射
                maxmin: true,
                title:'添加班级',
                area: ['800px', '350px'],
                end: function(index, layero){
                    tableIns.reload();
                }
            });
            return false;
        });

        form.on('submit(search)',function(data){
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    class_name: data.field.class_name
                }
            });
            return false;
        });

    });
</script>
</body>
</html>