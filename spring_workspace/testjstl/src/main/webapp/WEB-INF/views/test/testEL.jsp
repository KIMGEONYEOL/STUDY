<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- page 지시자는 jsp 파일에 한 번만 사용함. 단, import 속성만 분리 작성할 수 있음 --%>
<%-- <%@ page import="org.ict.testjstl.member.model.dto.User" %>
<%
	User user = (User)request.getAttribute("resultUser"); // request.getAttribute("저장한 이름") : Object 리턴
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testEL</title>
</head>
<body>
<h1>EL(Expression Language : 표현 언어) 사용 테스트 페이지</h1>
<%-- 자바 변수 또는 객체의 필드(속성 : property) 값 출력 처리 --%>
<h3>1. 기본 자바 문법 사용한 경우</h3>
<%-- 아이디 : <%= user.getUserId() %> <br>
암호 : <%= user.getUserPwd() %> <br>
이름 : <%= user.getUserName() %> <br> --%>
<hr>

<h3>2. jsp 표준액션 태그 사용한 경우</h3>
<%-- request 에 저장한 이름을 id 속성의 값으로 지정해야 함 --%>
<%-- <jsp:useBean id="resultUser" class="org.ict.testjstl.member.model.dto.User" scope="request"></jsp:useBean>
아이디 : <%= resultUser.getUserId() %> <br>
암호 : <%= resultUser.getUserPwd() %> <br>
이름 : <%= resultUser.getUserName() %> <br> --%>
<hr>

<h3>3. el 을 사용한 경우</h3>
<%-- el 표기법은 ${} 사용함. ${ 저장한이름.필드명 } : 저장된객체 추출과 필드의 getter 작동됨 --%>
아이디 : ${ resultUser.userId } <br>
암 호 : ${ resultUser.userPwd } <br>
이 름 : ${ resultUser.userName } <br>

<h3>4. el 에 연산자 사용 테스트</h3>
<b><u>산술연산자 사용 가능함</u></b><br>
20 + 3 = ${ 20 + 3 }  <br>
20 - 3 = ${ 20 - 3 }  <br>
20 * 3 = ${ 20 * 3 }  <br>
20 / 3 = ${ 20 / 3 } , ${ 20 div 3 }  <br>
20 % 3 = ${ 20 % 3 } , ${ 20 mod 3 } <br>

<b><u>비교연산자 사용 가능함</u></b><br>
20 &lt; 3 = ${ 20 lt 3 }, ${ 20 < 3 } <br>
20 &gt; 3 = ${ 20 gt 3 }, ${ 20 > 3 } <br>
20 &le; 3 = ${ 20 le 3 }, ${ 20 >= 3 } <br>
20 &ge; 3 = ${ 20 ge 3 }, ${ 20 <= 3 } <br>
20 &eq; 3 = ${ 20 eq 3 }, ${ 20 == 3 } <br>
20 &ne; 3 = ${ 20 ne 3 }, ${ 20 != 3 } <br>

<b><u>논리연산자 사용 가능함</u></b><br>
(20 &lt; 3) &amp;&amp; (20 &gt; 3) = ${ (20 < 3) && (20 > 3) }, ${ (20 < 3) and (20 > 3) }<br>
(20 &lt; 3) || (20 &gt; 3) = ${ (20 < 3) || (20 > 3) }, ${ (20 < 3) or (20 > 3) }<br>

<b><u>empty (null 과 같음) 연산자 사용 가능함</u></b><br>
request 에 저장된 user 정보가 없느냐? ${ empty resultUser } <br> <%-- 자바로는 resultUser == null 과 같음 --%>
request 에 저장된 user 정보가 있느냐? ${ !empty resultUser }, ${ not empty resultUser } <br>


</body>
</html>











