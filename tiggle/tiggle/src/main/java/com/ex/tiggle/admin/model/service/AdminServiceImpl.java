package com.ex.tiggle.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.admin.model.dao.AdminDao;

@Service("adminService")
//스프링에서는 서비스 인터페이스를 상속받은 후손클래스에 작성하도록 정해놓음.
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;
} // AdminService end
