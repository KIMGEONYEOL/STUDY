package test.generics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericsSample {
	public void test1() {
		// Collection Class 들은 여러 종류의 Class 객체들을 저장 할 수 있다.
		List list = new ArrayList();
		
		
		list.add(new String("java"));
		list.add(new Book("데미안", "헤르만 헤세"));
		list.add(new Date());
		
		System.out.println(list); // 저장 순서대로 저장된 것 확인
		
		// 저장된 객체를 하나씩 꺼내서 사용하려고 할 때, 기본적으로 Object 타입으로 추출됨
		// get(index) : Object 반환됨
		for(Object obj : list) {
		// Object 타입의 레퍼런스로는 Object 클래스가 가진 메서드나 필드만 다룰 수 있음.
		// toString(), equals(), clone(), hashCode() 메서드만 사용할 수 있다.
		// 후손 클래스들이 오버라이딩 한 경우에는 실행시 오버라이딩 된 후손쪽 메서드로 연결이 바뀜
			System.out.println(obj/* .toString() */);
			
		// 만약, 각 후손 클래스가 가진 멤버를 사용하려면 Object 레퍼런스로는 다룰 수 없음
		// obj.toUpperCase(); // String 클래스를 대문자로 변환하는 메서드임 => Error
		// 해결방법 : Object 레퍼런스를 후손 클래스 타입으로 형변환해야 함
		// 다운 캐스팅시에 레퍼런스가 참조하는 인스턴스의 타입을 확인하고 형변환 할 필요가 있음.
		// => 레퍼런스 instanceof 클래스타입 
			if(obj instanceof String) {
				String s = (String)obj;
				System.out.println(s + "=>" + s.toUpperCase());
				// 코드 축약
				System.out.println(((String)obj).toUpperCase()); // () 가 우선순위기 때문에 꼭 넣어주기.
			}
			if(obj instanceof Book) {
				System.out.println(((Book)obj).getTitle() + ", " + ((Book)obj).getAuthor());	
			}
			if(obj instanceof Date) {
				System.out.println(new SimpleDateFormat("yyyy'년' MM'월' dd'일' E").format((Date)obj));
			}
		} 
		
	}// test1()
	
	public void test2() {
		// 제네릭스(Generics) 기능 :
		// 클래스 사용시 다룰 객체에 대한 타입을 정하면서 이용하는 기능임
		// 클래스명<영문자> 또는 인터페이스<영문자> 표시된 클래스들이 제네릭스 기능을 사용할 수 있다는 표시임
		// 클래스 사용시 한 가지 타입의 클래스 객체만 취급하겠다는 용도로 사용함.
		List<String> list = new ArrayList<String>(); // String 객체만 저장하는 리스트로 선언함
		// String 이 아닌 객체는 저장할 수 없음, 에러남.
		
		// 제네릭스가 적용된 레퍼런스가 메서드로 전달되면, 받아주는 매개변수도 같은 제네릭 타입 지정을 해야 함
		listInitialization(list);
		//제네릭스 사용 장점 : 객체 추출시 다운 캐스팅(형변환) 필요없음
		for(String s : list) {
			System.out.println(s);
		}
	}
	private void listInitialization(List<String> list) {
		// 매개변수에도 제네릭 타입 계속 표기해 줘야 함
		list.add("apple");
		list.add(new String("Orange"));
//		list.add(new Date()); // 선언된 제네릭 타입이 아닌 객체는 저장할 수 없음.
		list.add("grape");
	}// test 2 ()
	
	public void test3() {
		ArrayList<Book> bookList = new ArrayList<Book>();
	}
	
	private void initList(ArrayList<Book> list) {
		list.add(new Book("데미안", "헤르만 헤세"));
		list.add(new Book("인간관계론", "데일 카네기"));
//		list.add(new String("test")); // Error
	}
	private void printList(List<Book> list) {
		// 클래스 타입 확인(instanceof) 필요없음
		// 형변환 필요 없음 => 제네릭스 사용 목적
		for(Book b : list) {
			System.out.println(b);
		}
		
	}
	
	public void testSet() {
		Set<Book> books = new HashSet<Book>();
		
		initSet(books);
		printSet(books);
	}
	private void initSet(Set<Book> set) {
		set.add(new Book("데미안", "헤르만 헤세"));
		set.add(new Book("인간관계론", "데일 카네기"));
		set.add(new Book("집가고싶다", "김거녀르"));
	}
	
	
	
	private void printSet(Set<Book> set) {
		Iterator<Book> iter = set.iterator();
		while(iter.hasNext()) {
			Book book = iter.next(); //형변환 필요없음
			System.out.println(book);
		}
	}
	
	public void tesetMap() {
		Map<Integer, Book> books = new HashMap<Integer, Book>();
		// Map<K, V> : K (key 의 클래스 타입), V (value 의 클래스 타입)
		
		initMap(books);
		printMap(books);
	}
	
	private void initMap(Map<Integer, Book> map) {
		map.put(3, new Book("데미안", "헤르만 헤세"));
		map.put(4, new Book("인간 관계론", "데일 카네기"));
//		map.put("25", new Book()); // Error : key 자료형 틀림
//		map.put(4, new Date()); // Error : value 자료형 틀림
	}
	
	private void printMap(Map<Integer, Book> map) {
		// keySet() : key = value 출력
		Iterator<Integer> keyIter = map.keySet().iterator();
		while(keyIter.hasNext()) {
			Integer key = keyIter.next();
			System.out.println(key + "=" + map.get(key));
		}
		System.out.println("----------------------------------------");

		// entrySet() : 키 = 값 출력
		Iterator<Map.Entry<Integer, Book>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, Book> entry = entries.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}


class Book {
	private String title;
	private String author;
	
	public Book() {}
	
	

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	
	
}
