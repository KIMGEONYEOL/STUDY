<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
 	table th { background-color: #9ff, }
 	table#outer { border: 2px solid navy; }
</style>

<script type="text/javascript">
	function dupIdCheck(){
		// 입력한 사용자 id 가 사용 가능한지 확인하는 함수 : ajax 기술 사용해야 함
		
		return false; // 버튼 클릭이벤트 취소 (submit 버튼에 클릭이벤트 전달을 막기 위함)
	}
</script>

</head>
<body>
<h1 align="center">회원가입 페이지</h1>
</body>
<br>
<form action="enroll.do" method="post">
<table id="outer" align="center" width="700" cellspacing="5" cellpadding="0">
	<tr><th colspan="2">회원 정보를 입력해주세요.(* 표시는 필수입력 항목입니다.)</th></tr>
		<tr><th width="120">*아이디</th><td>
				<input type="text" name="userId" id="userId" required>
				<input type="button" value="중복체크" onclick="return dupleCheck();">
		</td></tr>
	<tr><th>*암	호</th><td><input type="password" name="userPwd" id="userPwd" required></td></tr>
	<tr><th>*암호 확인</th><td><input type="password" id="userPwd2" required></td></tr>
	<tr><th>*이	름</th><td><input type="text" name="userName" id="userName" required></td></tr>
	<tr><th>*성	별</th>
		<td>
			<input type="radio" name="gender" value="M" > 남자 &nbsp;
			<input type="radio" name="gender" value="F" > 여자 &nbsp;
		</td>
	</tr>
	<tr><th>*나	이</th><td><input type="number" name="age" min="19" value="20" required></td></tr>
	<tr><th>*전화번호</th><td><input type="tel" name="phone" required></td></tr>
	<tr><th>*이메일</th><td><input type="email" name="email" required></td></tr
	>	<tr><th colspan="2">
			<input type="submit" value="가입하기"> &nbsp;
			<input type="reset" value="작성취소"> &nbsp;
			<a href="main.do">Home</a>
	</th>	
	</tr>
</table>
</form>



</html>