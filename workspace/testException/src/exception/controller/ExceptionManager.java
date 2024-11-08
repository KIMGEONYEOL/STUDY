package exception.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import exception.silsub2.NumberProcess;

// 예외처리 테스트를 위한 기능 제공용 클래스
public class ExceptionManager {
	
	// Method
	public void testException1() {
		// 자바가 제공하는 클래스의 생성자 또는 메서드 사용시, 반드시 예외처리해야 되는 경우가 있음
		// 생성자나 메서드 뒤쪽에 throws XXXXException 이 표기되어 있는 경우
		try {
			FileReader fw = new FileReader("sample1.txt"); // 반드시 예외처리 해야 되는 구문임
			System.out.println("작동 되는지 확인"); // 위의 구문에서 예외가 발생하면, 이 구문은 실행되지 않음.
		}catch (FileNotFoundException e) {
			// 해당 에러가 발생했을 때 처리 구문을 작성함
//			e.printStackTrace(); // 제품으로 나가는 상태에선 출력하면 안 됨 
			System.out.println("대상 파일이 존재하지 않습니다. 확인하고 다시 사용하세요.");
			return; // Menu 로 돌려보냄
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			// 예외가 발생해도 작동됨, 예외가 발생하지 않아도 작동됨.
			// 반드시 실행시켜야 되는 구문을 작성함.
			System.out.println("finally 작동됨.....");
		}
	}
	
	public void testException2() throws FileNotFoundException {
		methodA();
	}
	
	public void methodA() throws FileNotFoundException {
		methodB();
	}
	
	public void methodB() throws FileNotFoundException {
		methodC(); // 메서드 사용 위치로 예외가 넘어옴
		// 예외 처리 직접하지 않고 넘김(throws)
	}
	
	public void methodC() throws FileNotFoundException {
		new FileReader("sample.txt"); // 반드시 예외 처리 해줘야 함.
		// 예외를 직접 해결 처리하지 않고 넘겨버림
	}
	
	public void testSilsub2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 : ");
		int first = sc.nextInt();
		System.out.println("두번째 정수 : ");
		int second = sc.nextInt();
		
		try {
			if(new NumberProcess().checkDouble(first, second))
				System.out.println(first + "는 " + second + "의 배수이다.");
			else
				System.out.println(first + "는 " + second + "의 배수가 아니다.");
		} catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
}
