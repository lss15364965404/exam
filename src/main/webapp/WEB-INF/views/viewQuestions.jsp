<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查看题库</title>
    <%@ include file="head.jsp" %>
</head>
<body>
<blockquote class="layui-elem-quote" style="margin-top: 20px;margin-left: 10px;">查看题库</blockquote>
<div class="layui-tab layui-tab-brief" lay-filter="rightTab">
    <ul class="layui-tab-title" style="margin-left: 10px">
        <li class="layui-this">单选题</li>
        <li>判断题</li>
        <li>填空题</li>
        <li>多选题</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" >
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="singleChoice_question" id="singleChoice_question" placeholder="单选题目" autocomplete="off">
                </div>
                <div class="layui-inline">
                    <select   name="singleChoice_stage" id="singleChoice_stage">
                        <option value="">题目阶段</option>
                        <option value="前端">前端</option>
                        <option value="数据库">数据库</option>
                        <option value="J2SE">J2SE</option>
                        <option value="J2EE">J2EE</option>
                    </select>
                </div>
                <button class="layui-btn" lay-submit lay-filter="search1" data-type="reload">搜索</button>
            </form>
            <table class="layui-table" id="singleChoiceInfoTable" lay-filter="dateTables"></table>
        </div>

        <div class="layui-tab-item">
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="check_question" id="check_question" placeholder="判断题题目" autocomplete="off">
                </div>
                <div class="layui-inline">
                    <select   name="check_stage" id="check_stage">
                        <option value="">题目阶段</option>
                        <option value="前端">前端</option>
                        <option value="数据库">数据库</option>
                        <option value="J2SE">J2SE</option>
                        <option value="J2EE">J2EE</option>
                    </select>
                </div>
                <button class="layui-btn" lay-submit lay-filter="search2" data-type="reload">搜索</button>
            </form>
            <table class="layui-table" id="checkInfoTable" lay-filter="dateTables"></table>
        </div>

        <div class="layui-tab-item">
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="fillBlank_question" id="fillBlank_question" placeholder="填空题题目" autocomplete="off">
                </div>
                <div class="layui-inline">
                    <select   name="fillBlank_stage" id="fillBlank_stage">
                        <option value="">题目阶段</option>
                        <option value="前端">前端</option>
                        <option value="数据库">数据库</option>
                        <option value="J2SE">J2SE</option>
                        <option value="J2EE">J2EE</option>
                    </select>
                </div>
                <button class="layui-btn" lay-submit lay-filter="search3" data-type="reload">搜索</button>
            </form>
            <table class="layui-table" id="fillblankInfoTable" lay-filter="dateTables"></table>
        </div>

        <div class="layui-tab-item">
            <form class="layui-form">
                <div class="layui-inline">
                    <input class="layui-input" name="multipleChoice_question" id="multipleChoice_question" placeholder="多选题题目" autocomplete="off">
                </div>
                <div class="layui-inline">
                    <select   name="multipleChoice_stage" id="multipleChoice_stage">
                        <option value="">题目阶段</option>
                        <option value="前端">前端</option>
                        <option value="数据库">数据库</option>
                        <option value="J2SE">J2SE</option>
                        <option value="J2EE">J2EE</option>
                    </select>
                </div>
                <button class="layui-btn" lay-submit lay-filter="search4" data-type="reload">搜索</button>
            </form>
            <table class="layui-table" id="multipleChoiceInfoTable" lay-filter="dateTables"></table>
        </div>
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

        element.on('tab(rightTab)',function(data){
            var layid = data.index;
            if(layid+1 == 1){
                tableIns1.reload();
            }else if(layid+1 == 2){
                tableIns2.reload();
            }else if(layid+1 == 3){
                tableIns3.reload();
            }else if(layid+1 == 4){
                tableIns4.reload();
            }
        });

        //第一个实例
        var tableIns1 = table.render({
            elem: '#singleChoiceInfoTable'
            ,height: 315
            ,url: 'selectSingleChoice' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'singleChoice_question',align:'center', title: '题目'}
                ,{field: 'singleChoice_choice',align:'center', title: '正确答案'}
                ,{field: 'singleChoice_stage',align:'center', title: '题目阶段'}
                ,{field: 'teacher_name',align:'center', title: '出题老师'}
                ,{field: 'singleChoice_useNum',align:'center', title: '学生做题次数', sort: true}
                ,{field: 'singleChoice_rightNum',align:'center', title: '学生正确次数', sort: true}
                ,{field: 'singleChoice_accuracy',align:'center', title: '学生正确率', sort: true}
            ]]
        });
        form.on('submit(search1)',function(data){
            tableIns1.reload({
                where: { //设定异步数据接口的额外参数，任意设
                	stem: data.field.singleChoice_question
                    ,stage: data.field.singleChoice_stage
                }
            });
            return false;
        });

        //第二个实例
        var tableIns2 = table.render({
            elem: '#checkInfoTable'
            ,height: 315
            ,url: 'selectCk' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'check_question',align:'center', title: '题目'}
                ,{field: 'check_answer',align:'center', title: '正确答案'}
                ,{field: 'check_stage',align:'center', title: '题目阶段'}
                ,{field: 'teacher_name',align:'center', title: '出题老师'}
                ,{field: 'check_useNum',align:'center',title: '学生做题次数', sort: true}
                ,{field: 'check_rightNum',align:'center', title: '学生正确次数', sort: true}
                ,{field: 'check_accuracy',align:'center', title: '学生正确率', sort: true}
            ]]
        });
        form.on('submit(search2)',function(data){
            tableIns2.reload({
                where: { //设定异步数据接口的额外参数，任意设
                	stem: data.field.check_question
                    ,stage: data.field.check_stage
                }
            });
            return false;
        });
        
        //第三个实例
        var tableIns3 = table.render({
            elem: '#fillblankInfoTable'
            ,height: 315
            ,url: 'selectFk' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'fillBlank_question',align:'center', title: '题目'}
                ,{field: 'fillBlank_answer',align:'center', title: '正确答案'}
                ,{field: 'fillBlank_stage',align:'center', title: '题目阶段'}
                ,{field: 'teacher_name',align:'center', title: '出题老师'}
                ,{field: 'fillBlank_useNum',align:'center', title: '学生做题次数', sort: true}
                ,{field: 'fillBlank_rightNum',align:'center', title: '学生正确次数', sort: true}
                ,{field: 'fillBlank_accuracy',align:'center', title: '学生正确率', sort: true}
            ]]
        });
        form.on('submit(search3)',function(data){
            tableIns3.reload({
                where: { //设定异步数据接口的额外参数，任意设
                	stem: data.field.fillBlank_question
                    ,stage: data.field.fillBlank_stage
                }
            });
            return false;
        });

        //第4个实例
        var tableIns4 = table.render({
            elem: '#multipleChoiceInfoTable'
            ,height: 315
            ,url: 'selectMu' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{field: 'multipleChoice_question',align:'center', title: '题目'}
                ,{field: 'multipleChoice_choice',align:'center', title: '正确答案'}
                ,{field: 'multipleChoice_stage',align:'center', title: '题目阶段'}
                ,{field: 'teacher_name',align:'center', title: '出题老师'}
                ,{field: 'multipleChoice_useNum',align:'center', title: '学生做题次数', sort: true}
                ,{field: 'multipleChoice_rightNum',align:'center', title: '学生正确次数', sort: true}
                ,{field: 'multipleChoice_accuracy',align:'center', title: '学生正确率', sort: true}
            ]]
        });
        form.on('submit(search4)',function(data){
            tableIns4.reload({
                where: { //设定异步数据接口的额外参数，任意设
                	stem: data.field.multipleChoice_question
                    ,stage: data.field.multipleChoice_stage
                }
            });
            return false;
        });

    });
</script>

</body>
</html>