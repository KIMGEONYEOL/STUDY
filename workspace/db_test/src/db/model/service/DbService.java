package db.model.service;

//JDBCTemplate 이 가진 모든 static 메서드를 import 해라.
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import db.exception.DbException;
import db.model.dto.Db;
import dbdao.DbDao;

// Connection 관리와 트랜젝션 관리가 주 목적인 서비스 모델임
public class DbService {
	private DbDao dbdao;
	
	public DbService() throws DbException{
		dbdao = new DbDao();
	}
		
	public int insertEmployee(Db emp) throws DbException {
		Connection conn = getConnection();
		int result = dbdao.insertDb(conn, emp);
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	
}














