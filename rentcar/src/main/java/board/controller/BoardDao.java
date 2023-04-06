package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDto;
import client.Client;
import client.ClientRequestDto;
import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	// C
	public void createBoard(BoardRequestDto boardDto) {
		
		Board board = new Board(boardDto);
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "INSERT INTO Board(client_id, title, content)"
				+ "VALUES(?, ?, ?)";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, board.getClient_id());
			this.pstmt.setString(2, board.getTitle());
			this.pstmt.setString(3, board.getContent());
			
			this.pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// R
	public ArrayList<Board> getAllBoard(){
		ArrayList<Board> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Board ORDER BY Board_code";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Board board = null;
				int board_code = this.rs.getInt(1);
				String client_id = this.rs.getString(2);
				String title = this.rs.getString(3);
				String content = this.rs.getString(4);
				Timestamp post_date = this.rs.getTimestamp(5);
				
				board = new Board(board_code, client_id, title, content, post_date);
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<Integer> getCodeListById(String client_id) {
		ArrayList<Integer> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT board_code FROM board WHERE client_id = ?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, client_id);
			
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int client_code = this.rs.getInt(1);
				
				list.add(client_code);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// U
	public void updateBoard(BoardRequestDto boardDto , String client_id) {
		
		Board board = new Board(boardDto);
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "UPDATE Board SET title=?, content=? WHERE client_id=?";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, board.getTitle());
			this.pstmt.setString(2, board.getContent());
			this.pstmt.setString(3, board.getClient_id());
			
			this.pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// D
	public void deleteBoard(int board_code, String client_id) {
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "DELETE Board WHERE board_code=? and client_id=?";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, board_code);
			this.pstmt.setString(2, client_id);
			
			this.pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
