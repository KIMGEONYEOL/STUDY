package org.myweb.first.notice.model.service;

import org.myweb.first.notice.model.dto.Notice;

public interface NoticeService {
	Notice selectLast();
}
