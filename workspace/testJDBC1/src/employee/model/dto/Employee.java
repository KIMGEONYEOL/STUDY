package employee.model.dto;

import java.sql.Date;

// domain model : 테이블의 한 행(domain, record) 의 각 컬럼값 저장용 객체(vo, dto, entity, do, bean)
// dto(data transfer object) : 데이터 전송용 객체 (값을 담아서 다른 클래스로 전달되는 객체를 말함)
// 작성원칙 :
// 1. 반드시 직렬화 할 것
// 2. 모든 필드는 private
// 3. 기본생성자, 매개변수 있는 생성자 작성
// 4. 모든 필드의 getter and setter 작성
// 5. toString() 오버라이딩
public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = -6485478099399133514L;
	
	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double bonusPct;
	private String marriage;
	private String mgrId;
	private String deptId;
	
	public Employee() {
		super();
	}
	
	// NotNull 제약조건인 변수들을 모아둔 생성자 작성
	public Employee(String empId, String empName, String empNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
	}
	// 모든 변수를 받는 생성자 작성
	public Employee(String empId, String empName, String empNo, String email, String phone, Date hireDate, String jobId,
			int salary, double bonusPct, String marriage, String mgrId, String deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.marriage = marriage;
		this.mgrId = mgrId;
		this.deptId = deptId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPct() {
		return bonusPct;
	}

	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName 
				+ ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", hireDate=" + hireDate + ", jobId=" + jobId
				+ ", salary=" + salary	+ ", bonusPct=" + bonusPct + ", marriage=" + marriage
				+ ", mgrId=" + mgrId + ", deptId=" + deptId + "]";
	}
	
	
	
	
	
}
