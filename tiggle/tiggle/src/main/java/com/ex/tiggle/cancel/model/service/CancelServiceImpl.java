package com.ex.tiggle.cancel.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.tiggle.cancel.model.dao.CancelDao;

@Service("cancelService")
public class CancelServiceImpl implements CancelService {
	@Autowired
	private CancelDao cancelDao;
} // CancelService end
