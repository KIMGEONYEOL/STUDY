package collection.controller;

import java.util.ArrayList;
import java.util.HashSet;

import collection.model.vo.Book;
import collection.model.vo.BookPriceDescending;
import collection.model.vo.BookTitleAscending;

public class ListSample {
	public void testArrayList() {
		// List 계열 ArrayList 사용 테스트
		ArrayList alist = new ArrayList(); // 객체 10개 저장
//		List alist2= new ArrayList();
//		Collection alist3 = new ArrayList();
		
		// 객체만 저장함, 저장 순서가 유지됨, 저장 순번(index)이 자동 부여됨
		// 배열과 같은 저장 방식이면서, 저장 용량에 제한이 없다.
		alist.add(new String("java"));
		alist.add("oracle"); // Auto Boxing
		alist.add(123); // Auto Boxing
		alist.add(34.5);// Auto Boxing
		
		System.out.println(alist);
		//저장 순번(index)이 있어서, 저장 객체 하나씩 취급할 수 있음 : get(index) : Object
		for (int index = 0; index < alist.size(); index++) {
			System.out.println(index + " : " + alist.get(index));
		}
		
		// 저장 위치에 대한 순번(index)이 있으므로, 원하는 위치에 저장되게 할 수도 있음 : add(index, element)
		alist.add(2, "javascript"); //  기존의 객체들은 순번이 뒤로 하나씩 밀려남
		
		System.out.println(alist);
		
		// 원하는 위치(index)의 저장된 객체정보를 변경할 수도 있음 : set(index, element)
		alist.set(2, new HashSet());
		System.out.println(alist);
		
		// 중복 저장됨
		alist.add("java");
		System.out.println(alist);
		
		// 저장된 개게를 연속으로 처리할 경우
		// for 문, for each 문, toArray(), iterator() 사용 가능함
		System.out.println("\n for each 사용 ---------------------------");
		for(Object obj : alist) {
			System.out.println(obj);
		}
		
	} // testArrayList()
	
	public void testBookList()	{
		// 객체 배열이라면
		// Book[] books = new Book[저장 갯수 지정];
		// Book 객체를 리스트에 저장 처리
		ArrayList bookList = new ArrayList();
		
		bookList.add(new Book("해리포터", 28000));
		bookList.add(new Book("모비딕", 27000));
		bookList.add(new Book("데미안", 12000));
		bookList.add(new Book("웨더링 하이츠", 18000));
		bookList.add(new Book("인간 관계론", 20000));
		
		System.out.println(bookList);
		
		// for 문
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(i + " : " + bookList.get(i));
		}
		
		// for each 문
		for(Object obj : bookList) {
			System.out.println(obj);
		}
		
		// sort() 로 정렬 처리 : 저장된 객체의 필드값 중에서 정렬 기준으로 사용할 필드 지정이 필요함
		// sort(Comparator 레퍼런스) : 정렬 기준이 지정된 Comparator 후손클래스를 매개변수로 사용함
		// 즉, Comparator 를 상속받은 후손클래스를 먼저 만듦 => compare(T o1, T o2) 메서드 오버라이딩함
		// 오버라이딩한 compare () 메서드 안에서 정렬 기준 정함
		
		System.out.println("도서제목 기준 오름차순 정렬 -----------------------");
		bookList.sort(new BookTitleAscending());
		System.out.println(bookList);
		
		// for each 문
		for(Object obj : bookList) {
			System.out.println(obj);
		}
		
		System.out.println("도서가격 기준 내림차순 정렬 -----------------------");
		bookList.sort(new BookPriceDescending());
		System.out.println(bookList);
		
		// for each 문
		for(Object obj : bookList) {
			System.out.println(obj);
		}
	}
	
	
}












