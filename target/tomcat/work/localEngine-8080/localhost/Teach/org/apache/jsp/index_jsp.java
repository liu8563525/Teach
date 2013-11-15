package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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

      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<link href=\"css/public.css\" type=text/css rel=stylesheet>\n");
      out.write("\t<link href=\"css/login.css\" type=text/css rel=stylesheet>\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery-1.10.2.min.js\"></script>\n");
      out.write("\t<!-- Begin user defined js -->\n");
      out.write("    <script type=\"text/javascript\" src=\"js/login.js\"></script>\n");
      out.write("    <!-- End user defined js -->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h2>Teach Hello World!</h2>\n");
      out.write("\t<a href=\"freeMarker/hello\">say hello</a> \n");
      out.write("\t<a href=\"freeMarker/hello2\">say hello2</a> \n");
      out.write("\t<a href=\"freeMarker/hi\">say hi</a><br/>\n");
      out.write("\t<a href=\"freeMarker/jsp\">jspRequest</a>\n");
      out.write("\t<a href=\"paging/\">freemarker前台分页</a><br>\n");
      out.write("\t<a href=\"myPage/1\">userPage</a>\n");
      out.write("\t<a href=\"cntUserPage/1\">cntUserPage</a><br>\n");
      out.write("\t<a href=\"login/\">登录</a>\n");
      out.write("<DIV id=div1>\n");
      out.write("  <form id=\"loginForm\" name=\"loginForm\" action=\"login/login.spr\" method=\"post\" >\n");
      out.write("  <TABLE id=login height=\"100%\" cellSpacing=0 cellPadding=0 width=800 \n");
      out.write("\talign=center>\n");
      out.write("    <TBODY>\n");
      out.write("      <TR id=main>\n");
      out.write("        <TD>\n");
      out.write("          <TABLE height=\"100%\" cellSpacing=0 cellPadding=0 width=\"100%\">\n");
      out.write("            <TBODY>\n");
      out.write("              <TR>\n");
      out.write("                <TD colSpan=4>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("              <TR height=30>\n");
      out.write("                <TD width=380>&nbsp;</TD>\n");
      out.write("                <TD>&nbsp;</TD>\n");
      out.write("                <TD>&nbsp;</TD>\n");
      out.write("                <TD>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("              <TR height=40>\n");
      out.write("                <TD rowSpan=4>&nbsp;</TD>\n");
      out.write("                <TD>用户名：</TD>\n");
      out.write("                <TD>\n");
      out.write("                  <INPUT class=textbox id=txtUserName name=username>\n");
      out.write("                </TD>\n");
      out.write("                <TD width=120>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("              <TR height=40>\n");
      out.write("                <TD>密　码：</TD>\n");
      out.write("                <TD>\n");
      out.write("                  <INPUT class=textbox id=txtUserPassword type=password \n");
      out.write("            name=password>\n");
      out.write("                </TD>\n");
      out.write("                <TD width=120>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("              ");
      out.write("\n");
      out.write("              <tr height=40>\n");
      out.write("              \t<td colspan=\"3\">\n");
      out.write("              \t\t<input type=\"radio\" id=\"type\" name=\"type\" value=\"stu\" checked>学生\n");
      out.write("              \t\t<input type=\"radio\" id=\"type\" name=\"type\" value=\"tea\" >老师\n");
      out.write("              \t\t<input type=\"radio\" id=\"type\" name=\"type\" value=\"admin\">管理员\n");
      out.write("              \t</td>\n");
      out.write("              </tr>\n");
      out.write("              <TR height=40>\n");
      out.write("                <TD align=left colspan=\"2\">\n");
      out.write("                  <INPUT id=btnLogin type=button class=\"button\" value=\" 登 录 \" name=btnLogin onclick=\"login()\">\n");
      out.write("                  <INPUT id=btnReset type=reset  class=\"button\" value=\" 重 置 \" name=btnReset>\n");
      out.write("                </TD>\n");
      out.write("                <TD width=120>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("              <TR height=110>\n");
      out.write("                <TD colSpan=4>&nbsp;</TD>\n");
      out.write("              </TR>\n");
      out.write("            </TBODY>\n");
      out.write("          </TABLE>\n");
      out.write("        </TD>\n");
      out.write("      </TR>\n");
      out.write("      <TR id=root height=104>\n");
      out.write("        <TD>&nbsp;</TD>\n");
      out.write("      </TR>\n");
      out.write("    </TBODY>\n");
      out.write("  </TABLE>\n");
      out.write("  </form>\n");
      out.write("</DIV>\n");
      out.write("<DIV id=div2 style=\"DISPLAY: none\"></DIV>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
