<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我组的卷</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">我组的卷</blockquote>
<div class="layui-tab-item layui-show" style="margin-left: 10px">
    <div>
        <form class="layui-form">
            <div class="layui-inline">
                <input class="layui-input" name="paper_name" id="paper_name" placeholder="试卷名称" autocomplete="off">
            </div>
             <button class="layui-btn" lay-submit lay-filter="search" data-type="reload">搜索</button>
<!--           <button type="button" class="layui-btn" id="importExcel"style="position: absolute;right: 200px"><i class="layui-icon"></i>上传文件</button>
 -->             <button class="layui-btn layui-btn-normal" id="addPaper" style="position: absolute;right: 100px">组卷</button>
        </form>
        <table class="layui-table" id="paperInfoTable" lay-filter="dateTables"></table>
    </div>
</div>
<script src="lib/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use(['element','layer','form','table'],function(){
        var element = layui.element;
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;
        var table = layui.table;

        //第一个实例
        var tableIns = table.render({
            elem: '#paperInfoTable'
            ,height: 315
            ,url: 'selectPaper' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号',rowspan:2}
                ,{field: 'paper_name',align:'center',edit:'text', title: '试卷名称', sort: true,rowspan:2}
                ,{align: 'center', title: '单选题', colspan: 2}
                ,{align: 'center', title: '判断题', colspan: 2}
                ,{align: 'center', title: '填空题', colspan: 2}
                ,{align: 'center', title: '多选题', colspan: 2}
                ,{field: 'teacher_name', align:'center',title: '出题老师',rowspan:2}
            ],[
                {field: 'singleChoice_num',align:'center', title: '数目'}
                ,{field: 'singleChoice_score',align:'center',edit:'text', title: '分值'}
                ,{field: 'check_num',align:'center', title: '数目'}
                ,{field: 'check_score',align:'center',edit:'text', title: '分值'}
                ,{field: 'fillBlank_num',align:'center', title: '数目'}
                ,{field: 'fillBlank_score',align:'center',edit:'text', title: '分值'}
                ,{field: 'multipleChoice_num',align:'center', title: '数目'}
                ,{field: 'multipleChoice_score',align:'center',edit:'text', title: '分值'}
            ]]
        });
        $("#addPaper").click(function(){
            layer.open({
                type: 2,
                content: 'addPaper',//此处后期要改为地址映射
                //maxmin: true,
                title:'组卷',
                area: ['100%', '100%'],
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
                    content: 'editPaper.html?paper_id='+data.paper_id,
                    maxmin: true,
                    area: ['100%', '100%'],
                    end: function(index, layero){
                        tableIns.reload();
                    }
                });
            }
        });

        form.on('submit(search)',function(data){
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设
                	paperName: data.field.paper_name
                }
            });
            return false;
        });

    });
</script>
</body>
</html>