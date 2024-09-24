<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jsp 의 core 태그라이브러리 사용하려면, 아래의 구문을 선언해야함. --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testCore</title>
</head>
<body>
<h1>JSTL : JSP Standard Tag Library 테스트 페이지</h1>
<h2>jstl core library test</h2>
<hr>

<h4>c:set 태그 : 변수 만들기</h4>>
<c:set var="num1" value="100" />
<c:set var="num2" value="200" />
num1 변수 값 : ${ num1 } <br>
num2 변수 값 : ${ num2 } <br>
<c:set var="sum" value="${ num1 + num2 }" scope="session" />
sum 변수 값 : ${ sum } <br>
<%
	int v1 = 111, v2  = 222;
%>
<c:set var="tot" value="<%= v1 + v2 %>" />
tot 변수 값 : ${ tot }<br>
<hr>

<h4>c:set 태그 : 배열 만들기</h4>
<c:set var="array" scope="request" >
		red, green, blue, yellow, pink, magenta
</c:set>
array 배열 값 : ${ array } <br>

<h4>c:remove 태그 : 변수 삭제하기</h4>
<c:remove var="sum" scope="session" />
제거한 sum 변수 값 확인 : ${ sum }<br>
<hr>

<h4>c:out 태그 : 출력하기</h4>
출력값 그대로 출력 : <c:out  value="<h2>태그로 출력하기</h2>" escapeXml="true"/> <br> 
태그 해석해서 출력 : <c:out  value="<h2>태그로 출력하기</h2>" escapeXml="false"/> <br> 
전송온 값 출력 : <c:out value="${ param.name }" default="손님"/>
<%-- el 매개변수 : param.name == request.getParameter("name") --%>
<hr>
<h4>c:if 태그 : if 문과 같음</h4>
<c:if test="${ num1 < num2 }">num2가 크다.</c:if>
<c:if test="${ num1 >= num2 }">num1이 크거나 같다.</c:if>
<br>
<c:if test="${ num1 lt num2 }">num2가 크다.</c:if>
<c:if test="${ num1 ge num2 }">num1이 크거나 같다.</c:if>
<hr>

<h4>c:choose 태그 : switch 문과 같음</h4>
<c:set var="no" value="3"/>
<c:choose>
	<c:when test="${ no eq 1 }">반갑습니다.<br></c:when>
	<c:when test="${ no eq 2 }">안녕하세요.<br></c:when>
	 <c:when test="${ no eq 3 }">환영합니다.<br></c:when>
	<c:otherwise>어서오세요.  </c:otherwise>
</c:choose>
<hr>
<h4>c:forEach 태그 : for 문 또는 for each 문과 같음</h4>
<c:forEach begin="1" end="10">
반복확인<br>
</c:forEach>
<hr>
<c:forEach var="cnt" begin="1" end="10" step="2"></c:forEach>
<hr>
<c:forEach var="size" begin="1" end="7">
		<font size="${ size }">글자크기 ${ size }</font> <br>
</c:forEach>
<hr>
<c:forEach items="${ array }" var="color">
		<font color="${color }">글자색 적용 : ${color }</font>
</c:forEach>
<hr>
<%
	java.util.ArrayList<String> bookList = new java.util.ArrayList<String>();
	bookList.add("java"); 
	bookList.add("oracle"); 
	bookList.add("jdbc"); 
	bookList.add("html5"); 
	bookList.add("css3"); 
	bookList.add("javascript"); 
	bookList.add("jquery"); 
	bookList.add("servlet"); 
	bookList.add("jsp"); 
	bookList.add("spring"); 
	bookList.add("mybatis"); 
	bookList.add("el & jstl"); 
	bookList.add("ajax"); 
%>
<c:forEach items="<%= bookList %>" var="book" varStatus="status">
${status.count } : ${book } <br>
</c:forEach>
<hr>
<ul>
<h4>c:forTokens 태그 : java.util.StringTokenizer 클래스와 같은 기능을 수행함</h4>
java.lang.String 의 split() 메소드와도 같은 기능임<br>
<c:forTokens items="yellow,pink,blue,green,red" delims="," var="clr">
		<li>${clr }</li>
</c:forTokens>
</ul>
<hr>
<c:forTokens items="core/fmt*sql xml-functions" delims="/* -" var="lib">
		${lib }<br>
</c:forTokens>
<br>
<hr>

<h4>c:url 태그 : 다른 jsp 페이지를 연결하거나, 서버로 요청 url 을 간단하게 처리할 때 사용</h4>
<%-- spring 웹 에플리케이션에서는 직접 jsp 에서 jsp 로 페이지 이동 못 함 
	반드시 서버 컨트롤러를 거쳐서 뷰리졸버로 리턴된 뷰파일명으로 페이지가 출력되어야 함	
--%>
<!-- <a href="/testjstl/WEB-INF/views/test/testFmt.jsp?no=123&name=김박사&page=1" >testFmt 로 이동</a><br> -->
<a href="moveFmt.do?no=${num1 }&name=김박사&page=${num2 }">testFmt 로 이동</a><br>
<%-- 위의 url 요청과 전송 파라메타를 별도로 다루기 위해 c:url 태그 사용할 수 있음 --%>
<c:url var="movef" value="moveFmt.do">
	<c:param name="no" value="${num1 }"/>
	<c:param name="name" value="박대리"/>
	<c:param name="page" value="${num2 }"/>
</c:url>
<a href="${movef }">testFmt 로 이동 : c:url 사용</a> <br>
<hr>

<h4>c:import 태그 : 별도로 작성된 jsp 파일을 포함시킬 때 사용</h4>
jsp 지시자 태그의 include 와 같음 <br>
<c:import url="../common/footer.jsp"></c:import>
<hr>

<h4>c:catch 태그 : try catch 문과 같음</h4>
<c:catch var="e">
	<c:set var="num" value="null" />
	<c:set var="num3" value="77" /> 
	나누기 결과 : ${num3 div num } <br> 
</c:catch>
<c:if test="${ not empty e }"> <%--e !== null 과 같음. 예외가 발생했다면  --%>
에러 메세지 : ${e.message }<br>
</c:if>
<hr>

<h4>c:redirect 태그 : response.sendRedirect("내보낼뷰 또는 연결할 요청 urrl") 와 같음</h4>
<c:set var="testr" value="0"/>
<c:if test="${test eq 1 }">
	<c:redirect url="testfmt.do"/>
</c:if>
	
	






<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>





