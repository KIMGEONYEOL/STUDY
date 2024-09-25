/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-25 09:14:16 UTC
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
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>4. 서버로 전송값 있고, 결과로 json 배열 받아서 출력</h2>\r\n");
      out.write("<label>검색 제목 키워드 입력 : <input type=\"search\" id=\"keyword\"></label> <br>\r\n");
      out.write("<div id=\"d4\" style=\"width:400px;height:400px;border:1px solid red;\">\r\n");
      out.write("	<table id=\"tblist\" border=\"1\" cellspacing=\"0\">\r\n");
      out.write("		<tr bgcolor=\"gray\">\r\n");
      out.write("			<th>번호</th>\r\n");
      out.write("			<th>제목</th>\r\n");
      out.write("			<th>작성자</th>\r\n");
      out.write("			<th>날짜</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</div>\r\n");
      out.write("<button id=\"test4\">테스트4</button>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	// jQuery('selector').method(...);	줄여서 $('태그선택자').이벤트메소드(function(){ 이벤트 발생시 실행할 내용});\r\n");
      out.write("	$('#test4').on('click', function(){\r\n");
      out.write("		// jQuery.ajax({ settings });\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'test4.do',\r\n");
      out.write("			type: 'post',\r\n");
      out.write("			data: { keyword: $('#keyword').val()}, //$('#keyword').val() == document.getElementById('keyword').value\r\n");
      out.write("			success: function(data){\r\n");
      out.write("				// json 배열을 담은 객체를 리턴받은 경우임\r\n");
      out.write("				console.log('data : ' + data); // data: [object, Object]\r\n");
      out.write("				\r\n");
      out.write("				// object => string\r\n");
      out.write("				var objStr = JSON.stringify(data);\r\n");
      out.write("				// string => json : parsing\r\n");
      out.write("				var jsonObj = JSON.parse(objStr);\r\n");
      out.write("				\r\n");
      out.write("				var output = $('#tblist').html();\r\n");
      out.write("				// var output = document.getElementById('tblist').innerHTML;\r\n");
      out.write("				// jksonObj 안의 list 가 가진 json 객체 정보를 하나씩 꺼내서 새로운 행을 추가해 나감\r\n");
      out.write("				for(var i in jsonObj.list){\r\n");
      out.write("					 output += '<tr><td>' + jsonObj.list[i].noticeno\r\n");
      out.write("					 + '</td><td>' + decodeURLComponet(jsonObj.list[i].noticetitle).replace(/\\+/gi, ' ')\r\n");
      out.write("					 + '</td><td>' + jsonObj.list[i].noticewriter\r\n");
      out.write("					 + '</td><td>' + jsonObj.list[i].noticedate\r\n");
      out.write("					 + '</td></tr>';\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				// 테이블에 기록 처리\r\n");
      out.write("				$('#tblist').html(output);\r\n");
      out.write("				// document.getElementById('tblist').innerHTML = output;\r\n");
      out.write("				\r\n");
      out.write("			},\r\n");
      out.write("			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("				console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("				+ \"\\nError : \" + errorData );\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>5. 서버로 json 객체를 보내기</h2>\r\n");
      out.write("<div>\r\n");
      out.write("	<fieldset>\r\n");
      out.write("	<legend>새 공지글 등록하세요.</legend>\r\n");
      out.write("	제목 : <input type=\"text\" id=\"title\"> <br>\r\n");
      out.write("	작성자 : <input type=\"text\" id=\"writer\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope.loginUser.userId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly><br>\r\n");
      out.write("	내용 : <textarea rows=\"5\" cols=\"50\" id=\"content\"></textarea><br>\r\n");
      out.write("	</fieldset>\r\n");
      out.write("</div>\r\n");
      out.write("<button id=\"test5\">테스트5</button>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	$('#test5').on('click', function(){\r\n");
      out.write("		// 자바스크립트에서 json 객체 만들기\r\n");
      out.write("		// var job = { name: '홍길동', age: 30 }; 형식으로 만들 수 있음\r\n");
      out.write("		var job = new Object();\r\n");
      out.write("		job.title = $('#title').val();\r\n");
      out.write("		job.writer = $('#writer').val(); // document.getElementById('writer').value\r\n");
      out.write("		job.content = $('#content').val();\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'test5.do',\r\n");
      out.write("			type: 'post',\r\n");
      out.write("			data: JSON.stringify(job),\r\n");
      out.write("			contentType: 'application/json; charset=utf-8',\r\n");
      out.write("			success: function(data){\r\n");
      out.write("				alert('요청 성공 : ' + data);\r\n");
      out.write("				\r\n");
      out.write("				// input 에 기록된 값 삭제함\r\n");
      out.write("				$('#title').val('');\r\n");
      out.write("				$('#content').val('');\r\n");
      out.write("			},			\r\n");
      out.write("			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("				console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("				+ \"\\nError : \" + errorData );\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("		}); // ajax\r\n");
      out.write("		\r\n");
      out.write("	}); // on\r\n");
      out.write("}); // document.ready\r\n");
      out.write("</script>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>6. 서버로 json. 배열 보내기</h2>\r\n");
      out.write("<div>\r\n");
      out.write("	<fieldset>\r\n");
      out.write("	<legend>공지글 여러 개 한번에 등록하기</legend>\r\n");
      out.write("	제목 : <input type=\"tesx\" id=\"ntitle\"> <br>\r\n");
      out.write("	작성자 : <input type=\"text\" id=\"nwriter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope.loginUser.userId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"><br>\r\n");
      out.write("	내용 : <textarea rows=\"5\" cols=\"50\" id=\"ncontent\"></textarea>\r\n");
      out.write("	</fieldset>\r\n");
      out.write("	<input type=\"button\" id=\"addBtn\" value=\"추가하기\">\r\n");
      out.write("</div>\r\n");
      out.write("<p id=\"p6\" style=\"width:400px;height:150px;border:1px solid red;\"></p>\r\n");
      out.write("<button id=\"test6\">테스트6</button>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("	// 자바스크립트에서 배열 만들기\r\n");
      out.write("	// var jarr = new Array(배열크기); // index 이용할 수 있음\r\n");
      out.write("	// jarr[0] = { name : '홍길동', age : 30}; 저장 기록함\r\n");
      out.write("	\r\n");
      out.write("	// var jarr2 = new Array(); // index 없음, 스택(stack) 구조가 됨(LIFO : Last Input First Output)\r\n");
      out.write("	// 저장 : push(). 꺼내기 : pop() 사용함\r\n");
      out.write("	// jarr2.push({ name: '홍길동', age: 40 });\r\n");
      out.write("	\r\n");
      out.write("	// 배열 초기화\r\n");
      out.write("	/*\r\n");
      out.write("		var jarr3 = [\r\n");
      out.write("					{name : '홍길동', age : 30}, \r\n");
      out.write("					{name: '홍박사', age: 40}, \r\n");
      out.write("					{name: '홍대리', age: 23}, ...];\r\n");
      out.write("	*/\r\n");
      out.write("	var jarr = new Array();\r\n");
      out.write("	var pStr = $('#p6').html();\r\n");
      out.write("	\r\n");
      out.write("	// 추가하기 버튼 클릭시 입력값들을 읽어서 json 객체를 만들고\r\n");
      out.write("	// p6 태그 영역에 json string 으로 추가 기록 처리함\r\n");
      out.write("	$('#addBtn').on('click', function(){\r\n");
      out.write("		// json 객체 만들기\r\n");
      out.write("		var job = new Object();\r\n");
      out.write("		job.title = $('#ntitle').val();\r\n");
      out.write("		job.writer = $('#nwriter').val(); // document.getElementById('writer').value\r\n");
      out.write("		job.content = $('#ncontent').val();\r\n");
      out.write("		\r\n");
      out.write("		jarr.push(job);\r\n");
      out.write("		\r\n");
      out.write("		pStr += JSON.stringify(job);\r\n");
      out.write("		$('#p6').html(pStr + '<br>');\r\n");
      out.write("		\r\n");
      out.write("		// 기존에 기록된 input 의 값은 지우기\r\n");
      out.write("		$('#ntitle').val('');\r\n");
      out.write("		$('#ncontent').val('');\r\n");
      out.write("	}); // addBtn click\r\n");
      out.write("	\r\n");
      out.write("	$('#test6').on('click', function(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'test6.do',\r\n");
      out.write("			type: 'post',\r\n");
      out.write("			data: JSON.stringify(jarr),\r\n");
      out.write("			contentType: \"application/json;\",\r\n");
      out.write("			success: function(data){\r\n");
      out.write("				alert('요청 성공 :' + data)\r\n");
      out.write("			},\r\n");
      out.write("			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("				console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("				+ \"\\nError : \" + errorData );\r\n");
      out.write("			}\r\n");
      out.write("		}); // ajax\r\n");
      out.write("	}); // test6 click\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("}); // document.ready\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<h2>7. ajax 로 파일 업로드 처리 (form 을 전송)</h2>\r\n");
      out.write("<h3>jQuery 기반 ajax 파일업로드 form 전송</h3>\r\n");
      out.write("<form id=\"fileform\">\r\n");
      out.write("	메세지 : <input type=\"text\" name=\"message\"> <br>\r\n");
      out.write("	첨부파일 : <input type=\"file\" name=\"upfile\"> <br>\r\n");
      out.write("	<input type=\"button\" value=\"업로드\" onclick=\"uploadFile();\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<h3>javascript 기반 ajax 파일업로드 form 전송</h3>\r\n");
      out.write("<form id=\"fileform2\">\r\n");
      out.write("	메세지 : <input type=\"text\" name=\"message\"> <br>\r\n");
      out.write("	첨부파일 : <input type=\"file\" name=\"upfile\"> <br>\r\n");
      out.write("	<input type=\"button\" value=\"업로드\" onclick=\"uploadFile2();\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function uploadFile(){\r\n");
      out.write("	// jQuery ajax() 로 파일업로드용 form 전송 처리\r\n");
      out.write("	\r\n");
      out.write("	// body 의 form 태그를 객체로 생성함\r\n");
      out.write("	var form = $('#fileform')[0]; // 인덱스 사용에 주의할 것\r\n");
      out.write("	// form 태그 안의 입력양식들의 값들을 담을 FormData 객체 생성함\r\n");
      out.write("	var formData = new FormData(form);\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url: 'testFileUp.do',\r\n");
      out.write("		processData: false, // multipart 전송은 false 로 지정해야 함\r\n");
      out.write("		contentType: false, // multipart 전송은 false 로 지정해야 함\r\n");
      out.write("		type: 'post',\r\n");
      out.write("		data: formData,\r\n");
      out.write("		success: function(data){\r\n");
      out.write("			alert('파일업로드 성공 : ' + data);\r\n");
      out.write("		},\r\n");
      out.write("		error: function(request, status, errorData){ // 	요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("			console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("			+ \"\\nError : \" + errorData );\r\n");
      out.write("		}\r\n");
      out.write("	}); // ajax\r\n");
      out.write("} // upoloadFile()\r\n");
      out.write("\r\n");
      out.write("function uploadFile2(){\r\n");
      out.write("	// javascript 로 ajax 기술 사용해서 파일업로드용 form 전송 처리\r\n");
      out.write("	var form = document.getElementById('fileform2');\r\n");
      out.write("	var formData = new FormData(form);\r\n");
      out.write("	\r\n");
      out.write("	// 브라우저에서 제공하는 ajax 를 위한 객체 생성\r\n");
      out.write("	var xhRequest;\r\n");
      out.write("	if(window.XMLHttpRequest){\r\n");
      out.write("		xhRequest = new XMLHttpRequest();\r\n");
      out.write("	}else{\r\n");
      out.write("		xhRequest = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// ajax 요청\r\n");
      out.write("	// 1. 요청 처리에 대한 상태코드가 변경되면, 작동할 내용을 미리 설정함\r\n");
      out.write("	xhRequest.onreadystatechange = function(){\r\n");
      out.write("		if(xhRequest.readyState == 4 && xhRequest.status == 200){\r\n");
      out.write("			// 요청이 성공하면 alert 창에 응답온 문자를 출력함\r\n");
      out.write("			alert(xhRequest.responseText);\r\n");
      out.write("		}\r\n");
      out.write("	};\r\n");
      out.write("	\r\n");
      out.write("	// 2. url 요청하고 전송데이터 보내기함\r\n");
      out.write("	xhRequest.open(\"POST\", \"testFileUp.do\", true);\r\n");
      out.write("	xhRequest.send(formData);\r\n");
      out.write("	\r\n");
      out.write("}// uploadFile2()\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<h2>8. ajax 로 파일 다운로드</h2>\r\n");
      out.write("<h3>jQuery 기반 ajax 이용 파일 다운로드</h3>\r\n");
      out.write("<a id=\"fdown\" onclick=\"fileDown();\">sample.txt</a> <br><br>\r\n");
      out.write("\r\n");
      out.write("<h3>javascript 기반 ajax 이용 파일 다운로드</h3>\r\n");
      out.write("<a id=\"fdown2\" onclick=\"fileDown2();\">sample.txt</a> <br><br>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function fileDown(){\r\n");
      out.write("	// jQuery ajax 사용 파일 다운로드 처리\r\n");
      out.write("	// a 태그로 링크된 파일이름 클릭하면, 서버로 다운로드 요청함\r\n");
      out.write("	\r\n");
      out.write("	// a 태그에서 다운받을 파일명을 얻어옴\r\n");
      out.write("	var filename = $('#fdown').text();\r\n");
      out.write("	console.log('filename :' + filename);\r\n");
      out.write("	\r\n");
      out.write("	$.ajax({\r\n");
      out.write("		url: 'filedown.do',\r\n");
      out.write("		type: 'get', // get 이 기본값이므로 생략 가능\\\r\n");
      out.write("		data: { 'filename': filename },\r\n");
      out.write("		xhrFields: { responseType: 'blob'}, // response 데이터를 바이너리(blob)로 지정해야 함.\r\n");
      out.write("		success: function(data){\r\n");
      out.write("			console.log('파일 다운로드 요청 성공!');\r\n");
      out.write("			\r\n");
      out.write("			// 응답온 파일 데이터를 Blob 객체로 만듦\r\n");
      out.write("			var blob = new Blob([data]);\r\n");
      out.write("			\r\n");
      out.write("			// 클라이언트 쪽에 파일을 저장 처리 : 다운로드\r\n");
      out.write("			if(navigator.msSaveBlob){\r\n");
      out.write("				return navigator.msSaveBlob(blob, filename);\r\n");
      out.write("			}else{\r\n");
      out.write("				var link = document.createElement('a');\r\n");
      out.write("				link.href = window.URL.createObjectURL(blob);\r\n");
      out.write("				link.download = filename;\r\n");
      out.write("				link.click();\r\n");
      out.write("			}\r\n");
      out.write("		},\r\n");
      out.write("		error: function(request, status, errorData){ // 	요청이 실패했을 때 실행되는 함수임\r\n");
      out.write("			console.log(\"error code : \" + request.status + \"\\nMessage : \" + request.responseText\r\n");
      out.write("			+ \"\\nError : \" + errorData );\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function fileDown2(){\r\n");
      out.write("	// javascript ajax 로 파일 다운로드 처리\r\n");
      out.write("	// a 태그(다운받을 파일명) 클릭하면 서버로 다운로드 요청함\r\n");
      out.write("	\r\n");
      out.write("	var filename = document.getElementById('fdown2').innerHTML;\r\n");
      out.write("	var filedownURL = \"filedown.do\";\r\n");
      out.write("	\r\n");
      out.write("	// 브라우저에 ajax 처리용 객체가 제공된다면\r\n");
      out.write("	if(window.XMLHttpRequest || 'ActiveXObject' in window){\r\n");
      out.write("		var link = document.createElement('a');\r\n");
      out.write("		link.href = filedownURL + \"?filename=\" + filename;\r\n");
      out.write("		link.download = filename || filedownURL;\r\n");
      out.write("		link.click();\r\n");
      out.write("	}else{\r\n");
      out.write("		// 브라우저에 ajax 처리용 객체가 제공되지 않는다면 \r\n");
      out.write("		var _window = window.open(filedownURL, filename);\r\n");
      out.write("		_window.document.close();\r\n");
      out.write("		_window.document.execCommand('SaveAs', true, filename || filedownURL);\r\n");
      out.write("		_window.close();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\r\n");
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