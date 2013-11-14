package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;
import fire.controller.util.SessionHelper;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/top.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
request.setAttribute("path", path);

if(!request.getRequestURI().endsWith("login.jsp") && session.getAttribute(SessionHelper.UserHandler)==null){
	//如果没有登录,那么重定向到登录页面
	response.sendRedirect(basePath+"login.jsp");
}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<script type=\"text/javascript\">var basePath='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';</script>");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>登录</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{background: #E2E9E6;}\r\n");
      out.write(".login_table{border:1px solid gray;border-collapse: collapse;background:#ECFFF8}\r\n");
      out.write(".login_table th{text-align:right;border:1px solid gray;padding: 5px;}\r\n");
      out.write(".login_table td{text-align:left;border:1px solid gray;padding: 5px;}\r\n");
      out.write(".login_table input{width:140px;}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/public.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form action=\"login/login.spr\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write(" <table class=\"login_table\">\r\n");
      out.write("    <tr><th colspan=\"2\" style=\"text-align:center;\">登录</th></tr>\r\n");
      out.write("    <tr><th>登录名：</th><td><input type=\"text\" name=\"loginName\"/></td></tr>\r\n");
      out.write("    <tr><th>密码：</th><td><input type=\"password\" name=\"pswd\" /></td></tr>\r\n");
      out.write("    <tr><td colspan=\"2\" style=\"text-align:center;\">\r\n");
      out.write("    <button type=\"submit\">登录</button></td></tr>\r\n");
      out.write(" </table>\r\n");
      out.write("</form>\r\n");
      out.write("<hr>\r\n");
      out.write("<span style=\"color:red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.opmsg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.opmsg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('\r');
      out.write('\n');
 String opmsg = request.getParameter("opmsg");
if(opmsg != null){
opmsg = URLDecoder.decode(opmsg, "utf-8");
out.println(opmsg);}
      out.write("</span><br>\r\n");
      out.write("<a href=\"memo/doSomeThing_a.spr\">未登录错误提示: 传统html方式</a>\r\n");
      out.write("<br>\r\n");
      out.write("<a href=\"memo/doSomeThing_b.spr\" onclick=\"return doSomeThing(this)\">未登录错误提示: ajax方式:</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
