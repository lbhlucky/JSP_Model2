

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doGet()");
		
		// id, password 파리마터 값 가져와서 출력
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("아이디 : " +id);
		System.out.println("패스워드 : " +password);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet-doPost()");
		
		// POST 방식에서의 한글처리
		request.setCharacterEncoding("utf-8");
		
		// id, password 파리마터 값 가져와서 출력
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("아이디 : " +id);
		System.out.println("패스워드 : " +password);
				
	}
	
	

}
