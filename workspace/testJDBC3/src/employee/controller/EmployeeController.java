package employee.controller;

import java.util.ArrayList;

import employee.exception.EmployeeException;
import employee.model.dao.EmployeeDao;
import employee.model.dto.Employee;
import employee.model.service.EmployeeService;

// MVC 패턴 : view(사용자 화면;UI) -> 요청 -> Controller 가 받음 -> service model 로 전달함
// -> service model 은 Connection 연결 요청 
// -> dao model 로 Connection 과 전달값을 전달 -> dao model 이 결과 리턴 -> service model 이 결과 받음, 트랜젝션 관리함 
// ->  controller 로 넘김 -> controller 가 받아서 view 로 리턴함 -> view 가 받아서 출력
// view -> controller -> service -> dao
public class EmployeeController {
	private EmployeeService eservice = new EmployeeService();
	
	public EmployeeController() throws EmployeeException {
		eservice = new EmployeeService();
	}
	
	
	// dao 가 가진 메서드와 맞춰서 메서드를 구성함
	// view 에서 받은 데이터 가공처리나 유효성 검사 등을 해서 모델로 넘김
	
	
	public ArrayList<Employee> selectList() throws EmployeeException{
		return eservice.selectAll(); // return 하는 값을 전부 view 로 전달함.
	}
	
	// 사번으로 조회
	public Employee selectEmp(String empId) throws EmployeeException {
		return eservice.selectOne(empId);
	}
	
	// 
	public int insertEmp(Employee emp) throws EmployeeException {
		return eservice.insertEmployee(emp);
	}
	
	public int updateEmp(Employee emp) throws EmployeeException {
		return eservice.updateEmployee(emp);
	}
	
	public int deleteEmp(String empId) throws EmployeeException {
		return eservice.deleteEmployee(empId);
	}
	
	public ArrayList<Employee> selectDept(String deptId) throws EmployeeException{
		return eservice.selectDept(deptId);
	}
	
	public ArrayList<Employee> selectJob(String jobId) throws EmployeeException{
		return eservice.selectJob(jobId);
	}
	
	
	
	
	
	
}
