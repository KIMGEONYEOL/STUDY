package practice3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import practice2.Book;

public class BookManagerMap {
	// Field
	private HashMap booksMap; // 도서 번호를 key 로 사용함.
	
	public BookManagerMap() {
		booksMap = new HashMap();
	}
	
	public BookManagerMap(Map map) {
		booksMap = new HashMap(map);
	}
//	//Method
//		+ putBook(book:Book) : void	//맵에 객체 추가, 도서번호를 키로 사용함
		public void putBook(Book book) {
			booksMap.put(book.getbNo(), book);
		}
		
//		+ removeBook(key:String) : void	//맵에서 객체 제거
		public void removeBook(String key) {
			booksMap.remove(key);
		}
		
//		+ searchBook(String bTitle) : String	: entrySet() 사용
//			//도서명이 일치하는 객체의 도서번호를 리턴
//			//도서명이 객체가 맵에 없으면, null 리턴함
		public String searchBook(String bTitle){
			String key = null;
						
			Iterator booksIter = booksMap.entrySet().iterator();
			while(booksIter.hasNext()) {
				Map.Entry entry = (Map.Entry)booksIter.next();
				key = (String)entry.getKey();
				Book b = (Book)entry.getValue();
				
				if(b.getTitle().equals(bTitle)) // 검색 문자열과 도서 제목이 일치하면 반복 종료함
					break;
			}				
			return key;
		}
		
//		+ displayAll():void		//맵정보 모두 출력 : keySet() 사용
		public void displayAll() {
			Iterator booksIter = booksMap.keySet().iterator();
			while(booksIter.hasNext()) {
				System.out.println(booksMap.get(booksIter.next()));
			}
		}
			
//		+ sortedBookMap():Book[]
//			// 해당 도서명순으로 오름차순정렬해서 객체배열 리턴함
		public Book[] sortedBookMap() {
//			// 방법 1 
//			List bookList = new ArrayList(booksMap.values());
//			bookList.sort(new AscBookTitle());
//			
//			Book[]	bar = new Book[bookList.size()];
//			bookList.toArray(bar);
//			
//			return bar;
//		}
			
			// 방법 2
			TreeMap tmap = new TreeMap(new AscBookTitle());
			tmap.putAll(booksMap);
			Book[] bar = (Book[])tmap.values().toArray();
			return bar;
}
		
//		+ printBookMap(Book[] br) : void
//			//객체 배열 출력, for each 문 사용
		public void printBookMap(Book[]  br) {
			for(Book b : br) {
				System.out.println(b);
			}
		}
//		+ printBook(key:String) : void	//
		public void printBook(String key) {
			System.out.println(booksMap.get(key));
		}
	
}
