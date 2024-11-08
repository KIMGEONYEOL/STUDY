package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// 공통 모듈 : 모든 서비스들이 공통으로 이용하는 코드를 가진 클래스
// SingleTone 디자인 패턴 적용함 : 프로그램 구동되는 동안 메모리에 딱 한개만 만들어서
//									여러 서비스가 공유하게 함
// 모든 메서드를 static 으로 작성함
public class JDBCTemplate {
	// 생성자 필요없음
	
//	public static Connection getConnection() {
//		Connection conn = null;
//		
//		try {
//			// 1. 드라이브 등록 : 다운받은 jdbc 드라이브(*.jar) 안의 클래스임
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2. db 연결
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521:xe","c##jdbc","jdbc");
//			// 자동 커밋 비활성화
//			conn.setAutoCommit(false);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//	}
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			// 외부 설정값 가진 파일을 읽어드림
			prop.load(new FileReader("resources/dbsetting.properties"));
			// 읽은 값 확인
			//prop.list(System.out);
			
			// 1. 드라이브 등록 : 다운받은 jdbc 드라이브(*.jar) 안의 클래스임
			Class.forName(prop.getProperty("driver"));
			// 2. db 연결
			conn = DriverManager.getConnection(
					prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			// 자동 커밋 비활성화
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	public static  void close(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) { // null 이 아니고, close 상태가 아닐 때
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt !=null && !stmt.isClosed()) { // null 이 아니고, close 상태가 아닐 때
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset !=null && !rset.isClosed()) { // null 이 아니고, close 상태가 아닐 때
				rset.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) { // null 이 아니고, close 상태가 아닐 때
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) { // null 이 아니고, close 상태가 아닐 때
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
