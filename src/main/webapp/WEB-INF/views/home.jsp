<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. 哈哈哈</P>
	<form action="后台连接" method="post" enctype="multipart/form-data"> 	
		请选择文件:<input type="file" class="btn btn-default"  name="file"><br/>     
		<input type="submit" class="btn btn-default" value="提交"> 
	</form>
</body>
</html>
