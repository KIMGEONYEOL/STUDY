package common;

import java.io.InputStreamReader;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCTemplate {
   //db.properties 파일 읽어와서 값을 적용
   //싱글톤 디자인 패턴 사용함 => 모든 메서드에 static 적용 ( static 메모리에 할당)
   //static 정적 메모리 : 프로그램 실행시 딱 한번 자동 기록함, 프로그램 구동 내내 한개만 존재함, 공유
   //static 메서드 내에는 this 참조변수가 없다.
   //싱글턴에서는 생성자 필요 x => 동적 메모리에 할당할 것이 없고 정적과 동적 간의 주소 참조 없음.
   
   // static 메서드 내에서는 this 참조를 못하므로, 별도의 파일 읽기용 내부클래스 작성해서 사용하도록 함.
   //내부(inner, Nested) 클래스는 외부클래스의 멤버로 보면됨 => static 사용할 수 있음
   // static 메소드 내에서는 멤버(필드, 내부클래스)를 사용하려면, 같은 static 이여야 함.
   private static class ReadProperties {
      private Properties prop;
      
      public ReadProperties() {
         prop = new Properties();
         
         try {
            //서버 엔진을 통해서 파일을 읽어야 하므로 , 바로 filereader 로 파일을 읽을 수 없음
            //웹은 서버 클라이언트 방식의 네트워크 사용
            //네트워크 입출력은 바이트 스트림만 사용 가능
            //대상 파일을 바이트스크림(inputstream)으로 읽어서, 텍스트 파일이므로 reader 로 바꿈.
            prop.load(new InputStreamReader(this.getClass().getResourceAsStream("db.properties")));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      public Properties getProp() {
         
         return prop;
      }
   } // 내부클래스
   
   public static Connection getConnection() {
      Connection conn = null;
      
      try {
         Properties prop = new ReadProperties().getProp();
         
         Class.forName(prop.getProperty("driver"));
         conn = DriverManager.getConnection(prop.getProperty("url"), 
               prop.getProperty("user"), prop.getProperty("passwd"));
         
      }catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
   
   public static void close(ResultSet rset) {
      try {
         if(rset != null && !rset.isClosed()) {
            rset.close();
         }
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   
   public static void close(Statement stmt) { 
      try {
         if(stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void commit(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.commit();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void rollback(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.rollback();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   
   
   
   

}