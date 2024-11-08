<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
h1{
    font-size: 48pt;
    color: navy;
}
div {
    width: 500px;
    height: 200px;
    border: 2px solid navy;
    position: relative;
    left: 200px;
}
div form{
    font-size: 16pt;
    color: navy;
    font-weight: bold;
    margin: 10px;
    padding: 10px;
}
div#loginForm input.pos{
    position: absolute;
    left: 120px;
    width: 300px;
    height: 25px;
}
div#loginForm form input[type=submit]{
    margin: 10px;
    width: 250px;
    height: 40px;
    position: absolute;
    left: 120px;
    background-color: navy;
    color: white;
    font-size: 16pt;
    font-weight: bold;
}

</style>
</head>
<body>
<h1 align="center">first 로그인</h1>
<div id="loginForm">
    <!--
        action="서버측 input 값들을 전송받을 서블릿클래스의 url 매핑이름"
        웹에서는 뷰가 연결할 컨트롤러 클래스명은 주로 매핑(가리다)해서 사용
        즉, url 상에 보여질 가짜이름을 사용함
        
        경로 지정시 주의사항 :
        모든 서블릿 컨트롤러는 root 에서 실행되게 해야 함 => content directory (webapp 폴더) 가 root 임.
        action 에는 절대경로, 상대경로 둘 다 사용 가능함
        절대경로는 /context root 명에서 시작하도록 표시함
        상대경로는 현재 문서의 위치를 기준으로 대상을 지정함
        현재 이 문서(loginPage.html)는 webapp/views/member 폴더 안에 있음
        상대경로로 login 컨트롤러를 연결한다면 : action="../../login" 
        
        서블릿 기반 웹 MVC 프로젝트에서는
        	M(Model)
        	V(View) : hwp, jsp 파일
        	C(Controller) : Servlet 클래스 (java)
        
    -->
    <form action="login.do" method="post">
        <label>아이디 : <input type="text" name="userId" id="userId" class="pos"></label><br>
        <label>암  호 : <input type="password" name="userPwd" id="userPwd" class="pos"></label><br>
        <input type="submit" value="로그인">
    </form>
</div>

</body>
</html>