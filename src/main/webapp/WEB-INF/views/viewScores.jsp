<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看成绩</title>
    <%@ include file="head.jsp" %>
</head>
<body>
    <blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">查看成绩</blockquote>
    <div class="layui-tab-item layui-show" style="margin-left: 10px">
        <div>
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="paper_name" id="paper_name" placeholder="试卷名" autocomplete="off">
                </div>
                <button class="layui-btn" lay-submit lay-filter="search" data-type="reload">搜索</button>
            </form>
            <table class="layui-table" id="gradeInfoTable" lay-filter="dateTables"></table>
        </div>
    </div>
    <script src="resources/lib/layui.js"></script>

    <script>
        //JavaScript代码区域
        layui.use(['element','layer','form','table'],function(){
            var element = layui.element;
            var layer = layui.layer;
            var $ = layui.$;
            var form = layui.form;
            var table = layui.table;

            //table处的js
            var tableIns = table.render({
                elem: '#gradeInfoTable'
                ,height: 315
                ,url: 'selectStudentGrade' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {type:'numbers',title:'序号'}
                    ,{field: 'paper_name',align:'center',edit:'text', title: '试卷名', sort: true}
                    ,{field: 'singleChoice_grade',align:'center',edit:'text', title: '单选题'}
                    ,{field: 'check_grade',align:'center',edit:'text', title: '判断题'}
                    ,{field: 'fillBlank_grade',align:'center',edit:'text', title: '填空题'}
                    ,{field: 'multipleChoice_grade',align:'center',edit:'text', title: '多选题'}
                    ,{field: 'testResult_grade', align:'center',title: '学生总分'}
                ]]
            });
            form.on('submit(search)',function(data){
            	tableIns.reload({
                    where: { //设定异步数据接口的额外参数，任意设
                    	paper_name: data.field.paper_name
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