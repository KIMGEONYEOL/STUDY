package com.ex.tiggle.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.member.model.dao.OrganizerDao;

@Service("organizerService")
public class OrganizerServiceImpl implements OrganizerService {
	@Autowired
	private OrganizerDao organizerDao; 
} // OrganizerService end
