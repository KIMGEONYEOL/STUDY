package org.myweb.first.member.model.service;

import java.util.ArrayList;

import org.myweb.first.member.model.dto.Member;
import org.myweb.first.member.model.dto.User;

// Spring 에서는 비즈니스 모델에 서비스 클래스는 인터페이스로 만들도록 정해져 있음.
// 인터페이스는 추상메소드만 멤버로 가지는 추상클래스이다.
// 작성되는 추상메소드는 기본 public abstract 반환형 메소드명(자료형 매개변수, ...);
// public abstract 표기 생략 가능 => 상속받는 후손이 오버라이딩할 때 반드시 public 표기해야 함.
public interface MemberService {
	User selectLogin(User user);
	Member selectMember(String userid);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userId);
	int selectCheckId(String userId);
	ArrayList<Member> selectList();
	
}
