package db.controller;

import java.util.ArrayList;

import db.exception.DbException;
import dbdao.DbDao;
import db.model.dto.Db;
import db.model.service.DbService;

// MVC 패턴 : view(사용자 화면;UI) -> 요청 -> Controller 가 받음 -> service model 로 전달함
// -> service model 은 Connection 연결 요청 
// -> dao model 로 Connection 과 전달값을 전달 -> dao model 이 결과 리턴 -> service model 이 결과 받음, 트랜젝션 관리함 
// ->  controller 로 넘김 -> controller 가 받아서 view 로 리턴함 -> view 가 받아서 출력
// view -> controller -> service -> dao
public class DbController {
	private DbService dservice = new DbService();
	
	public DbController() throws DbException {
		dservice = new DbService();
	}
	
}