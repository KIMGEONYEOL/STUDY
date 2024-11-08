package collection.model.vo;

public class BookPriceDescending implements java.util.Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// 도서가격 기준 내림차준 정렬 기준 설정
		int result = 0;
		
		if(o1 instanceof Book && o2 instanceof Book) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			
			result = (b1.getPrice() < b2.getPrice())? 1: ((b1.getPrice() == b2.getPrice())? 0 : -1);
			//오름차순
			//result = (b1.getPrice() > b2.getPrice())? 1: ((b1.getPrice() == b2.getPrice())? 0 : -1);
		}
		return result;
	}

}
