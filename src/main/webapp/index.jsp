<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<h2>Teach Hello World!</h2>
	<a href="freeMarker/hello">say hello</a><br/>
	<a href="freeMarker/hello2">say hello2</a><br/>
	<a href="freeMarker/hi">say hi</a><br/>
	<a href="freeMarker/jsp">jspRequest</a><br>
	<a href="paging/">freemarker前台分页</a><br>
	<a href="myPage/1">userPage</a>
	<a href="cntUserPage/1">cntUserPage</a>
</body>
</html>
