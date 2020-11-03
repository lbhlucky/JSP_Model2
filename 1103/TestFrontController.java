

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.me")
public class TestFrontController extends HttpServlet {

	// 서블릿 클래스의 doGet(),doPost()메서드는 각 요청에 따라 자동으로 호출됨
	// => 이 때, 동일한 동작을 처리하더라도 호출되는 메서드가 다르면
	//	  작성해야하는 코드가 중복될 수 있다.
	// 	 따라서, 두  요청 방식에대한 공통작업을 수행할 별도의 메서드를 정의하여
	//   doGet
	// GET 방식 요청을 처리하기 위해 자동으로 호출되는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doGet()");

		doProcess(request, response);
	}

	// POST 방식 요청을 처리하기 위해 자동으로 호출되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doPost()");

		doProcess(request, response);
	}

	// GET방식과 POST 방시기 요청을 모두 처리하기 위한 doProcess() 메서드 정의
	// => doGet() 메서드와 doPost() 메서드에서 doProcess()메서드 호출
	//	  메서드 파라미터로 request, response 객체를 전달해야함
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doProcess()");

		// POST 방식에서의 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 서블릿으로 요청된 URL(xxxxx.me)주소를 판별하기 위한 작업
		// 1. request 객체의 getRequestURI() 메서드를 호출하여
		//    전체 URL 중에서 프로토콜://주소:포트번호 부분을 제외한 나머지
		// 	  ex) http://localhost:8080/Test2/LoginPro2.me일 경우
		//			"/Test2/LoginPro2.me" 추출됨
		String requestURI = request.getRequestURI();
		System.out.println("requestURI : " +requestURI);
		
		// 2. request 객체의 getContextPath() 메서드 호출하여
		// 	   전체 URL 중에서 프로젝트 경로(프로젝트 명) 추출
		//	 	  ex) http://localhost:8080/Test2/LoginPro2.me일 경우
		//			"/Test2" 추출됨
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " +contextPath);
		
		// 3. URL 중에서 서블릿 주소(LoginPro.me)부분 추출하기 위해
		//	  requestURI 와 ContextPath를 사용하여 문자열 조작 수행
		//	  => 실제 주소 매핑에 사용할 서블릿 주소 추출 과정
		//	  => RequestURI 추출 결과에서 ContextPath 문자열 길이를
		//		 시작 인덱스로 사용하여 문자열 추출(substring())
		//	 	  ex) http://localhost:8080/Test2/LoginPro2.me일 경우 "/Test2"의 길이가 6이므로
		//			"/LoginPro2.me" 의 첫 인덱스인 6부터 추출이 가능
//		String command = requestURI.substring(contextPath.length());
//		System.out.println("command : " + command);
		
		// 위의 1 ~3번 과정을 하나의 메서드로 제공 : getServletPath()
		String command = requestURI.substring(contextPath.length());
		System.out.println("command : " + command);
		
		
		// id, password 파리마터 값 가져와서 출력
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		System.out.println("아이디 : " +id);
//		System.out.println("패스워드 : " +password);
	}
	
}
