package dao;

import java.sql.Connection;

import vo.BoardBean;

public class BoardDAO {
	/*
	 * 싱글톤 디자인 패턴을 활용한 BoardDAO 인스턴스 작업
	 * 1. 외부에서 인스턴스 생성이 불가능하도록 생성자 호출을 막기위해
	 *    private 접근 제한자 적용하여 생성자 정의
	 *    
	 * 2. 직접 DAO 클래스의 인스턴스를 생성하여 멤버변수(instance)로 저장
	 *    => 접근제한자 private로 설정하여 외부에서 접근 불가능하도록 지정
	 *    => 생성자를 리턴하는 static 메서드 getInstance() 에서
	 *       멤버변수에 접근할 수 있도록 static멤버변수로 선언
	 *    
	 * 3. 생정된 인스턴스를 외부로 리턴하기 위해 Getter 메서드 정의
	 *    => 파라미터 : 없음, 리턴타입 : BoardDAO
	 *    => 외부에서 인스턴스 생성 없이도 호출 가능하도록 static 메서드로 정의
	 * 
	 */
	
	private void BoardDAO() {};
	
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// ==================================================================================
	
	Connection con;		// Connection 객체를 전달받아 저장할 멤버변수

	// 외부(Service 클래스)로 부터 Connection 객체를 전달받아
	// 멤버변수에 저장하는 setConnection() 메서드 정의
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 글 등록 작업
	public int insertArticle(BoardBean boardBean) {
		int insertCount = 1;
		System.out.println("BoardDAO - insertArticle()");
		return insertCount;
	}
	
	
	
}
