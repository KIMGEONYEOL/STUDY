package employee.controller;

import java.util.ArrayList;

import employee.model.dao.EmployeeDao;
import employee.model.dto.Employee;

// MVC 패턴 : view(사용자 화면;UI) -> 요청 -> Controller 가 받음 -> model 로 전달함
// model 이 결과 리턴 -> controller 가 받아서 view 로 리턴함 -> view 가 받아서 출력
public class EmployeeController {
	private EmployeeDao edao = new EmployeeDao();
	
	// dao 가 가진 메서드와 맞춰서 메서드를 구성함
	// view 에서 받은 데이터 가공처리나 유효성 검사 등을 해서 모델로 넘김
	
	
	public ArrayList<Employee> selectList(){
		return edao.selectAll(); // return 하는 값을 전부 view 로 전달함.
	}
	
	// 사번으로 조회
	public Employee selectEmp(String empId) {
		return edao.selectOne(empId);
	}
	
	// 
	public int insertEmp(Employee emp) {
		return edao.insertEmployee(emp);
	}
	
	public int updateEmp(Employee emp) {
		return edao.updateEmployee(emp);
	}
	
	public int deleteEmp(String empId) {
		return edao.deleteEmployee(empId);
	}
	
	public ArrayList<Employee> selectDept(String deptId){
		return edao.selectDept(deptId);
	}
	
	public ArrayList<Employee> selectJob(String jobId){
		return edao.selectJob(jobId);
	}
	
	
	
	
	
	
}
