<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎界面</title>
<%@ include file="head.jsp" %>
<style type="text/css">
	*{
		margin: 0px auto;
	}
	#img{
		 margin-top: 20px; 
		 margin-left: 60px; 
	}
</style>
</head>
<body>
	<div class="layui-carousel" id="main">
        <!-- <div carousel-item> -->
        <div id="img">
            <img src="images/welcome/welcome.jpg" width="95%" height="500px">
            <!-- <div><img src="images/welcome/carousel1.jpg" width="450px"></div>
            <div><img src="images/welcome/carousel2.jpg" width="450px"></div>
            <div><img src="images/welcome/carousel3.jpg" width="450px"></div>
            <div><img src="images/welcome/carousel4.jpg" width="450px"></div>
            <div><img src="images/welcome/carousel5.jpg" width="450px"></div> -->
        </div>
    </div>
</body>
</html>