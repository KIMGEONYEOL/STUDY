package practice2;

import java.util.ArrayList;

public class BookManager {
	// Field
	private ArrayList bookList[];
	
	
	// Constructor
	public void bookList() {
		bookList = new ArrayList[];
	}
	public BookManager(ArrayList[] bookList) {
		super();
		this.bookList = bookList;
	}
		
	
	// Method
	public void addBook(Book book) {
		
	}
	
	public void deleteBook(int index) {
		
	}
	
	public int searchBook(String bTitle) {
		return bTitle;
	}
	
	public void printBook(int index) {
		
	}
	
	public void displayAll() {}
	
	public Book sortedBookList() {
		//해당 카테고리 순 오름차순 정렬해서 객체배열 리턴함.
		bookList.sort(new AscCategory());
		Book[] bar = new Book[bookList.size()];
		return;
	}
	
	public void printBookList()
	
	
	
	
}
}
	
	
	
	