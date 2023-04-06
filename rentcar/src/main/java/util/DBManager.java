package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnectionFromMySQL() {
		Connection conn = null;
		
		
		try {
//			Timestamp now = new Timestamp(System.currentTimeMillis());
//			System.out.println(now);
			
//			Date date = new Date(2023-1900, 4+1, 4, 18, 10, 1);
//			Timestamp now = new Timestamp(date.getTime());
			
			// JNDI
			// Java Naming and Directory Interface
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/test");
			conn = source.getConnection();
			
//			System.out.println("연결");
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("연결실패");
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
