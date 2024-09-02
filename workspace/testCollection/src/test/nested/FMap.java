package test.nested;

public interface FMap {
	// 상수 필드를 멤버로 가질 수 있음
	// public static final 자료형 필드명 = 초기값;
	
	// 추상메서드만 멤버로 가질 수 있음
	// public abstract 반환자료형 메서드명(자료형 매개변수, ...);
	
	// 내부(Nested) 인터페이스를 멤버로 가질 수 있음
	// 접근제한자 [static] interface 인터페이스명 { 상수필드선언; 추상메서드 선언; }
	public static interface FEntry{
		
	}
}