<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- page 지시자(directive) 태그는 jsp 파일 안에서 한번만 사용해야 함 
	 이 페이지(jsp 파일)의 설정 관련 속성으로 값을 지정함
	 단, import 속성은 page 지시자 태그를 별도로 분리해서 작성할 수 있음
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style type="text/css">
nav > ul#menubar {
	list-style: none;
	position: relative;
	left: 150px;	
}
nav > ul#menubar li {
	float: left;
	width: 120px;
	height: 30px;
	margin-right: 5px;
	padding: 0;
}
nav > ul#menubar li a {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background: orange;
	color: navy;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
}
nav > ul#menubar li a:hover {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background: navy;
	color: white;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
}

hr { clear: both;}

</style>
</head>
<body>
<%-- 로그인하지 않았을 때 --%>

	<nav>
		<ul id="menubar">
			<li><a href="main.do">Home</a></li>
			<li><a href="testel.do">testEL</a></li>
			<li><a href="testcore.do">JSTL : core</a></li>
			<li><a href="testfmt.do">JSTL : fmt </a></li>
			<li><a href="testfn.do">JSTL : functions </a></li>
		</ul>
	</nav>

</body>
</html>










