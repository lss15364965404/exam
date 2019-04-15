<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组卷</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<form class="layui-form" id="form" style="display: none">
	    <div class="layui-form-item" style="margin-top: 20px;margin-left: -20px">
	        <label class="layui-form-label" >试卷名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="paper_name" placeholder="试卷名称" lay-verify="required" autocomplete="off" class="layui-input">
	        </div>
	    </div>
	    <div class="layui-form-item">
	        <label class="layui-form-label">分值</label>
	        <div class="layui-input-inline" id="singleChoice">
	            <input type="text" name="singleChoice_score" lay-verify="required" placeholder="单选题总分值" autocomplete="off" class="layui-input">
	            <input type="hidden" name="singleChoice_ids" lay-verify="required" id="singleChoice_ids"/>
	            <input type="hidden" name="singleChoice_answers" lay-verify="required" id="singleChoice_answers"/>
	            <input type="hidden" name="singleChoice_num" lay-verify="required" id="singleChoice_num"/>
	        </div>
	        <div class="layui-input-inline" id="check">
	            <input type="text" name="check_score" placeholder="判断题总分值" lay-verify="required" autocomplete="off" class="layui-input">
	            <input type="hidden" name="check_ids" lay-verify="required" id="check_ids"/>
	            <input type="hidden" name="check_answers" lay-verify="required" id="check_answers"/>
	            <input type="hidden" name="check_num" lay-verify="required" id="check_num"/>
	        </div>
	        <div class="layui-input-inline" id="fillBlank">
	            <input type="text" name="fillBlank_score" lay-verify="required" placeholder="填空题总分值" autocomplete="off" class="layui-input">
	            <input type="hidden" name="fillBlank_ids" lay-verify="required" id="fillBlank_ids"/>
	            <input type="hidden" name="fillBlank_answers" lay-verify="required" id="fillBlank_answers"/>
	            <input type="hidden" name="fillBlank_num" lay-verify="required" id="fillBlank_num"/>
	        </div>
	        <div class="layui-input-inline" id="multipleChoice">
	            <input type="text" name="multipleChoice_score" lay-verify="required" placeholder="多选题总分值" autocomplete="off" class="layui-input">
	            <input type="hidden" name="multipleChoice_ids" lay-verify="required" id="multipleChoice_ids"/>
	            <input type="hidden" name="multipleChoice_answers" lay-verify="required" id="multipleChoice_answers"/>
	            <input type="hidden" name="multipleChoice_num" lay-verify="required" id="multipleChoice_num"/>
	        </div>
	        <input type="hidden" id="teacher_id" name="teacher_id"/>
	    </div>
	    <div class="layui-form-item">
	        <div class="layui-input-block">
	            <button class="layui-btn layui-btn-normal" id="setQuestions">设置题目</button>
	            <button class="layui-btn" lay-submit lay-filter="addPaper">确定组卷</button>
	        </div>
	    </div>
	</form>

<div class="layui-tab layui-tab-brief" id="questions" lay-filter="rightTab" style="margin-left: 10px;">
    <ul class="layui-tab-title" style="margin-left: 10px" id="ul_qu">
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
    <button class="layui-btn layui-btn-normal" id="ok" style="margin-left:20px;">确认题目</button>
     <button class="layui-btn layui-btn-normal" id="over" style="margin-left:800px;">确认完成</button>
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
        $("#teacher_id").val("1");//动态赋值teacher_id
        $("#setQuestions").click(function(){
            $("#form").hide();
            $("#questions").show();
            return false;
        });
        $("#ok").click(function(){
            var checkStatus1 = table.checkStatus('singleChoice');
            var checkStatus2 = table.checkStatus('check');
            var checkStatus3 = table.checkStatus('fillBlank');
            var checkStatus4 = table.checkStatus('multipleChoice');
            var singleChoice_ids="";
            var singleChoice_answers="";
            var check_ids="";
            var check_answers="";
            var fillBlank_ids="";
            var fillBlank_answers="";
            var multipleChoice_ids="";
            var multipleChoice_answers="";
            var singleChoice_num = checkStatus1.data.length;
            var check_num =checkStatus2.data.length;
            var fillBlank_num =checkStatus3.data.length;
            var multipleChoice_num=checkStatus4.data.length;



            for(var i = 0;i<singleChoice_num;i++){
                if(i==0){
                    singleChoice_ids += checkStatus1.data[i].singleChoice_id;
                    singleChoice_answers += checkStatus1.data[i].singleChoiceAnswer_id;
                }else if(i>0){
                    singleChoice_ids += (","+checkStatus1.data[i].singleChoice_id);
                    singleChoice_answers += (","+checkStatus1.data[i].singleChoiceAnswer_id);
                }
            }
            if(singleChoice_num==0){
                $("#singleChoice input:gt(0)").removeAttr("lay-verify");
            }else{
                $("#singleChoice input").attr("lay-verify","required");
            }
            $("#singleChoice_ids").val(singleChoice_ids);
            $("#singleChoice_answers").val(singleChoice_answers);
            $("#singleChoice_num").val(singleChoice_num);
            for(var i = 0;i<check_num;i++){
                if(i==0){
                    check_ids += checkStatus2.data[i].check_id;
                    check_answers += checkStatus2.data[i].check_answer;
                }else if(i>0){
                    check_ids += (","+checkStatus2.data[i].check_id);
                    check_answers += (","+checkStatus2.data[i].check_answer);
                }
            }
            if(check_num==0){
                $("#check input:gt(0)").removeAttr("lay-verify");
            }else{
                $("#check input").attr("lay-verify","required");
            }
            $("#check_ids").val(check_ids);
            $("#check_answers").val(check_answers);
            $("#check_num").val(check_num);
            for(var i = 0;i<fillBlank_num;i++){
                if(i==0){
                    fillBlank_ids += checkStatus3.data[i].fillBlank_id;
                    fillBlank_answers += checkStatus3.data[i].fillBlank_answer;
                }else if(i>0){
                    fillBlank_ids += (","+checkStatus3.data[i].fillBlank_id);
                    fillBlank_answers += (","+checkStatus3.data[i].fillBlank_answer);
                }
            }
            if(fillBlank_num==0){
                $("#fillBlank input:gt(0)").removeAttr("lay-verify");
            }else{
                $("#fillBlank input").attr("lay-verify","required");
            }
            $("#fillBlank_ids").val(fillBlank_ids);
            $("#fillBlank_answers").val(fillBlank_answers);
            $("#fillBlank_num").val(fillBlank_num);
            for(var i = 0;i<multipleChoice_num;i++){
                if(i==0){
                    multipleChoice_ids += checkStatus4.data[i].multipleChoice_id;
                    multipleChoice_answers += checkStatus4.data[i].multipleChoiceAnswer_ids;
                }else if(i>0){
                    multipleChoice_ids += (","+checkStatus4.data[i].multipleChoice_id);
                    multipleChoice_answers += ("@"+checkStatus4.data[i].multipleChoiceAnswer_ids);
                }
            }
            if(multipleChoice_num==0){
                $("#multipleChoice input:gt(0)").removeAttr("lay-verify");
            }else{
                $("#multipleChoice input").attr("lay-verify","required");
            }
            $("#multipleChoice_ids").val(multipleChoice_ids);
            $("#multipleChoice_answers").val(multipleChoice_answers);
            $("#multipleChoice_num").val(multipleChoice_num);
            layer.msg('完成',{icon:1,time:1000});
            return false;
        });
       
        $("#over").click(function(){

            $("#questions").hide();
            $("#form").show();
            return false;
        })



        element.on('tab(rightTab)',function(data){
            var layid = data.index;
            if(layid+1 == 2){
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
            ,id: 'singleChoice'
            ,url: 'selectSingleChoice' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{type:'checkbox'}
                ,{field: 'singleChoice_id',align:'center',title:'ID'}
                ,{field: 'singleChoice_question',align:'center', title: '题目'}
                ,{field: 'singleChoiceAnswer_id',align:'center', title: '正确答案'}
                ,{field: 'singleChoice_stage',align:'center', title: '题目阶段'}
                ,{field: 'name',align:'center', title: '出题老师'}
                ,{field: 'singleChoice_useNum',align:'center', title: '学生做题次数', sort: true}
                ,{field: 'singleChoice_rightNum',align:'center', title: '学生正确次数', sort: true}
                ,{field: 'singleChoice_accuracy',align:'center', title: '学生正确率', sort: true}
            ]]
            ,data:[
                {
                    singleChoice_question:'asef',
                    singleChoiceAnswer_id:4,
                    singleChoice_id:1

                },{
                    singleChoice_question:'asefaseasef',
                    singleChoiceAnswer_id:5,
                    singleChoice_id:2

                }
            ]
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
            ,id:'check'
            ,url: 'selectCk' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{type:'checkbox'}
                ,{field: 'check_id',align:'center',title:'ID'}
                ,{field: 'check_question',align:'center', title: '题目'}
                ,{field: 'check_answer',align:'center', title: '正确答案'}
                ,{field: 'check_stage',align:'center', title: '题目阶段'}
                ,{field: 'name',align:'center', title: '出题老师'}
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
            ,id:'fillBlank'
            ,url: 'selectFk' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
            	{type:'numbers',title:'序号'}
            	,{type:'checkbox'}
            	,{field: 'fillBlank_id',align:'center',title:'ID'}
            	,{field: 'fillBlank_question',align:'center', title: '题目'}
                ,{field: 'fillBlank_answer',align:'center', title: '正确答案'}
                ,{field: 'fillBlank_stage',align:'center', title: '题目阶段'}
                ,{field: 'name',align:'center', title: '出题老师'}
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

        //第四个实例
        var tableIns4 = table.render({
            elem: '#multipleChoiceInfoTable'
            ,id:'multipleChoice'
            ,height: 315
            ,url: 'selectMu' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {type:'numbers',title:'序号'}
                ,{type:'checkbox'}
                ,{field: 'multipleChoice_id',align:'center',title:'ID'}
                ,{field: 'multipleChoice_question',align:'center', title: '题目'}
                ,{field: 'multipleChoiceAnswer_ids',align:'center', title: '正确答案'}
                ,{field: 'multipleChoice_stage',align:'center', title: '题目阶段'}
                ,{field: 'name',align:'center', title: '出题老师'}
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


        form.on('submit(addPaper)',function(data){


            layer.confirm('确定组卷吗？',  { title:'确认'},function(index){

                alert(JSON.stringify(data.field));


                $.post("addPaperZH","data="+JSON.stringify(data.field),function(msg){
               
                    if(msg == "true"){
                    	alert("组卷成功！");
                       /*  layer.msg("组卷成功！"); */
                    }else if(msg == "false"){
                    	alert("组卷失败!");
                        /* layer.msg("组卷失败!",{anim: 6}); */
                    }
                });

                layer.close(index);
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index);
            });
            return false;

        });

    });
</script>
	
</body>
</html>