package employee.model.dao;

//import common.JDBCTemplate;	// 클래스 import
// 클래스가 가진 static 메서드만 import 가능
//import static 패키지명.클래스명.정적메서드명;
//import static common.JDBCTemplate.getConnection; // getConnection 만 import
// static 메서드 모두 import함
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.dto.Employee;

//서비스 모델 : 비즈니스 로직(jdbc) 처리용 클래스
//dao(database access object) : db 접속 객체
public class EmployeeDao {
   //실행시킬 쿼리문장 하나당 메서드 한개씩 작성함
//   System.out.println("1. 직원 전체 조회 출력");
   public ArrayList<Employee> selectAll(){
      ArrayList<Employee> list = null;
     //클래스 임포트시
      //Connection conn = JDBCTemplate.getConnection();
      //static 메서드 import 시
      Connection conn = getConnection();
      Statement stmt = null;
      ResultSet rset = null;
      
      String query = "select * from employee";
      
      try {           
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         
         if(rset != null) { //select 쿼리문 실행이 성공했다면
            list = new ArrayList<Employee>();
            
            while(rset.next()) { //조회해 온 데이터 행이 존재한다면, 반복 실행
               //각 컬럼 값 꺼내서 객체에 저장 처리
               Employee emp = new Employee();
               
               //결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
               emp.setEmpId(rset.getString("emp_id"));
               emp.setEmpName(rset.getString("emp_name"));
               emp.setEmpNo(rset.getString("emp_no"));
               emp.setEmail(rset.getString("email"));
               emp.setPhone(rset.getString("phone"));
               emp.setJobId(rset.getString("job_id"));
               emp.setHireDate(rset.getDate("hire_date"));
               emp.setSalary(rset.getInt("salary"));
               emp.setBonusPct(rset.getDouble("bonus_pct"));
               emp.setMarriage(rset.getString("marriage"));
               emp.setMgrId(rset.getString("mgr_id"));
               emp.setDeptId(rset.getString("dept_id"));
               
               list.add(emp); //리스트에 저장
               
            }//while end
            
         }//if end
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  // 클래스 임포트시
    	  //JDBCTemplate.close(rset);
    	  //JDBCTemplate.close(stmt);
    	  //JDBCTemplate.close(conn);
    	  close(rset);
    	  close(stmt);
    	  close(conn);
      }
      
      return list;
   }
   
//   System.out.println("2. 사번으로 직원 조회 출력");
   public Employee selectOne(String empId) {
      Employee emp = null;
      Connection conn = getConnection();
      //Statement stmt = null;
      PreparedStatement stmt = null;
      ResultSet rset = null;
      
      String query = "select * from employee where emp_id = ?";
      
      try {
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query); // 미완성 쿼리문으로 객체 생성
    	 //? 부분에 적용할 값 대입 처리 : 쿼리문 완성시킴
    	 //stmt.set자료형(?순번, 적용할 값);
    	 stmt.setString(1, empId);    	 
         
    	 //rset = stmt.executeQuery(query);
    	 rset = stmt.executeQuery(); // 쿼리문을 문장 객체가 가지고 있으므로 빈 괄호로 생성
         
         if(rset.next()) { //조회해 온 데이터 행이 존재한다면
            //각 컬럼 값 꺼내서 객체에 저장 처리
            emp = new Employee();
            
            //결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
            emp.setEmpId(empId);
            emp.setEmpName(rset.getString("emp_name"));
            emp.setEmpNo(rset.getString("emp_no"));
            emp.setEmail(rset.getString("email"));
            emp.setPhone(rset.getString("phone"));
            emp.setJobId(rset.getString("job_id"));
            emp.setHireDate(rset.getDate("hire_date"));
            emp.setSalary(rset.getInt("salary"));
            emp.setBonusPct(rset.getDouble("bonus_pct"));
            emp.setMarriage(rset.getString("marriage"));
            emp.setMgrId(rset.getString("mgr_id"));
            emp.setDeptId(rset.getString("dept_id"));
            
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  close(rset);
    	  close(stmt);
    	  close(conn);
           
      }
      
      return emp;
   }
   
//   System.out.println("3. 새 직원 등록");
   public int insertEmployee(Employee emp) {
      int result = 0; //처리된 행 갯수
      Connection conn = getConnection();
      //Statement stmt = null;
      PreparedStatement stmt = null;
      
      String query = "insert into employee (emp_id, emp_name, emp_no, email, phone, "
            + "job_id, salary, bonus_pct, marriage, mgr_id, hire_date, dept_id) "
            + "values (seq_empid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      try {              
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query);
    	 //? 에 값 대입처리
    	 stmt.setString(1, emp.getEmpName());
    	 stmt.setString(2, emp.getEmpNo());
    	 stmt.setString(3, emp.getEmail());
    	 stmt.setString(4, emp.getPhone());
    	 stmt.setString(5, emp.getJobId());
    	 stmt.setInt(6, emp.getSalary());
    	 stmt.setDouble(7, emp.getBonusPct());
    	 stmt.setString(8, emp.getMarriage());
    	 stmt.setString(9, emp.getMgrId());
    	 stmt.setDate(10, emp.getHireDate());
    	 stmt.setString(11, emp.getDeptId()); 	   	 
    	 
    	 //result = stmt.executeUpdate(query);
    	 result = stmt.executeUpdate();
         if(result > 0) {
            conn.commit();
         }else {
            conn.rollback();
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  close(stmt);
    	  close(conn);
      }
      
      return result;
   }
   
//   System.out.println("4. 직원 정보 수정");
   public int updateEmployee(Employee emp) { //우선 salary, bonus_pct만 바꾸는 걸로 작성했음
      int result = 0;
      Connection conn = getConnection();
      PreparedStatement stmt = null;
      
      String query = "update employee set salary = ?, bonus_pct = ? where emp_id = ?";
      
      try {
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query);      
         
         stmt.setInt(1, emp.getSalary());
         stmt.setDouble(2, emp.getBonusPct());
         stmt.setString(3, emp.getEmpId());
         
         //result = stmt.excuteUpdate(query);
         result = stmt.executeUpdate();
         if(result > 0) {
            conn.commit();
         }else {
            conn.rollback();
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  close(stmt);
    	  close(conn);
      }
      
      return result;
   }
   
//   System.out.println("5. 직원 삭제");
   public int deleteEmployee(String empId) {
      int result = 0;
      Connection conn = getConnection();
      //Statement stmt = null;
      PreparedStatement stmt = null;
      
      String query = "delete from employee where emp_id = ? ";

      try {        
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query);
         
    	 stmt.setString(1, empId);
    	 
    	 result = stmt.executeUpdate();
    	 //result = stmt.executeUpdate(query);
         if(result > 0) {
            conn.commit();
         }else {
            conn.rollback();
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  close(stmt);
    	  close(conn);
      }
      
      return result;
   }
   
//   System.out.println("6. 부서로 (직원) 조회");
   public ArrayList<Employee> selectDept(String deptId) {
      ArrayList<Employee> list = null;
      Connection conn = getConnection();
      //Statement stmt = null;
      PreparedStatement stmt = null;
      ResultSet rset = null;
      
      String query = "select * from employee where dept_id = ?"; 
      
      try {         
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query);
    	 
    	 stmt.setString(1, deptId);
    	 
         //rset = stmt.executeQuery(query);
         rset = stmt.executeQuery();
         if(rset != null) { //select 쿼리문 실행이 성공했다면
            list = new ArrayList<Employee>();
            
            while(rset.next()) { //조회해 온 데이터 행이 존재한다면, 반복 실행
               //각 컬럼 값 꺼내서 객체에 저장 처리
               Employee emp = new Employee();
               
               //결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
               emp.setEmpId(rset.getString("emp_id"));
               emp.setEmpName(rset.getString("emp_name"));
               emp.setEmpNo(rset.getString("emp_no"));
               emp.setEmail(rset.getString("email"));
               emp.setPhone(rset.getString("phone"));
               emp.setJobId(rset.getString("job_id"));
               emp.setHireDate(rset.getDate("hire_date"));
               emp.setSalary(rset.getInt("salary"));
               emp.setBonusPct(rset.getDouble("bonus_pct"));
               emp.setMarriage(rset.getString("marriage"));
               emp.setMgrId(rset.getString("mgr_id"));
               emp.setDeptId(rset.getString("dept_id"));
               
               list.add(emp); //리스트에 저장
               
            }//while end
            
         }//if end
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(stmt);
         close(conn);
      }
      
      return list;
   }
   
//   System.out.println("7. 직급으로 (직원) 조회");
   public ArrayList<Employee> selectJob(String jobId) {
      ArrayList<Employee> list = null;
      Connection conn = getConnection();
     // Statement stmt = null;
      PreparedStatement stmt = null;
      ResultSet rset = null;
      
      String query = "select * from employee where job_id = ?"; 
      
      try {        
         //stmt = conn.createStatement();
    	 stmt = conn.prepareStatement(query);
    	 
    	 stmt.setString(1, jobId);
    	 
    	 //rset = stmt.executeQuery(query);
         rset = stmt.executeQuery();
         if(rset != null) { //select 쿼리문 실행이 성공했다면
            list = new ArrayList<Employee>();
            
            while(rset.next()) { //조회해 온 데이터 행이 존재한다면, 반복 실행
               //각 컬럼 값 꺼내서 객체에 저장 처리
               Employee emp = new Employee();
               
               //결과 매핑 : 컬럼값 꺼내서 객체 필드에 기록 저장하는 것
               emp.setEmpId(rset.getString("emp_id"));
               emp.setEmpName(rset.getString("emp_name"));
               emp.setEmpNo(rset.getString("emp_no"));
               emp.setEmail(rset.getString("email"));
               emp.setPhone(rset.getString("phone"));
               emp.setJobId(rset.getString("job_id"));
               emp.setHireDate(rset.getDate("hire_date"));
               emp.setSalary(rset.getInt("salary"));
               emp.setBonusPct(rset.getDouble("bonus_pct"));
               emp.setMarriage(rset.getString("marriage"));
               emp.setMgrId(rset.getString("mgr_id"));
               emp.setDeptId(rset.getString("dept_id"));
               
               list.add(emp); //리스트에 저장
               
            }//while end
            
         }//if end
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
    	  close(rset);
    	  close(stmt);
    	  close(conn);
      }
      
      return list;
   }
   
}//EmployeeDao end
