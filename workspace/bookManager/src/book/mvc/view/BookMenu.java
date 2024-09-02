package book.mvc.view;

import java.util.Scanner;

import book.mvc.controller.BookController;

public class BookMenu {
	private BookController bcontroller;
	Scanner sc = new Scanner(System.in);
	
	
	
	public void displayMenu() {
		while(true){
			
			System.out.println("\n**** 도서 관리 프로그램 ****\n");
			System.out.println("1. 도서 추가 : ");
			System.out.println("2. 도서 정보 수정 : ");
			System.out.println("3. 도서 삭제 : ");
			System.out.println("4. 도서 아이디로 조회 : ");
			System.out.println("5. 도서 제목으로 조회 : ");
			System.out.println("6. 도서 목록 전체 조회 : ");
			
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1: insertBook(); break;
			case 2: updateBook(); break;
			case 3: deleteBook(); break;
			case 4: serchBook(); break;
			case 5: serchBookTitle(); break;
			case 6: selectAll(); break;
			
			case 9: System.out.println("정말 끝내시겠습니까?");
					if(sc.next().toUpperCase().charAt(0) == 'Y') {
						System.out.println("프로그램 종료.");
						return;
					}else {
						break;
					}
			default: System.out.println("잘못 입력된 번호입니다. 확인 후 다시 입력해주세요.");							
			}
			
			
		}
		
	}
	
	
}
