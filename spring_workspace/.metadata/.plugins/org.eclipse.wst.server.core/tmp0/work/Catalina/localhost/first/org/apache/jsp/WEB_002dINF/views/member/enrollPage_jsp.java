/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-13 07:09:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enrollPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(" 	table th { background-color: #9ff, }\r\n");
      out.write(" 	table#outer { border: 2px solid navy; }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function dupIdCheck(){\r\n");
      out.write("		// 입력한 사용자 id 가 사용 가능한지 확인하는 함수 : ajax 기술 사용해야 함\r\n");
      out.write("		\r\n");
      out.write("		return false; // 버튼 클릭이벤트 취소 (submit 버튼에 클릭이벤트 전달을 막기 위함)\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1 align=\"center\">회원가입 페이지</h1>\r\n");
      out.write("</body>\r\n");
      out.write("<br>\r\n");
      out.write("<form action=\"enroll.do\" method=\"post\">\r\n");
      out.write("<table id=\"outer\" align=\"center\" width=\"700\" cellspacing=\"5\" cellpadding=\"0\">\r\n");
      out.write("	<tr><th colspan=\"2\">회원 정보를 입력해주세요.(* 표시는 필수입력 항목입니다.)</th></tr>\r\n");
      out.write("		<tr><th width=\"120\">*아이디<th/><td>\r\n");
      out.write("				<input type=\"text\", name=\"userId\" id=\"userId\" required> &nbsp;\r\n");
      out.write("				<input type=\"button\" value=\"중복체크\" onclick=\"return dupleCheck();\">\r\n");
      out.write("		</td></tr>\r\n");
      out.write("	<tr><th>*암	호</th><td><input type=\"password\" name=\"userPwd\" id=\"userPwd\" required></td></tr>1\r\n");
      out.write("	<tr><th>*암호 확인</th><td><input type=\"password\" id=\"userPwd2\" required></td></tr>\r\n");
      out.write("	<tr><th>*이	름</th><td><input type=\"text\" name=\"userName\" id=\"userName\" required></td></tr>\r\n");
      out.write("	<tr><th>*성	별</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"radio\" name=\"gender\" value=\"M\" > 남자 &nbsp;\r\n");
      out.write("			<input type=\"radio\" name=\"gender\" value=\"F\" > 여자 &nbsp;\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr><th>*나	이</th><td><input type=\"number\" name=\"age\" min=\"19\" value-\"20\" required></td></tr>\r\n");
      out.write("	<tr><th>*전화번호</th><td><input type=\"tell?\" name=\"phone\", reqiored></td></tr>\r\n");
      out.write("	<tr><th>*이메일</th><td><input type=\"email\" name=\"email\" required></td></tr\r\n");
      out.write("	>	<tr><th colspan=\"2\">\r\n");
      out.write("			<input type=\"submit\" value=\"가입하기\"> &nbsp;\r\n");
      out.write("			<input type=\"reset\" value=\"작성취소\"> &nbsp;\r\n");
      out.write("			<a href=\"main.do\">Home</a>\r\n");
      out.write("	</th>	\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
