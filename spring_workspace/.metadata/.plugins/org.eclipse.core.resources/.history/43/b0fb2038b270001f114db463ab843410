package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.exception.MemberException;
import member.model.dto.User;

public class MemberDao {
	
	
	// 로그인 처리용
	public User selectLogin(SqlSession session, User user) throws MemberException {
//		return session.selectOne("selectLogin", user);
		// 예외 발생처리를 추가한다면
		User loginUser = null;
		
		try {
			loginUser = session.selectOne("selectLogin", user);
		} catch (Exception e) {
			throw new MemberException(e.getMessage());
		}
		
		return loginUser;
	}
}
