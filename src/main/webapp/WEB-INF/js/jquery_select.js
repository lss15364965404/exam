/**
 * Created by Administrator on 2017/12/11.
 */

/*---------�������������˵� JS �ű�--------*/

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
 * ���Ա�����ȡ����ֵ
 */
function getSelectValue(){

    alert("1��="+$("#province").val());

    $(".city").each(function(i,o){

        if(i == currentShowCity){

            alert("2��="+$(".city").eq(i).val());

        }

    });

}

$(function(){

    $('.date_picker').date_input();

});