<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAjaxView.jsp</title>
<%-- jsp 에서 el 사용시 절대경로를 표시하는 /first 를 
	 ${ pageContext.servletContext.contextPath } 로 표기함
	 톰캣이 구동하고 있는 에플리케이션의 context-root 를 조회해 오라는 의미
 --%>
<script type="text/javascript" src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<h1>jQuery 로 ajax 스프링 적용 테스트</h1>
<hr>

<h2>1. 서버로 전송하는 값은 없고, 결과로 문자열을 받아서 출력 : get 방식</h2>
<p id="p1" style="width:300px;height:50px;border:1px solid red;"></p>
<button id="test1">테스트1</button>

<script type="text/javascript">
// window.onload = function(){ 태극객체.이벤트명 = function(){ 이벤트 발생시 처리내용 작성}};
// JQuery.document.ready(function(){ 태극객체.이벤트명 = function(){ 이벤트 발생시 처리내용 작성}});
// window.onload 와 jQuery.document.ready 는 의미가 같음 : 브라우저에 문서 읽어들이기가 완려되면을 의미함
// jQuery 는 줄임말로 $ 로 표기함
// jQuery.documnet.ready(function); 는 줄여서 $(funtion); 표기해도 됨
$(function(){
	//jQuery('선택자').메소드명([전달인자, ...]);
	// $('selecteor').method(...).method(...).method(...); //chainning 기법
	
	// 아이디가 test1 인 태그가 클릭되면 콜백함수가 실행되는 구문임
	$('#test1').click(function(){
		$.ajax({
			url: 'test1.do',
			type: 'get', // 생략 가능
			success: function(data){ // 요청이 성공했을 때 실행되는 함수임
				// 서버측에서 보낸 문자열 값 출력 처리
				$('#p1').html($('#p1').text() + '<br>' + data );
			},
			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임
				console.log("error code : " + request.status + "\nMessage : " + request.responseText
						+ "\nError : " + errorData );
			}			
		});
	});
});
</script>

<hr>

<h2>2. 서버로 전송하는 값 있고, 결과로 문자열을 받아서 출력 : post 방식 </h2>
이름 : <input type="text" id="name"> <br> 
나이 :<input type="number" id="age"> <br>

<p id="p2" style="width:300px;height:50px;border:1px solid red;"></p>
<button id="test2">테스트2</button>

<script type="text/javascript">
$(function(){
	$('#test2').click(function(){
		$.ajax({
			url: 'test2.do',
			type: 'post',
			data: { name: $('#name').val(),
					age: $('#age').val() },
			//,dataType: 'text', //'text' 는 기본값이므로 생략 가능함
			success: function(data){
				// p 태그 영역 안에 문자열 추가
				// $('#p2').html($('#p2').text() + '<br>' + data );
				// 반환값에 따라 선택 적용한다면
				if(data == 'ok'){
					$('#p2').html('<h5>' + data + '</h5>');
				}else{
					alert('서버측 답변 : ' + data);
				}
			},
			
			error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임
				console.log("error code : " + request.status + "\nMessage : " + request.responseText
				+ "\nError : " + errorData );
			}
		});
	});
});
</script>
<hr>

<h2>3. 서버로 전송하는 값은 없고, 결과로 json 객체 하나를 받아서 출력 : post </h2>
<p id="p3" style="width:300px;height:150px;border:1px solid red;"></p>
<button id="test3">테스트3</button>

<script type="text/javascript">
	$(function(){
		$('#test3').click(function(){
			$.ajax({
				url: 'test3.do',
				type: 'post',
				dataType: 'json',  // json 을 받을 때에는 type 을 post 방식으로 지정해야 함
				success: function(data){
					// json 객체 한 개를 받을 때에는 바로 출력할 수 있음
					console.log('json data : ' + data); // json data : [object Object]
					
					// 응답온 값에 인코딩된 문자가 있으면, 자바스크립트가 제공하는 내장함수
					// decodeURIComponet(응답값) 사용해서 반드시 디코딩 처리해야 함
					// 디코딩 결과에 공백문자가 '+' 로 표기되면
					// replace('현재문자', '바꿀문자') 사용해서 '+' 를 공백문자로 변경 처리함
					$('#p3').html('<b>최신 신규 공지글</b><br>'
							+ '번호 : ' + data.noticeno
							+ '<br>제목 : ' + decodeURIComponent(data.noticetitle).replace(/\+/gi, ' ')
							+ '<br>작성자 : ' + data.noticewriter
							+ '<br>날짜 : ' + data.noticedate
							+ '<br>내용 : ' + decodeURIComponent(data.noticecontent).replace(/\+/gi, ' '));
					
					
					
				},
				error: function(request, status, errorData){ // 요청이 실패했을 때 실행되는 함수임
					console.log("error code : " + request.status + "\nMessage : " + request.responseText
					+ "\nError : " + errorData );
				}
			});
		}); 
	});
</script>



</body>
</html>







