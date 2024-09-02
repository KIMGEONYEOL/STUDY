package test.objectio;

// 회원정보 저장용 객체를 위한 클래스임 : vo, dto, do, entity, bean
// 1. 반드시 직렬화 할 것 => java.io.Serializable 인터페이스 상속받으면 됨
// 2. 모든 Field 는 private
// 3. 기본 생성자는 매개변수 있는 생성자 작성할 것
// 4. 모든 Field 에 대한 setters and getters 작성할 것
// 5. toString(), equals(), clone(), hashCode() 오버라이딩은 선택사항
public class Member implements java.io.Serializable {
	// Field
	private String name;
	private int age;
	private char gender;
	private String email;
	private String phone;
	private double point;
	
	
	// Constructor
	public Member() {
		super();
	}
	
	public Member(String name, int age, char gender, String email, String phone, double point) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.point = point;
	}
	

	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", point=" + point + "]";
	}
	
}
