package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.exception.MemberException;
import member.model.dao.MemberDao;
import member.model.dto.User;

public class MemberService {
   private MemberDao mdao = new MemberDao();
   
   public User selectLogin(User user) throws MemberException {
      Connection conn = getConnection();
      User loginUser = mdao.selectLogin(conn, user);
      close(conn);
      return loginUser;
   }//selectLogin(User user) end

}//MemberService end
