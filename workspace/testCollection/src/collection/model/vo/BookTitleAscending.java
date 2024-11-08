package collection.model.vo;

public class BookTitleAscending implements java.util.Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// 도서 제목들끼리 비교 연산하는 정렬 기준 코드를 작성함
		int result = 0;
		
		// 부모 타입에서 후손타입으로 형변환시에는 (down casting)
		// 반드시 실제 참조하는 클래스가 후손 클래스타입인지 확인하고 형변화할 것
		if (o1 instanceof Book && o2 instanceof Book) {
				Book b1 = (Book)o1;
				Book b2 = (Book)o2;
				
				result = b1.getTitle().compareTo(b2.getTitle());
		}		
		
		return result; // 내림차순은 return -result;	
	}
	
	
}
