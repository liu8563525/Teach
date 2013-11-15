<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/public.css" type=text/css rel=stylesheet>
	<link href="css/login.css" type=text/css rel=stylesheet>

	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<!-- Begin user defined js -->
    <script type="text/javascript" src="js/login.js"></script>
    <!-- End user defined js -->
</head>
<body>
<h2>Teach Hello World!</h2>
	<a href="freeMarker/hello">say hello</a> 
	<a href="freeMarker/hello2">say hello2</a> 
	<a href="freeMarker/hi">say hi</a><br/>
	<a href="freeMarker/jsp">jspRequest</a>
	<a href="paging/">freemarker前台分页</a><br>
	<a href="myPage/1">userPage</a>
	<a href="cntUserPage/1">cntUserPage</a><br>
	<a href="login/">登录</a>
<DIV id=div1>
  <form id="loginForm" name="loginForm" action="login/login.spr" method="post" >
  <TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800 
	align=center>
    <TBODY>
      <TR id=main>
        <TD>
          <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
            <TBODY>
              <TR>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD width=380>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD rowSpan=4>&nbsp;</TD>
                <TD>用户名：</TD>
                <TD>
                  <INPUT class=textbox id=txtUserName name=username>
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD>密　码：</TD>
                <TD>
                  <INPUT class=textbox id=txtUserPassword type=password 
            name=password>
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <%--<TR height=40>
                <TD vAlign=middle>验证码：</TD>
                <TD vAlign=middle colSpan=2>
                  <INPUT id=txtSN size=4 name=txtSN>
                  &nbsp; <IMG src="loginFiles/default.gif" border=0> <A id=LinkButton1 
            	  href="#">不清楚，再来一张</A></TD>
              </TR>
              --%>
              <tr height=40>
              	<td colspan="3">
              		<input type="radio" id="type" name="type" value="stu" checked>学生
              		<input type="radio" id="type" name="type" value="tea" >老师
              		<input type="radio" id="type" name="type" value="admin">管理员
              	</td>
              </tr>
              <TR height=40>
                <TD align=left colspan="2">
                  <INPUT id=btnLogin type=button class="button" value=" 登 录 " name=btnLogin onclick="login()">
                  <INPUT id=btnReset type=reset  class="button" value=" 重 置 " name=btnReset>
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=110>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
            </TBODY>
          </TABLE>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </TABLE>
  </form>
</DIV>
<DIV id=div2 style="DISPLAY: none"></DIV>
</body>
</html>
