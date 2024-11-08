package db.model.dto;

import java.sql.Date;

//domain model : 테이블의 한 행(domain, record) 의 각 컬럼값 저장용 객체(vo, dto, entity, do, bean)
//dto(data transfer object) : 데이터 전송용 객체 (값을 담아서 다른 클래스로 전달되는 객체를 말함)
//작성원칙 :
//1. 반드시 직렬화 할 것
//2. 모든 필드는 private
//3. 기본생성자, 매개변수 있는 생성자 작성
//4. 모든 필드의 getter and setter 작성
//5. toString() 오버라이딩
public class Db implements java.io.Serializable {
	private static final long serialVersionUID = -6485478099399133514L;

	private String totalId;
	private String title;
	private String contributor;
	private String description;
	private String eventSite;
	private String genre;
	private String contactPoint;
	private String url;
	
	
	
	
	public Db() {
		super();
	}

	public Db(String totalId, String title, String contributor, String description, String eventSite, String genre,
			String cantactPoint, String url) {
		super();
		this.totalId = totalId;
		this.title = title;
		this.contributor = contributor;
		this.description = description;
		this.eventSite = eventSite;
		this.genre = genre;
		this.contactPoint = cantactPoint;
		this.url = url;
	}
		
	
	// NotNull 제약조건인 변수들을 모아둔 생성자 작성
	
	
	// 모든 변수를 받는 생성자 작성
	
	public String getTotalId() {
		return totalId;
	}
	
	public void setTotalId(String totalId) {
		this.totalId = totalId;
	}
		
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContributor() {
		return contributor;
	}
	
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEventSite() {
		return eventSite;
	}
	
	public void setEventSite(String eventSite) {
		this.eventSite = eventSite;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getContactPoint() {
		return contactPoint;
	}
		
	public void setContactPoint(String cantactPoint) {
		this.contactPoint = cantactPoint;
	}
		
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
	
	
	
	

