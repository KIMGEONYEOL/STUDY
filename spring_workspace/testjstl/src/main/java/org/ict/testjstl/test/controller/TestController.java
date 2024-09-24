package org.ict.testjstl.test.controller;

import org.ict.testjstl.member.model.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	// 요청시 해당 뷰 페이지로 이동 처리용 메소드
	@RequestMapping("testel.do")
	public String moveELPage(Model model) {
		// jsp 에서 el 사용을 위한 샘플 데이터 준비함
		// 원래는 model 쪽으로 요청 전달해서 데이터베이스에서 조회한 리턴 결과를 가진 객체임 => 이 단계는 생략
		User user = new User("user999", "pass999", "홍박사");
		// 뷰로 보내서 뷰페이지에서 출력시킬 정보는 Model 객체에 저장해서 뷰와 내보냄
		model.addAttribute("resultUser", user); // request.setAttribute("저장이름", 저장객체) 와 같음
		return "test/testEL";
	}
	
	@RequestMapping("testcore.do")
	public String moveCorePage() {
		return "test/testCore";
	}
	
	@RequestMapping("testfmt.do")
	public String moveFmtPage() {
		return "test/testFmt";
	}
	
	@RequestMapping("testfn.do")
	public String moveFnPage() {
		return "test/testFunction";
	}
	
	@RequestMapping("moveFmt.do")
	public String moveLinkPage(@RequestParam("no") int no,
			@RequestParam("name") String name, @RequestParam("page") int page) {
		// @RequestParam("page") == int page = Integer.parseInt(request.getParameter("page"));
		logger.info("moveFmt.do : " + no + ", " + name + ", " + page); // 전송온 파라메타 확인
				return "test/testFmt";
	}
	
	
	
	
	
	
}
