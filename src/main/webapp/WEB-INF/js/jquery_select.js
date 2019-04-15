/**
 * Created by Administrator on 2017/12/11.
 */

/*---------二级联动下拉菜单 JS 脚本--------*/

var currentShowCity=0;

$(document).ready(function(){

    $("#province").change(function(){

        $("#province option").each(function(i,o){

            if($(this).attr("selected"))

            {

                $(".city").hide();

                $(".city").eq(i).show();

                currentShowCity=i;

            }

        });

    });

    $("#province").change();

});

/**
 * 测试变量获取到的值
 */
function getSelectValue(){

    alert("1级="+$("#province").val());

    $(".city").each(function(i,o){

        if(i == currentShowCity){

            alert("2级="+$(".city").eq(i).val());

        }

    });

}

$(function(){

    $('.date_picker').date_input();

});