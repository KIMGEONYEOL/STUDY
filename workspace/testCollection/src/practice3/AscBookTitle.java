package practice3;

import practice2.Book;

public class AscBookTitle implements java.util.Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// 도서명 기준 오름차순정렬 처리
		int result = 0;
		
		if(o1 instanceof Book && o2 instanceof Book) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			
			result =  (b1.getTitle().compareTo(b2.getTitle()) >0)? 1: 
				((b1.getTitle().compareTo(b2.getTitle()) >0)? -1: 0);
			// 비교하는 앞 제목글자가 크면 1을, 뒤 제목글자가 크면 -1을 두 글자가 같으면 0을 리턴함
		}
		return result;
	}
	
}
