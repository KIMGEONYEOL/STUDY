package book.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import book.mvc.model.vo.Book;

public class BookDao {
	
	
	public int insertBook(Book b) {
		int result = 0; // 처리된 행 갯수
		Statement stmt = null;
		String 
		return 0;
	}
	
	public int updateBook(Book b) {
		return 0;
	}
	
	public int deleteBook(int bid) {
		return 0;
	}
	
	public ArrayList<Book> selectAllBooks(){
		ArrayList<Book> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from Book";
		
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			close(rset);
			close(stmt);
			
		}
		
		return list;
	}
	
	public ArrayList<Book> serchBookTitle(String bookTitle){
		return;
	}
	
	public Book selectBook(int bookId) {
		return;
	}
	
}
