package com.ex.tiggle.organizer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.organizer.model.dao.OrganizerDao;

@Service("organizerService")
public class OrganizerServiceImpl {
	@Autowired
	private OrganizerDao organizerDao;
} // OrganizerService end
