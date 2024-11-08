package dbdao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import db.exception.DbException;
import db.model.dto.Db;
import db.exception.DbException;


public class DbDao {
	private Properties prop = new Properties();
	

	public DbDao() throws DbException {
		try {
			prop.load(new FileReader("resources/query.properties"));
			} catch (Exception e) {
				throw new DbException(e.getMessage());
			}
	}	
	public int insertDb(Connection conn, Db db) throws DbException {
	      int result = 0; //처리된 행 갯수
	      PreparedStatement stmt = null;
	      
//	      String query = "insert into employee (emp_id, emp_name, emp_no, email, phone, "
//	            + "job_id, salary, bonus_pct, marriage, mgr_id, hire_date, dept_id) "
//	            + "values (seq_empid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      	String query = prop.getProperty("insert");
	    
	      
	      try {              
	         //stmt = conn.createStatement();
	    	 stmt = conn.prepareStatement(query);
	    	 //? 에 값 대입처리
	    	 stmt.setString(1, db.getTitle());
	    	 stmt.setString(2, db.getContributor());
	    	 stmt.setString(3, db.getDescription());
	    	 stmt.setString(4, db.getEventSite());
	    	 stmt.setString(5, db.getGenre());
	    	 stmt.setString(6, db.getContactPoint());
	    	 stmt.setString(7, db.getUrl());
	    
	   	 
	    	 
	    	 //result = stmt.executeUpdate(query);
	    	 result = stmt.executeUpdate();
	      } catch (Exception e) {
	    	  throw new DbException(e.getMessage());
	      } finally {
	    	  close(stmt);
	      }
	      
	      return result;
	   }
	   
}
