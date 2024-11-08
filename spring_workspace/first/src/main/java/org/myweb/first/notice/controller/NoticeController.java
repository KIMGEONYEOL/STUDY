package org.myweb.first.notice.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.myweb.first.common.FileNameChange;
import org.myweb.first.member.model.dto.Member;
import org.myweb.first.notice.model.dto.Notice;
import org.myweb.first.notice.model.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;
	
	// 뷰 페이지 이동 처리용 메소드 ---------------------------------
	// 새 공지글 등록 페이지로 이동 처리용
	@RequestMapping("moveWrite.do")
	public String moveWritePage() {
		return "notice/noticeWriteForm";
	}
	
	
	
	
	// 요청 처리용 메소드 ------------------------------------------
	@RequestMapping(value = "ntop3.do", method = RequestMethod.POST)
	@ResponseBody
	public String noticeNewTop3Method(HttpServletResponse response) throws UnsupportedEncodingException {
		// ajax 요청시 리턴방법은 여러가지가 있음 (문자열, json 객체 등)
		// response 객체 이용시 2 가지 중 선택 가능
		// 방법 1 : 출력스트림을 따로 생성해서 응답하는 방법 -> public void 로 지정
		// 방법 2 : 뷰 리졸버로 리턴해서 등록된 JSONView 가 내보내는 방법 (servlet-context.xml 에 등록)
		// public String 으로 지정

		// 최근 등록된 공지글 3개 조회 요청함
		ArrayList<Notice> list = noticeService.selectTop3();

		// 내보낼 값에 대해 response 에 mimiType 설정
		response.setContentType("application/json; charset=utf-8");

		// 리턴된 list 를 json 배열에 옮겨 기록하기
		JSONArray jarr = new JSONArray();

		for (Notice notice : list) {
			// notice 값들을 저장할 json 객체 생성
			JSONObject job = new JSONObject(); // org.json.simple.JSONObject 임포트함

			job.put("no", notice.getNoticeNo());
			// 문자열 값에 한글이 포함되어 있다면, 반드시 인코딩해서 저장해야 함
			// java.net.URLEncoder 의 static 메소드인 encode('문자열값', '문자셋')
			job.put("title", URLEncoder.encode(notice.getNoticeTitle(), "utf-8"));
		
			// 날짜데이터는 반드시 문자열로 바꿔서 저장할 것 : 날짜 그대로 저장하면 view 에서 json 전체 출력 안 됨
			job.put("date", notice.getNoticeDate().toString());

			jarr.add(job); // 배열에 추가
		} // for each

		// 전송용 json 객체 생성함
		JSONObject sendJson = new JSONObject();
		// 전송용 json 에 jarr 을 저장함
		sendJson.put("nlist", jarr);

		return sendJson.toJSONString();
	}
	
	// 공지글 상세 내용보기 요청 처리용
	@RequestMapping("ndetail.do")
	public ModelAndView noticeDetailMethod(
			@RequestParam("no") int noticeNo, 
			ModelAndView mv, HttpSession session) {
		// 관리자용 상세보기 페이지와 일반회원 상세보기 페이지를 구분해서 응답 처리함
		// 관리자인지 확인하기 위해 session 매개변수 추가함
		
		Notice notice = noticeService.selectNotice(noticeNo);
		
		// 조회수 1 증가 처리
		noticeService.updateAddReadCount(noticeNo);
		
		if(notice != null ) { // 조회해온 해당 정보의 내용이 있다면
			mv.addObject("notice", notice);
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			if(loginUser != null && loginUser.getAdminYN().equals("Y")) {
				mv.setViewName("notice/noticeAdminDetailView");
			}else {
				mv.setViewName("notice/noticeDetailView");
			}
				
		}else {
			mv.addObject("message", noticeNo + "번 공지글 상세보기 요청 실패!");
			mv.setViewName("common/error");
		}
		
		return mv;
	}
	
	// 공지사항 전체 목록보기 요청 처리용 (페이징 처리 : 한 페이지에 10개씩 출력 처리)
	@RequestMapping("nlist.do")
	public ModelAndView noticeListMethod(ModelAndView mv) {
		
		// 서비스로 목록 조회 요청하고 결과 받기
		ArrayList<Notice> list = noticeService.selectList();
		
		if(list != null && list.size() > 0 ) {
			mv.addObject("list", list);
			mv.setViewName("notice/noticeListView");
		}else {
			mv.addObject("message", "목록 조회 실패!");
			mv.setViewName("common/error");
		}
		
		return mv; 
	}
	
	// 새 공지글 등록 요청 처리용 (파일 업로드 기능 추가)
	@RequestMapping(value="ninsert.do", method=RequestMethod.POST)
	public String noticeInsertMethod(Notice notice, Model model,
			@RequestParam(name="ofile", required=false) MultipartFile mfile,
			HttpServletRequest request) {
		logger.info("ninsert.do : " + notice);
		
		// 공지사항 첨부파일 저장 폴더를 경로로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");
		
		// 첨부파일이 있을 때
		if(!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			String renameFileName = null;
			
			// 저장폴더에는 변경된 이름을 저장 처리함
			// 파일 이름 바꾸기 : 년월일시분초.확장자
			if(fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기
				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				// 바뀐 파일명을 확인
				logger.info("첨부파일명 확인 : " + renameFileName);
				
				try {
					// 저장 폴더에 파일명 바꾸어 저장하기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일 저장 실패!");
					return "common/error";
				}
				
			}// 파일명 바꾸기
			
			// notice 객체에 첨부파일 정보 저장 처리
			notice.setOriginalFilePath(fileName);
			notice.setRenameFilePath(renameFileName);
			
		} // 첨부파일이 있을 때
		
		if(noticeService.insertNotice(notice) > 0) {
			// 새 공지글 등록 성공시 목록 페이지 내보내기 요청
			return "redirect:nlist.do";
		}else {
			model.addAttribute("massage", "새 공지글 등록 실패!");
			return "common/error";
		}
	}
	
		// 첨부파일 다운로드 요청 처리용 메소드
		// 공통모듈로 작성된 FileDownloadView 클래스를 이용함
		@RequestMapping("nfdown.do")
		public ModelAndView filedownMethod(
				HttpServletRequest request, ModelAndView mv,
				@RequestParam("ofile") String originalFileName,
				@RequestParam("rfile") String renameFileName) {
						
			// 공지사항 첨부파일 저장 폴더 경로 지정
			String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

			// 저장 폴더에서 읽을 파일에 대한 File 객체 생성
			File downFile = new File(savePath + "\\" + renameFileName);

			//파일 다운시 브라우저로 내보낼 원래 파일에 대한 File 객체 생성함
			File originFile = new File(originalFileName);
			
			// 파일 다운 처리용 뷰 클래스 id 명과 다운로드할 File. 객체를 ModelAndView 에 담아서 리턴함
			mv.setViewName("filedown");	// 뷰 클래스의 id 명 기입
			mv.addObject("originFile", originFile);
			mv.addObject("renameFile", downFile);
			
			return mv;
		}
}












