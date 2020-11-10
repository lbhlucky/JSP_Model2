package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

// Action 클래스로부터 요청받은 작업에 대한 데이터 등을 전달받아
// Model(DAO클래스)을 통해 실제 작업 처리를 요청하고
// 처리 결과를 리턴받아 해당 결과에 대한 판별을 통해
// 결과값으로 처리할 데이터를 리턴
public class BoardWriteProService {
	
	// 글 쓰기(등록) 요청을 처리하기 위한 refistArticle() 메서드 정의
	// => 파라미터 : 게시물 정보(BoardBean)
	// => 리턴타입 : boolean(isWriteSuccess)
	public boolean registArticle(BoardBean boardBean) {
		System.out.println("BoardWriteProService! - registArticle()");
		
		boolean isWriteSuccess = false;	// 글 등록 성공 여부를 저장
		
		// DB 작업을 위한 비즈니스 로직 수행 준비
		// 1(공통). DB 작업에 필요한 Connection 객체 가져오기
		Connection con = JdbcUtil.getConnection();
		
		// 2(공통). DB 작업에 필요한 DAO 객체 가져오기
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		// 3(공통). 가져온 Connection 객체를 DAO 객체에 전달
		boardDAO.setConnection(con);
		
		// 4. BoardDAO 객체의 insertArticle() 메서드를 호출하여 글 등록 처리
		// => 파라미터 : BoardBean, 리턴타입 : int(insertCount)
		int insertCount = boardDAO.insertArticle(boardBean);
		
		// 5. 리턴받은 글 등록 결과를 판별
		// => true 일 경우 commit, false일 경우 rollback 작업 수행
		// => 0보다 클 경우 commit, 0일 경우 rollback
		if(insertCount > 0) {
			JdbcUtil.commit(con);	// DB Commit 작업 수행
			isWriteSuccess = true;	
		//  => Action 클래스에 전달(리턴)할 작업 수행 결과를 true로 설정
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 6(공통). 사용이 완료된 Connection 객체 반환
		JdbcUtil.close(con);
		
		// 7. 글 등록 성공 여부 리턴 => BoardWriteProAction 클래스로 전달
		return isWriteSuccess;
	}

}
