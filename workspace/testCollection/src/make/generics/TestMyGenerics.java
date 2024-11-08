package make.generics;

public class TestMyGenerics {

	public static void main(String[] args) {
		// MyGenerics<T> 사용 테스트
		// String 만 취급
		MyGenerics<String> test1 = new MyGenerics<String>(5);
		
		try {
			test1.add("java");
			test1.add("linux");
			test1.add("oracle");
		
			
			for(int i = 0; i < test1.getCount(); i++) {
				System.out.println(test1.get(i));
			}
		} catch (SizeOverflowException e) {
			e.printStackTrace();
		}
		
		// Book 만 취급
		
		MyGenerics<Book> test2 = new MyGenerics<Book>(10);
		
		try {
			test2.add(new Book("java", "감갈동"));
			test2.add(new Book("리눅스", "박길동"));
			test2.add(new Book("오라클", "이길동"));
			
			System.out.println("지정된 객체수 : " + test2.getCount());
			for(int i = 0; i < test1.getCount(); i++) {
				System.out.println(test1.get(i));
			}
			
		} catch (SizeOverflowException e) {
			e.printStackTrace();
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
	