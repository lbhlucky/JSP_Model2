package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



// DB 관련 기본 기능(연결, 자원반환, commit, rollback 등)을 담당하는 클래스
// => 모든 메서드는 JdbcUtil 클래스의 인스턴스 생성 없이도 접근하도록
//	  static 메서드로 정의
public class JdbcUtil {

	// 1. DBCP를 활용한 Connection객체를 가져오는 getConncetion() 메서드 정의
	// => 파라미터 : 없음, 리턴타입 : Connection
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			
			DataSource ds =  (DataSource)envCtx.lookup("jdbc/MySQL");

			con = ds.getConnection();
			
			// JDBC를 통한 DB 작업에 대한 Auto Commit 기능 해제
			// => 트랜잭션 개념을 적용하기 위함
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Connection 객체 리턴
		return con;
	}
	
	// 2. Connection. PrepareStatement ResultSet 객체 반환하는 close() 메서드
	// => 메서드 오버로딩 활용
	// => 파라미터 : 각각의 객체, 리턴타입 : 없음
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement p) {
		try {
			p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3. 트랜잭션 처리를 위한 commit(), rollback() 메서드 정의
	// => Auto Commit 기능이 해제되어 있으므로
	//	  작업 성공시 commit() 메서드에서 Connection 객체의 commit() 메서드를..
	//		   실패시 rollbact() 메서드에서 Connection 객체의 rollback() 메서드를 수행
	// => 파라미터 : Conncetion 객체, 리턴타입 : 없음
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
