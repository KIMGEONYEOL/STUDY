package inherit.run;

import com.uni.Student;

import inherit.sample.Point;
import inherit.sample.Shape;

public class Menu {
	
	//static (정적 메모리 : 메모리 영역의 크기가 고정된 영역)
	//실행될 때 메모리에 로드되어 기록되는 위치가 정적 메모리에 할당한다는 의미임
	//static 은 프로그램이 실행될 때(main 이 start 될 때) 자동으로 메모리에 기록할당됨
	//프로그램 종료(main 종료)시 자동 삭제됨 => 프로그램 구동되는 동안에는 계속 존재함 (객체간 자원 공유시 이용)
	//public static int value = 123;
	//public static String value2 = "정적메모리";
	
	public static void display() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		do {
			System.out.println("\n*** 상속 테스트 ***\n");
			System.out.println("1. this 레퍼런스 객체 인스턴스 주소 전달 확인");
			System.out.println("2. equals() 오버라이딩 확인");
			System.out.println("3. clone() 오버라이딩 확인");
			System.out.println("4. 상속 확인 : Shape");
			System.out.println("5. 상속 실습2 : Student");
			System.out.println("6. 상속 실습1 : Book 메소드 오버라이딩");
			System.out.println("7. 상속 실습2 : 여러 후손에 대한 객체 배열");
			System.out.println("9. 프로그램 끝내기");
			
			System.out.print("선택 번호 입력 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1:  testThis();		break;
			case 2:	testEquals();	break;
			case 3:	testClone();	break;
			case 4:	testShape();	break;
			case 5:	testStudent();	break;
			case 6:	testBook();	break;
			case 7:	testObjectArray();	break;
			
			case 9:	System.out.println("정말로 종료하시겠습니까? (종료: y, 취소: n) : ");
					if(sc.next().toUpperCase().charAt(0) == 'Y') {
						return;  //main() 으로 돌려보냄 => 프로그램 종료
					}else {
						break;  //switch 을 끝냄
					}
			default:	System.out.println("잘못 입력하셨습니다. 확인하고 다시 입력하세요.");
			}
		}while(true);
	}  //display()
	
	private static void testBook() {
		//상속 실습문제1 : 1번
	}
	
	private static void testObjectArray() {
		//상속 실습문제1 : 2번
	}
	
	private static void testStudent() {
		//상속 실습문제 2
		//객체 배열 : Student 객체 3개 초기화 생성
		Student arrays [] = new Student[3];
		
		arrays[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		arrays[1] = new Student("한사람", 13, 183, 72, "201102", "건축");
		arrays[2] = new Student("임걱정", 16, 175, 65, "201103", "무영");
		
		//for loop 문 사용한 경우
		for(int i = 0; i < arrays.length; i++)
			System.out.println(arrays[i].printInformation());
		System.out.println();
		
		//for each 문 사용한 경우 : 객체배열, 컬렉션
		//for(클래스타입 레퍼런스 : 배열 또는 컬렉션) { 레퍼런스.메소드 사용 }
		for(Student s : arrays)
			System.out.println(s.printInformation());
		System.out.println();

	}
	
	private static void testShape() {
		Shape s = new Shape();
		System.out.println("s가 가진 주소 : " + s.hashCode());
		System.out.println("s가 참조 객체 필드값 : " + s);
		
		//부모 멤버는 후손이 사용할 수 있다.
		s.setX(120);
		s.setY(230);
		System.out.println("값 확인 : " + s.getX() + ", " + s.getY());
		
		//super() 이용해서 부모의 매개변수 있는 생성자로 초기값 전달 확인
		Shape s2 = new Shape(10, 10, 100, 100);
		System.out.println("s2 : " + s2/* .toString() */);
	} 
	
	private static void testClone() {
		Point p1 = new Point(100, 100);
		System.out.println("p1 이 가진 주소 : " + p1.hashCode());
		
		Point p2 = (Point)p1.clone();  //리턴타입 Object => Point 로 형변환함
		//다형성 : 부모(Object)가 여러 후손타입을 받을 수 있다.
		//후손은 부모 타입을 못 받음 => 상속관계에 있으면 형변환 가능함
		System.out.println("p2가 가진 주소 : " + p2.hashCode());
		
		System.out.println("p1 필드값 : " + p1);
		System.out.println("p2 필드값 : " + p2);  
		
		System.out.println("값 비교 : " + p1.equals(p2));  //true
		System.out.println("주소 비교 : " + (p1 == p2));  //false
	}
	
	private static void testEquals() {
		Point p1 = new Point(10, 10);
		System.out.println("p1 이 가진 주소 : " + p1.hashCode());
		System.out.println("p1이 참조하는 객체 안의 필드값 : " + p1/* .toString() */);
		
		Point p2 = new Point(20, 20);
		System.out.println("p2 가 가진 주소 : " + p2.hashCode());
		System.out.println("p2가 참조하는 객체 안의 필드값 : " + p2/* .toString() */);
		
		System.out.println("두 객체가 가진 값들이 일치하느냐 : " + p1.equals(p2));  //false
		
		Point p3 = p1;  //shallow copy (얕은 복사) : 주소 복사
		System.out.println("두 객체가 가진 값들이 일치하느냐 : " + p1.equals(p3)); //true
	}
	
	private static void testThis() {
		Point p1 = new Point();  //힙 메모리에 객체 생성하고, 그 주소를 p1에 기록함
		//객체 생성시 자동 실행된 생성자 안의 this 레퍼런스도 자동으로 객체의 주소를 전달받게 됨
		System.out.println("p1이 가진 객체의 주소 : " + p1.hashCode());
		System.out.println("p1이 참조하는 객체안의 인스턴스 변수값 확인 : " + p1.toString());
		//레퍼런스.메소드명() 실행하면, 레퍼런스가 가진 객체주소를 메소드 안의 this에게 자동 전달되게 됨 
		
		System.out.println("Object 의 toString() : " + new Object().toString());
	}
}



