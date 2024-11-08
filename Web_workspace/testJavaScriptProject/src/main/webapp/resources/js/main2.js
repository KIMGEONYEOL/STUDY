/**
 * main2.js
 * 2024-09-03
 */

function showAlert(){
	window.alert('메세지만 출력되는 알림창입니다.');
}

function showConfirm(){
	var returnValue = window.confirm('찬성하면 확인, 반대하면 취소를 누르시오.');
	document.getElementById('result').innerHTML = '리턴값 확인 : ' + returnValue;
}

function showPrompt(){
	var inputValue = window.prompt('주소를 입력하세요.');
	document.getElementById('result').innerHTML = '입력된 주소 : ' + inputValue;
}

function inputValue(){
	var userName = document.getElementById('username').value;
	alert('입력된 이름 : ' + userName);
	
}

function calculator2(op){
	var n1 = Number(document.getElementById('n1').value);
	var n2 = Number(document.getElementById('n2').value);
	// input 태그의 기록된 값(value) 은 string 임, "12"
	// "12" 를 숫자형으로 바꾸려면 (파싱, parsing) Number() 함수 또는 parselnt(), parseDouble() 함수  사용함
	
	var result;
	
	switch(op){
		case '+': result = n1 + n2;		break;
		case '-': result = n1 - n2;		break;
		case '*': result = n1 * n2;		break;
		case '/': result = n1 / n2;		break;
		case '%': result = n1 % n2;		break;
	}
	
	document.getElementById('calc').innerHTML = n1 + ' ' + op + ' ' + n2 + ' = ' + result;	
	
}

function equalCheck(){
	alert('== 연산자 : ' + ('' == false) + ', ' + ('' == 0) + ', ' + (0 == false) + ', ' + ('273' == 273) + '\n'
		+ '=== 연산자 : ' + ('' === false) + ', ' + ('' === 0) + ', ' + (0 === false) + ', ' + ('273' === 273) + '\n'
	);
}



function switchCheck(){
	var today = new Date();
	var currentHour = today.getHours();
	console.log('시간 : ' + currentHour);
	
	switch(true){ //case 에 조건식을 사용시, switch() 안에는 true 라고 지정함
		case currentHour == 9: alert('업무시작 시간입니다.'); break;
		case currentHour < 11: alert('오전 휴식시간 가지세요.'); break;
		case currentHour < 15: alert('오후 휴식시간 가지세요.'); break;
		case currentHour == 18: alert('퇴근하세요.'); break;
		default: alter('일할 시간!'); break;
	}
}

function logicCheck(){
	var value = Number(prompt('숫자를 입력하세요.'));
	
	// 짧은 조건문 : || 는 조건이 거짓이면 뒤를 실행함, && 는 조건식이 참이면 뒤를 실행함
	value % 2 == 0 || alter('홀수입니다');
	value % 2 == 0 && alter('짝수입니다');
}








