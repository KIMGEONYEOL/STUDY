package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.exception.MemberException;
import member.model.dto.User;

public class MemberDao {
	
	// 로그인 처리용
	public User selectLogin(Connection conn, User user) throws MemberException {
		User loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from users where userid = ? and userpwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			// 결과매핑 : select 해 온 결과 컬럼값들을 dto 객체의 각 필드에 옮겨 저장하는 것
			if(rset.next()) {
				loginUser = new User();
				loginUser.setUserId(rset.getString("userid"));
				loginUser.setUserPwd(rset.getString("userpwd"));
				loginUser.setUserName(rset.getString("username"));
			} /*
				 * else { // 조회된 회원 정보가 없다면 throw new
				 * MemberException("아이디나 암호가 일치하지 않습니다. 확인하고 다시 이용하세요."); }
				 */
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MemberException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
				
		return loginUser;
	}
}
