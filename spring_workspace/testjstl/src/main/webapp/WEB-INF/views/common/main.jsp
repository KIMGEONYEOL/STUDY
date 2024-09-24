<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testjstl</title>
<style type="text/css">
div.lineA{
	height: 100px;
	border: 1px solid gray;
	float: left;
	position: relative;
	left: 120px;
	margin: 5px;
	padding: 5px;
}
div#banner {
	width: 500px;
	padding: 0;
}
div#banner img {
	width: 450px;
	height: 80px;
	padding: 0;
	margin-top: 10px;
	margin-left: 25px;
}
div#loginBox button{
	width: 250px;
	heigh: 35px;
	background-color: navy;
	color: white;
	margin-top: 10;
	margin-bottom: 15;
	font-size: 14pt;
	font-weight: bold;
	cursor: pointer; /* 손가락 모양 : 클릭 가능한 버튼으로 표시함 */
}
div#loginBox a {
	text-decoration: none;
	color: navy;
}


</style>
<script type="text/javascript">
function movePage(){
	// 자바스크립트로 페이지 연결 또는 서블릿 컨트롤러 연결 요청시에는
	// location 객체의 href 속성을 사용함
	location.href = "loginPage.do";
}

</script>
</head>
<body>
<h1>test EL & JSTL Spring Project : testjstl </h1>
<%-- 메뉴바 표시 --%>
<%@ include file="menubar.jsp"  %>
<hr> 

<header>
	<div id="banner" class="lineA">
		<img src="/testjstl/resources/images/photo2.jpg">
	</div>
	
		<div id="loginBox" class="lineA">
			first 사이트 방문을 환영합니다.<br>
			<button onclick="movePage()">first 로그인</button><br>
			<%--로그인 버튼을 클릭하면 자바스크립트 movePage() 함수가 실행되게 해서, 로그인 페이지가 나타나게 처리함 --%>
			<a href="enrollPage.do">회원가입</a>
			<%-- 회원가입 클릭하면 회원가입페이지가 연결되어 출력되겍 링크 설정했음 --%>
		</div>
	
</header>
 
<hr style="clear:both;">
<%-- jsp 파일 안에 별도로 작성된 jsp(권장), html 파일을 포함할 수 있다.
	 주의 : 상대경로만 사용할 수 있음
 --%>
 <%@ include file="footer.jsp" %>
 

</body>
</html>




















