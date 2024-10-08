package poly.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import poly.model.dto.Customer;
import poly.model.dto.Person;
import poly.model.dto.Student;
import poly.model.vo.Circle;
import poly.model.vo.Rectangle;
import poly.model.vo.Shape;
import poly.moder.entity.IShape;
import test.abst.AbstractSample;
import test.abst.SubClass;
import test.gui.MyWindow;
import test.poly.PolySample;


public class Menu {
	public static void display() {
		do {
			Scanner sc = new Scanner(System.in);	
			
			System.out.println("\n*** 다형성 테스트 ***\n");
			System.out.println("1. 추상(abstract) 클래스 확인");
			System.out.println("2. 상속 연습 : MyWindow (GUI) ");
			System.out.println("3. 다형성 연습 : 메서드 매개변수에 다형성 적용 ");
			System.out.println("4. 다형성 테스트 : Person 상속");
			System.out.println("5. 상속 다향성 실습문제 1 : Shape 클래스 상속");
			System.out.println("6. 상속 다향성 실습문제 2 : IShape 인터페이스 상속");
			System.out.println("7. 상속 다향성 실습문제 3 : 객체배열에 다형성 사용");
			System.out.println("9. 끝내기");
			
			System.out.print("번호 입력 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1: testAbstact(); break;
			case 2: testMyWindow(); break;
			case 3: testPolySample(); break;
			case 4: testPerson(); break;
			case 5: testShape(); break;
			case 6: testIShape(); break;
			case 7: testPolymorphism(); break;
			
			case 9: System.out.println("\n프로그램을 종료합니다");
					return; // main() 으로 리턴시킴 =>main() 종료됨
			default: System.out.println("잘못 입력하셨습니다. 확인하고 다시 입력하세요.");
			}
							
		} while(true);
	} //display()
	private static void testPolymorphism() {
		// 다형성 실습문제 3
		IShape[] iarr = new IShape[5]; // 객체배열은 주소배열임. (레퍼런스 배열임)
		// 객체 주소 저장할 레퍼런스변수 5개를 배열로 할당하고, 배열의 시작주소를 iarrr 에 기록함
		
		// 5개의 후손 객체를 무작위로 생성함 (Circle, Rectangle,  Trianle)
		iarr[0] = new poly.moder.entity.Circle(15.5);
		iarr[1] = new poly.moder.entity.Triangle(4., 5.);
		iarr[2] = new poly.moder.entity.Triangle(7., 8.);
		iarr[3] = new poly.moder.entity.Circle(4.3);
		iarr[4] = new poly.moder.entity.Rectangle(7, 7);
	
		// for loop 문으로 각 객체의 면적과 둘레를 출력 처리함
		// 단, Triangle 객체는 빗변길이도 같이 출력 처리함
		for (int i = 0; i < iarr.length; i++) {
			// instanceof 연산자 : 레퍼런스가 참조하는 객체의 클래스타입을 묻는 연산자임
			// if(레퍼런스 instanceof 클래스타입) {참일 때 처리내용. }
			if(iarr[i] instanceof poly.moder.entity.Circle) {
			System.out.println("원면적 : " + iarr[i].area());
			System.out.println("원둘레 : " + iarr[i].perimeter());
			}
			if(iarr[i] instanceof poly.moder.entity.Rectangle) {
				System.out.println("사각형면적 : " + iarr[i].area());
				System.out.println("사각형둘레 : " + iarr[i].perimeter());
			}
			if(iarr[i] instanceof poly.moder.entity.Triangle) {
				// 후손 멤버는 부모레퍼런스로 참조할 수 없음 => 후손 타입으로 형변환 해야함.
				System.out.println("삼각형빗변길이 : " + ((poly.moder.entity.Triangle)iarr[i]).getHypotenuse());
				System.out.println("삼각형면적 : " + iarr[i].area());
				System.out.println("삼각형둘레 : " + iarr[i].perimeter());
			}
			
		}
	}
	
	
	
	private static void testIShape() {
		// 상속 다형성 실습문제 2
		IShape s;
		
		s = new poly.moder.entity.Circle(15.5);
		System.out.println("원면적 : " + s.area());
		System.out.println("원둘레 : " + s.perimeter());
		
		s = new poly.moder.entity.Rectangle(34.5, 12.7);
		System.out.println("사각형면적 : " + s.area());
		System.out.println("사각형둘레 : " + s.perimeter());
		
	}
	
	private static void testShape() {
		// 상속 다형성 실습문제 1
		Shape s;
		
		s = new Circle(15.5);
		System.out.println("원면적 : " + s.area());
		System.out.println("원둘레 : " + s.perimeter());
		
		s = new Rectangle(34.5, 12.7);
		System.out.println("사각형면적 : " + s.area());
		System.out.println("사각형둘레 : " + s.perimeter());
		
	}
	
	
	private static void testPerson() {
		// 다형성(Polymorphism) : 상속을 통해 사용할 수 있는 기술임
		// 상속관계에 있는 부모클래스는 후손클래스 객체의 주소를 받을 수 있음
		Person P = null;
		
		// 부모타입의 레퍼런스에 후손 객체의 주소 대입 가능함
		P = new Customer("김철수", 28, '남', "kimch33@test.org", "010-1234-5678", 
				"서울시 서초구 신논현동 77", 1350.77);
		System.out.println(P); //p.toString() 과 같음
		
		Customer c = new Customer("김광징", 28, '남', "kimch77@test.org", "010-1234-5897", 
				"서울시 서초구 신논현동 78", 7851.77);
		P = c;
		System.out.println(P); //p.toString() 과 같음
		
		P = new Student("이영희", 35, '여', "leeyh@test.org", "010-2345-7865",
				12, "영어영문학", 3.8);
		System.out.println(P); //p.toString() 과 같음
		
		Object obj = c;
		System.out.println(obj); //obj.toString() 과 같음
		obj = P;
		System.out.println(obj); //obj.toString() 과 같음
		
		obj = new GregorianCalendar();
		System.out.println(obj); //obj.toString() 과 같음
		
		obj = new String("다형성 확인");
		System.out.println(obj); //obj.toString() 과 같음
		
		// 다형성은 부모가 여러 후손들을 다루는 기술임
		// 상속관계가 아닌 클래스 간에는 사용할 수 없음
//		Customer cm = new Student(); // error
	}
	
	
	
	private static void testPolySample() {
		PolySample psamp = new PolySample();
		
		psamp.printObject("메서드 매개변수에 다형성 사용 확인");
		psamp.printObject(new java.util.Date());
		psamp.printObject(12.45);
		psamp.printObject(123);
		psamp.printObject(new GregorianCalendar());
	}
	
	
	private static void testMyWindow() {
		new MyWindow();
	}
	
	
	private static void testAbstact() {
		// abstract class (미완성 클래스) 사용 테스트
		// abstract 클래스는 객체 생성 못 함, 레퍼런스 벼수 선언은 가능함
		AbstractSample samp = null;
//		samp = new AbstractSample(); // 미완성 클래스이므로 객체 생성 못 함, 에러
		Calendar today = null;
//		today = new Calendar(); // 미완성 클래스이므로 객체 생성 못 함, 에러
	
		// 후손 객체의 주소를 저장하기 위한 용도로 레퍼런스는 선언 할 수 있음.
		samp = new SubClass();
		today = new GregorianCalendar();
	}
		
	
}// Menu class

