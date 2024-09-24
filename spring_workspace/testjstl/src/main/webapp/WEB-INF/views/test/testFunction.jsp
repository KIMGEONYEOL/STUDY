<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testFunctions</title>
</head>
<body>
<h1>jstl functions library test page</h1>
<h2>문자열 관련 함수 태그임 : el 안에서 사용하거나, value 속성에 처리된 결과를 대입함 </h2>
java.lang.String 클래스의 메소드를 태그로 만들어서 제공하는 라이브러리임<br>
<c:set var="str" value="How are you" />
str :${str } <br>
모두 대문자로 : ${ fn:toUpperCase(str) }<br>
모두 소문자로 : ${ fn:toLowerCase(str) }<br>
are 의 위치는 : ${ fn:indexOf(str, "are" ) }<br>
are 를 ware 로 변경 : ${ fn:replace(str, "are", "ware") } <br>
문자열 길이(글자갯수) : ${ fn:length(str) } <br>
are 분리 추출 : ${ fn:substring(str, 4, 7) } <br>


</body>
</html>