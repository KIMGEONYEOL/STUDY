package org.myweb.first.board.controller;

import org.myweb.first.board.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
}
