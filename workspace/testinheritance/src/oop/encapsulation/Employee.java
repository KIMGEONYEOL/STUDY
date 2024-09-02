package oop.encapsulation;

import java.util.GregorianCalendar;

//import java.util.Date;
//import java.sql.Date;  // 이름이 같은 클래스는 둘 다 임포트할 수 없음 : 에러발생

// 자바에서 만드는 모든 클래스는 자동으로 java.lang.Object 의 후손이 되도록 되어 있음
// java.lang.Object 가 제공하는 메서드들을 후손이 자신의 것 처럼 사용해도 됨.
// 부모(super)가 제공하는 메서드를 후손(sub)이 상속받은 부모메서드를 내용 바꾸기 할 수 있음 =>오버라이딩(overriding) 
// 오버라이딩 : 후손이 부모메서드를 재작성하는 것을 말함.
public class Employee {
	// Field : 캡슐화가 원칙임 (private 이어야 함)
	// 접근제한자 [예약어] 자료형 변수명[= 초기값];
	// 인스턴스 변수(instance variable) -> new 할 때(생성자로 객체 생성할 때)
	// 				 heap 메모리에 객체공간(instance)을 만들면서 객체공간 안에 할당되는 변수를 말함.(자동 초기화됨)
	private String empId = "000"; // 사번
	private String empName = "noname"; // 이름
	private int salary = 1000000; // 급여
	private double bonusPct = 0.01; //보너스포인트
	private java.sql.Date hireDate = new java.sql.Date(new GregorianCalendar(2024, 3, 15).getTimeInMillis()); // 입사일
	
	// 클래스 변수 (class variable) : 프로그램이 실행될 때(main() 이 시작될 때) 자동으로 정적 메모리에
	//								  변수 공간을 할당하고 자동 초기화됨 (JVM 이 준비해 높은 기본값으로)
	private static int count = 1; // 할당된 Employee 객체 갯수 카운트용
	
	// 상수 필드 (constant field) : 초기값을 선언하면 이후에 값 변경 할 수 없는 Field.
	// static 메모리에 할당된 변수는 프로그램 구동내내 존재함 => 프로그램이 끝날 때(main 종료) 자동으로 삭제
	// naming rule : 대문자로 이름을 정의함
	public final static String OFFICE_NAME ="한국인공지능개발회사";
	
	
	// 이름이 같은 클래스를 구분해서 사용하려면, 클래스 앞에 패키지명을 붙이면 됨 : 패키지명.클래스명
	// 단, 이 경우 생성자 앞에도 패키지명 붙여줘야 함.	
	//	private java.sql.Date hireDate = new java.sql.Date(0);
//	private java.util.Date enrollDatd = new java.util.Date(0); // 이름이 같은 클래스는 둘 다 임포트 할 수 없음 : 에러발생
	
	// 초기화 블럭 : 필드 초기값 처리가 목적인 블럭임, 필드명 = 초기값; 처리만 함
	// 생성자 보다 먼저 실행이 됨
	{
		empId = "345";
		empName = "홍길동";
		salary = 8900000;
		bonusPct = 2.5;
		// 오늘 날짜를 입사일로 저장한다면...
//		hireDate = new java.sql.Date(new java.util.Date().getTime()); // 오늘 날짜를 sql 데이터 형으로 변환해서 반환.
//		hireDate = new java.sql.Date(System.currentTimeMillis());
		hireDate = new java.sql.Date(new java.util.GregorianCalendar().getTimeInMillis());
	}
	
//	 static 필드에 대한 초기화 블럭
	static {
		count = 10;
	}
	
	
	
	// Constructor : 객체 생성시 (new 할 때) 인스턴스 변수 초기화 처리가 목적인 함수
	// 생성자가 하나도 없는 클래스일 때는 jvm 이 컴파일 할 때 기본 생성자를 자동 추가하면서 컴파일.
	
	// 기본생성자 (매개변수 없는 생성자) => jvm 이 준비한 기본값으로 초기화시킴
	// public 클래스명(){}
	public Employee() {
		super(); // 모든 생성자 첫 줄에 존재함, 부모생성자 호출 구문임
		Employee.count++;
	}
	
	// 매개변수 있는 생성자 =>생성자 오버로딩 가능
	public Employee(String empId, String empName, int salary, double bonusPct, java.sql.Date hireDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.hireDate = hireDate;
		count++;
	}
	
	// Method (멤버함수) 
	// getters and setters
	// 인스턴스 필드
	// public void set필드명(필드자료형 매개변수){ this.필드명 = 매개변수}
	public void setEmpld(String empId) {
		this.empId = empId;
	}
	
	// public 필드자료형 get필드명(){ return this.필드명; }
	public String getEmpId() {
		return this.empId;
	}
	
	// 클래스 필드 ------------------------
	// static 필드는 getter, setter 에도 static 표기해야 함
	// public static void set필드명(자료형 매개변수) { [클래스명.]필드명 = 매개변수; }
	public static void setCount(int count) {
		// static 메서드 안에는 this 레퍼런스가 없음
		Employee.count = count;
	}
	
	// public static 자료형 get필드명(){ return 필드명;}
	public static int getCount() {
		return count;
	}
	
	
	
	// 일반 메서드 
	// java.lang.Object 가 제공하는 toString() 메서드 오버라이딩함 : 원래 기능은 "객체클래스명@16진수위치값" 리턴
	// 주로 후손 Field 값 출력을 위한 문장만들기로 내용 변경하기 위해 오버라이딩함. 
	// 오버라이딩 규칙 1 : 부모 메서드의 시그니쳐 바꿀 수 없음 (그대로 사용)
	public String toString() {
		// non-static 메서드는 this 레퍼런스를 가지고 있음
		// 메서드가 실행될 때, 레퍼런스.메서드명() 실행시 레퍼런스가 가진 주소를 메서드 안의 this 가 자동 전달받음.
		return "Employee[사번 =" + this.empId + ", 이름=" + this.empName 
				+ ", 급여=" + this.salary + ", 보너스포인트=" + this.bonusPct
				+ ", 입사일=" + this.hireDate + "]";
	}
}	
	
	
	
	
	
	
	
	
	

