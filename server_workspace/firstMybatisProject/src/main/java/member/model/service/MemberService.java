package member.model.service;

import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.exception.MemberException;
import member.model.dao.MemberDao;
import member.model.dto.User;

public class MemberService {
   private MemberDao mdao = new MemberDao();
   // 마이바티스가 제공하는 Connection, Transaction, Execution 을 담당하는 클래스
   private SqlSession session;
   
   private SqlSession getSession() {
	   try {
		/* 마이바티스 설정 파일 mybatis/mybatis-config.xml 의 내용을 읽어 들여서
		 * db 연결처리함, PreparedStatement 객체도 생성 처리함
		 * 
		 * */
//		 String resource = "mybatis/mybatis-config.xml";
//		 InputStream inputStream = Resources.getResourceAsStream(resource);
//		 SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//		 SqlSessionFactory factory = builder.build(inputStream);
//		 session = factory.openSession(false);
		 session = new SqlSessionFactoryBuilder().build(
				 Resources.getResourceAsReader("mybatis/mybatis-config.xml")).openSession(false);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	  return session;
   }
   
   
   public User selectLogin(User user) throws MemberException {
      session = getSession();
      User loginUser = mdao.selectLogin(session, user);
      session.close();
      return loginUser;
   }//selectLogin(User user) end

}//MemberService end
