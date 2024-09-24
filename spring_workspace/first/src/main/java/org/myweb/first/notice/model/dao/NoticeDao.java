package org.myweb.first.notice.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.myweb.first.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// ajax 테스트용 : 마지막 등록된 최근 공지글 한 개 조회용 메소드
	public Notice selectLast() {
		return sqlSessionTemplate.selectOne("noticeMapper.selectLast");
	}
	
	
}
