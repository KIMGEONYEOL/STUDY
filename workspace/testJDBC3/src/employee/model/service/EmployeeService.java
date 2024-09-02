package employee.model.service;

import static common.JDBCTemplate.*;
//JDBCTemplate 이 가진 모든 static 메서드를 import 해라.

import java.sql.Connection;
import java.util.ArrayList;

import employee.exception.EmployeeException;
import employee.model.dao.EmployeeDao;
import employee.model.dto.Employee;

// Connection 관리와 트랜젝션 관리가 주 목적인 서비스 모델임
public class EmployeeService {
	private EmployeeDao edao;
	
	public EmployeeService() throws EmployeeException{
		edao = new EmployeeDao();
	}
	
		
	public ArrayList<Employee> selectAll() throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectAll(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Employee> selectJob(String jobId) throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectJob(conn, jobId);
		close(conn);
		return list;
	}	
	
	public ArrayList<Employee> selectDept(String deptId) throws EmployeeException{
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectDept(conn, deptId);
		close(conn);
		return list;
	}	
	
	public Employee selectOne(String empId) throws EmployeeException{
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empId);
		close(conn);
		return emp;
	}	
	
	public int insertEmployee(Employee emp) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.insertEmployee(conn, emp);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateEmployee(Employee emp) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.updateEmployee(conn, emp);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteEmployee(String empId) throws EmployeeException {
		Connection conn = getConnection();
		int result = edao.deleteEmployee(conn, empId);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
}














