package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"webdb","webdb");
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "insert into author values(seq_author_id.nextval, ?, ?)"; //쿼리문 마침표는 생략
			pstmt= conn.prepareStatement(query); //쿼리로 만들기
			
			//자료형에 맞춰서 작성
			pstmt.setString(1, "류예나");
			pstmt.setNString(2, "경기 고양");
			
			//insert into author values(seq_author_id.nextval, '이문열', '경북 영양');
			int count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 처리되었습니다.");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        /*
		         if (rs != null) {
		            rs.close();
		        }
		        */              
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}


	}

}
