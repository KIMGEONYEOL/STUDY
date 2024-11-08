package collection.view;

import java.util.Scanner;

import collection.controller.ListSample;
import collection.controller.MapSample;
import collection.controller.SetSample;

public class Menu {
	// Field
	// 의존성 주입(DI : Dependency Injection) => 의존관계 만듦
	private static SetSample ssamp = new SetSample();
	private static ListSample lsamp = new ListSample();
	private static MapSample msamp = new MapSample();
		
	public static void display() {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n*** 컬렉션 사용 테스트 ***\n");
			
			System.out.println("1. HashSet 사용 테스트");
			System.out.println("2. LinkedHashSet 사용 테스트");
			System.out.println("3. TreeSet 사용 테스트");
			System.out.println("4. TreeSet 실습 : 로또 번호 생성");
			System.out.println("5. ArrayList 사용 테스트");
			System.out.println("6. ArrayList 사용 테스트 : bookList");
			System.out.println("7. HeshMap 사용 테스트");
			System.out.println("8. HeshMap 사용 테스트 : 연속 처리");
			System.out.println("9. TreeMap 사용 테스트");
			
			System.out.println("0. 끝내기");
			
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1: ssamp.tesetHashSet();	break;
			case 2: ssamp.testLinkedHashSet();break;
			case 3: ssamp.testTreeSet();	break;
			case 4: ssamp.lottoDisplay();	break;
			case 5: lsamp.testArrayList();	break;
			case 6: lsamp.testBookList();   break;
			case 7: msamp.testHashMap();	break;
			case 8: msamp.testHashMap2();	break;
			case 9: msamp.testTreeMap();	break;
				
			case 0: System.out.println("프로그램을 종료합니다.");
					//System.exit(0); // 프로그램 강제 종료함
					return;
			default: System.out.println("잘못 입력하셨습니다. 확인하고 다시 입력하세요.");
			}
			
			
		} while(true);
		
	}
	
	
	// Field
	
	// Constructor
	
	// Method
}
