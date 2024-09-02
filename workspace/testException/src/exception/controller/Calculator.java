package exception.controller;

import java.util.Scanner;

import exception.silsub1.CharCheckException;
import exception.silsub1.CharacterProcess;
import make.exception.MyException;
import make.exception.NotDivideZeroException;

public class Calculator {
	public int sum(int a, int b) throws MyException {
		// 전달된 정수의 값이 반드시 1 ~ 100 사이의 값이어야 함, 아니면 예외 발생
		int result = 0;
		if((a >= 1 && a <= 100) && (b >= 1 && b<= 100)) {
			result = a + b ;
		}else {
			// 예외 발생시킴 : throw new 예외클래스생성자("에러메세지")
			throw new MyException("1부터 100 사이의 값만 연산이 가능합니다.");
		}
		return result;
	}
		
	public int sub(int a, int b) throws MyException {
		// 전달된 정수의 값이 반드시 1 ~ 100 사이의 값이어야 함, 아니면 예외 발생
		int result = 0;
		if((a >= 1 && a <= 100) && (b >= 1 && b<= 100)) {
			result = a - b ;
		}else {
			// 예외 발생시킴 : throw new 예외클래스생성자("에러메세지")
			throw new MyException("1부터 100 사이의 값만 연산이 가능합니다.");
		}
		return result;
	}

	public int mul(int a, int b) throws MyException {
		// 전달된 정수의 값이 반드시 1 ~ 100 사이의 값이어야 함, 아니면 예외 발생
		int result = 0;
		if((a >= 1 && a <= 100) && (b >= 1 && b<= 100)) {
			result = a * b ;
		}else {
			// 예외 발생시킴 : throw new 예외클래스생성자("에러메세지")
			throw new MyException("1부터 100 사이의 값만 연산이 가능합니다.");
		}
		return result;
	}

	public int div(int a, int b) throws MyException, NotDivideZeroException {
		// 나눌 수 b 가 0 이면 예외 발생시킴
		int result = 0;
		if(b == 0) {
			throw new NotDivideZeroException("0으로 나눌 수 없습니다.");
		}else {
			if((a >= 1 && a <= 100) && (b >= 1 && b<= 100)) {
			result = a / b ;
			}else {
			// 예외 발생시킴 : throw new 예외클래스생성자("에러메세지")
			throw new MyException("1부터 100 사이의 값만 연산이 가능합니다.");
		}
		return result;
		}
	}
	
	// 사용자 정의 예외 클래스 사용 테스트 ------------------------------
	public void testCalculator() {
		Calculator calc = new Calculator();
		
		try {
			System.out.println("더하기 결과 : " + calc.sum(23, 55));
			System.out.println("빼기 결과" + calc.sub(23, 55));
			System.out.println("곱하기 결과 : " + calc.mul(23, 55));
			System.out.println("나누기 결과 : " + calc.div(23, 55));
		} catch (MyException | NotDivideZeroException e) {
			// 상속관계에서 형제 관계인 예외 클래스들은 하나의 catch 로 다룰 수 있음
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	// 예외 실습 1 : 문제 1
	public void testSilsub1() {
//		키보드로 문자열을 입력받아(Scanner 사용)
//		CountAlpha 메서드로 문자열 전달하고, 실행결과 받아 출력함.
//		- 반드시 try ~ catch 문 사용
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("문자열 입력 : ");
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("포함된 알파벳 문자 갯수 : " + count);
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// 예외 실습 1 : 문제 2
	public void testSilsub2() {
		
	}
	
	
	
	
	
	
}
