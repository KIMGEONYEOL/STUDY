package org.myweb.first.notice.model.service;

import org.myweb.first.notice.model.dao.NoticeDao;
import org.myweb.first.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Notice selectLast() {
		return noticeDao.selectLast();
	}
	
}
