package org.myweb.first.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	// 공지 제목 검색
	public ArrayList<Notice> selectSearchTitle(String keyword){
		List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectSearchTitleKeyword", keyword);
		return (ArrayList<Notice>)list;
	}
	
	// 신규 공지 등록
	public int insertNotice(Notice notice) {
		return sqlSessionTemplate.insert("noticeMapper.insertNotice", notice);
	}
	
}