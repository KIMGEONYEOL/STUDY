package com.practice1.model.vo;
//vo(value object) : 값 저장용 객체

public class Book {
	//Field
	private String title;
	private String author;
	private int price;
	
	@Override
	public String toString() {
		return "제목 : " + title + ", 저자 : " + author + ", 가격 : " + price ;
	}
	
	@Override
	public boolean equals(Object obj) {
		Book bobj = (Book)obj;
		return (this.title.equals(bobj.title)) && (this.author.equals(bobj.author)) && (this.price == bobj.price);
	}
	
	/*
	 public boolean equals(Object obj){
	 	boolean result = false;
	 	book b = (Book)obj;
	 	if(this.title.equals(b.title) && this.author.equals(b.author) && this.price == b.price)
	 		result = true;
	 		
 		return result;
	 }
	  */
	
	
	@Override
	public Object clone() {
		return new Book(this.title, this.author, this.price);
	}
	
	// Constructor 기본 생성자 & 매개변수 생성자
	// 생성자는 오버로딩(overloading) 가능 => 한 클래스 안에서 이름이 같은 함수 여러 개 작성(중복 작성)
	// 오버로딩 작성 규칙 : 매개변수가 반드시 달라야 함 (갯수, 자료형, 나열순서)
	// 접근제한자, 리턴타입은 오버로딩 판단 대상이 아님 => 함수명과 매개변수로만 중복을 판단함
	public Book(){} // 매개변수 없는 생성자 : 기본 생성자
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;			
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
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
