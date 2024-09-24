/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-24 08:51:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testAjaxView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>testAjaxView.jsp</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.servletContext.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>jQuery 로 ajax 스프링 적용 테스트</h1>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>1. 서버로 전송하는 값은 없고, 결과로 문자열을 받아서 출력 : get 방식</h2>\r\n");
      out.write("<p id=\"p1\" style=\"width:300px;height:50px;border:1px solid red;\"></p>\r\n");
      out.write("<button id=\"test1\">테스트1</button>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// window.onload = function(){ 태극객체.이벤트명 = function(){ 이벤트 발생시 처리내용 작성}};\r\n");
      out.write("// JQuery.document.ready(function(){ 태극객체.이벤트명 = function(){ 이벤트 발생시 처리내용 작성}});\r\n");
      out.write("// window.onload 와 jQuery.document.ready 는 의미가 같음 : 브라우저에 문서 읽어들이기가 완려되면을 의미함\r\n");
      out.write("// jQuery 는 줄임말로 $ 로 표기함\r\n");
      out.write("// jQuery.documnet.ready(function); 는 줄여서 $(funtion); 표기해도 됨\r\n");
      out.write("$(function(){\r\n");
      out.write("	//jQuery('선택자').메소드명([전달인자, ...]);\r\n");
      out.write("	// $('selecteor').method(...).method(...).method(...); //chainning 기법\r\n");
      out.write("	\r\n");
      out.write("	// 아이디가 test1 인 태그가 클릭되면 콜백함수가 실행되는 구문임\r\n");
      out.write("	$('#test1').click(function(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'test1.do',\r\n");
      out.write("			type: 'get', // 생략 가능\r\n");
      out.write("			success: function(data){ // 요청이 성공했을 때 실행되는 함수임\r\n");
      out.write("				// 서버측에서 보낸 문자열 값 출력 처리\r\n");
      out.write("				$('#p1').html($('#p1').text() + '<br>' + data );\r\n");
      out.write("			},\r\n");
      out.write("			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("				console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("						+ \"\\nError : \" + errorData );\r\n");
      out.write("			}			\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>2. 서버로 전송하는 값 있고, 결과로 문자열을 받아서 출력 : post 방식 </h2>\r\n");
      out.write("이름 : <input type=\"text\" id=\"name\"> <br> \r\n");
      out.write("나이 :<input type=\"number\" id=\"age\"> <br>\r\n");
      out.write("\r\n");
      out.write("<p id=\"p2\" style=\"width:300px;height:50px;border:1px solid red;\"></p>\r\n");
      out.write("<button id=\"test2\">테스트2</button>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	$('#test2').click(function(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'test2.do',\r\n");
      out.write("			type: 'post',\r\n");
      out.write("			data: { name: $('#name').val(),\r\n");
      out.write("					age: $('#age').val() },\r\n");
      out.write("			//,dataType: 'text', //'text' 는 기본값이므로 생략 가능함\r\n");
      out.write("			success: function(data){\r\n");
      out.write("				// p 태그 영역 안에 문자열 추가\r\n");
      out.write("				// $('#p2').html($('#p2').text() + '<br>' + data );\r\n");
      out.write("				// 반환값에 따라 선택 적용한다면\r\n");
      out.write("				if(data == 'ok'){\r\n");
      out.write("					$('#p2').html('<h5>' + data + '</h5>');\r\n");
      out.write("				}else{\r\n");
      out.write("					alert('서버측 답변 : ' + data);\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			\r\n");
      out.write("			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("				console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("				+ \"\\nError : \" + errorData );\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>3. 서버로 전송하는 값은 없고, 결과로 json 객체 하나를 받아서 출력 : post </h2>\r\n");
      out.write("<p id=\"p3\" style=\"width:300px;height:150px;border:1px solid red;\"></p>\r\n");
      out.write("<button id=\"test3\">테스트3</button>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function(){\r\n");
      out.write("		$('#test3').click(function(){\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: 'test3.do',\r\n");
      out.write("				type: 'post',\r\n");
      out.write("				dataType: 'json',  // json 을 받을 때에는 type 을 post 방식으로 지정해야 함\r\n");
      out.write("				success: function(data){\r\n");
      out.write("					// json 객체 한 개를 받을 때에는 바로 출력할 수 있음\r\n");
      out.write("					console.log('json data : ' + data); // json data : [object Object]\r\n");
      out.write("					\r\n");
      out.write("					// 응답온 값에 인코딩된 문자가 있으면, 자바스크립트가 제공하는 내장함수\r\n");
      out.write("					// decodeURIComponet(응답값) 사용해서 반드시 디코딩 처리해야 함\r\n");
      out.write("					// 디코딩 결과에 공백문자가 '+' 로 표기되면\r\n");
      out.write("					// replace('현재문자', '바꿀문자') 사용해서 '+' 를 공백문자로 변경 처리함\r\n");
      out.write("					$('#p3').html('<b>최신 신규 공지글</b><br>'\r\n");
      out.write("							+ '번호 : ' + data.noticeno\r\n");
      out.write("							+ '<br>제목 : ' + decodeURIComponent(data.noticetitle).replace(/\\+/gi, ' ')\r\n");
      out.write("							+ '<br>작성자 : ' + data.noticewriter\r\n");
      out.write("							+ '<br>날짜 : ' + data.noticedate\r\n");
      out.write("							+ '<br>내용 : ' + decodeURIComponent(data.noticecontent).replace(/\\+/gi, ' '));\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("				},\r\n");
      out.write("				error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("					console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("					+ \"\\nError : \" + errorData );\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}); \r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
