package member.controller;

import java.io.IOException;

// javaEE 모듈이 제공
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.exception.MemberException;
import member.model.dto.User;
import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
 @WebServlet("/login") // 아까 설정한 가자 이름(mapping) WEB-INF 에서 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 전송보낸 요청을 받는 메소드임
		
		// request 매개변수 :
		// 사용자 브라우저 뷰페이지 input 으로 입력된 값 도는 쿼리스트링 (?이름=전송값&이름=전송값...)으로 전달된 값을
		// 담아서 서블릿으로 가지고 오는 객체임
		// 전송방식이 get 이면 request head 에 전송접와 전송값이 기록되어 전송됨 => 브라우저 url 상에 보여짐
		// 전송방식이 post 이면 request body 에 전송값이 인코딩되어서 기록되어 전송됨 => url 상에 안 보여짐
		// 서버측의 연결대상 정보도 함께 기록 저장됨, url 상에 보여지는 정보는 모두 request 에 저장됨
		
		// response 매개변수 : 
		// 서비스를 요청한 클라이언트 정보를 가지고 있음 (클라이언트 ip 주소 등)
		// 웹에서는 클라이언트와 서버 간의 (request, response) 가 쌍으로 요청과 응답을 위해서 왔다갔다함
		
		// 로그인 처리용 컨트롤러 ----------------------------------
		// 컨트롤러의 코드 작성 순서와 내용은 비슷함 => 웹의 흐름을 빨리 파악해야 함
		
		// 1. 전송은 값에 한글이 있다면 인코딩 처리함 (전송온 값에 한글이 없다면 생략해도 됨)
		request.setCharacterEncoding("utf-8"); // view 페이지의 문자셋과 맞춰줌
		
		// 2. 전송온 값 꺼내서, 변수 또는 dto 객체에 저장 처리함 : request.getParameter("전송보낸이름") : String
		//String userId = request.getParameter("userid"); // view 의 input 의 name 속성의 이름으로 값을 꺼냄 (오타주의)
		//String userPwd = request.getParameter("userpwd");
		
		// System.out.println("login : " + userId + ", " + userPwd);
		
		
		// 객체에 저장한다면
		User user = new User();
		user.setUserId(request.getParameter("userid"));
		user.setUserPwd(request.getParameter("userpwd"));
		
		System.out.println("login : + "+ user);
		
		// 3. 모델측 서비스 클래스의 메소드를 실행하고 결과받기
		// 메소드 실행시 값 또는 객체를 전달함
		try {
			User loginUser = new MemberService().selectLogin(user);
			
			// 결과값 확인
			System.out.println("loginUser : " + loginUser);
			
			// 4. 받은 결과를 가지고 성공 또는 실패 페이지 내보내기
			if(loginUser != null) { // 성공시
				// 로그인 상태 관리를 위해서 세션 객체를 생성
				HttpSession session = request.getSession(); // == request.getSession(true)
				// 기존의 세션 객체가 있으면 그 객체를 리턴받고, 세션 객체가 없으면 새 세션 객체를 생성함
				// 세션 객체가 새로 만들어지면, 세션ID 가 자동 발급이 됨
				
				System.out.println("생성된 세션 객체의 id : " + session.getId());
				// 자동으로 request 객체에 세션 id 가 기록이 되어서 클라이언트와 서버를 왔다갔다 함
				
				// 세션 객체 안에 로그인한 회원 정보를 기록 저장할 수도 있음. (뷰 페이지에서 꺼내서 사용함)
				session.setAttribute("loginUser", loginUser);
				
				// 로그인 성공시 내보낼 뷰 페이지 지정 : 뷰만 내보내는 경우
				response.sendRedirect("index.jsp"); //"/first/index.jsp" 도 가능
				
			}else { //실패시
				// views/common/error.jsp 를 내보냄 + 오류 메세지(에러 이유)도 함께 전송 보냄
				
				// 내보낼 뷰 페이지와 같이 보낼 데이터가 있을 때는, RequestDispatcher 클래스를 사용함
				// => 상대경로만 사용할 수 있음
				// 모든 컨트롤러(서블릿)의 실행 위치는 root (content directory : webapp) 에서 실행되고 있음
				
				// 내보낼 뷰 지정함 : 상대경로만 사용 가능함
				RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
				// 뷰와 함께 내보낼 데이터 처리 : request 객체에 저장함 => Map 구조임 (key, value) 쌍으로 저장
				// setAttribute("key", value object); 사용함
				request.setAttribute("message", "로그인 실패! 아이디와 암호를 다시 확인해주세요.");
				
				// 로그인을 요청한 클라이언트로 내보냄
				view.forward(request, response);
				
			}
			
		} catch (MemberException e) {
			// 실제 자바 에러가 발생한 경우 또는
			e.printStackTrace();
//			// 내보낼 뷰 지정함 : 상대경로만 사용 가능함
//			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
//			// 뷰와 함께 내보낼 데이터 처리 : request 객체에 저장함 => Map 구조임 (key, value) 쌍으로 저장
//			// setAttribute("key", value object); 사용함
//			request.setAttribute("message", "로그인 실패! " + e.getMessage());
//			
//			// 로그인을 요청한 클라이언트로 내보냄
//			view.forward(request, response);
			// 로그 분석을 위해서 로그 파일을 만들고, 로그 파일에 로그로 에러정보를 기록 처리
			
		}

	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 전송보낸 요청을 받는 메소드임
		doGet(request, response); // doGet() 메소드 쪽으로 전송온 정보를 넘김
	}

}
