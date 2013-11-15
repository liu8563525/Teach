<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  				<form name="pagedForm" action="<%=basePath%>user.do?method=list" method="post">
  
  				<table id="authTable" width="100%" border="1" cellpadding="0" cellspacing="0">						
					<tr id="root" align="center">
						<th>编号</th>
						<th>姓名</th>
					</tr>
					<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
  			${page.pagedView}
  		</form>
  </body>
</html>
