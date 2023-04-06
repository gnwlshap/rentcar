package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import client.Client;
import client.ClientRequestDto;
import util.DBManager;

public class ClientDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ClientDao() {}
	private static ClientDao instance = new ClientDao();
	public static ClientDao getInstance() {
		return instance;
	}
	// C
	public void createClient(ClientRequestDto clientDto) {
		
		Client client = new Client(clientDto);
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "INSERT INTO Client(client_id, client_pw, name, phone)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, client.getClient_id());
			this.pstmt.setString(2, client.getClient_pw());
//			this.pstmt.setTimestamp(3, client.getSign_date());
			this.pstmt.setString(3, client.getName());
			this.pstmt.setString(4, client.getPhone());
			
			this.pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// R
	
	public ArrayList<Client> getAllClient(){
		ArrayList<Client> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Client ORDER BY client_code";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Client client = null;
				int client_code = this.rs.getInt(1);
				String client_id = this.rs.getString(2);
				String client_pw = this.rs.getString(3);
//				Timestamp sign_date = this.rs.getTimestamp(4);
				String name = this.rs.getString(5);
				String phone = this.rs.getString(6);
				
				client = new Client(client_id, client_pw, name, phone);
				list.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public Client getClientByCode(int client_code) {
		Client client = null;
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Client WHERE client_code = ?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, client_code);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String client_id = this.rs.getString(2);
				String client_pw = this.rs.getString(3);
				Timestamp sign_date = this.rs.getTimestamp(4);
				String name = this.rs.getString(5);
				String phone = this.rs.getString(6);
				
				client = new Client(client_code, client_id, client_pw, sign_date, name, phone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return client;
	}
	
	public int getCodeById(String client_id) {
		int client_code = -1;
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT client_code FROM Client WHERE client_id = ?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, client_id);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next())
				client_code = this.rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return client_code;
	}
	// U
	
	public void updateClient(ClientRequestDto clientDto , int client_code) {
		
		Client client = new Client(clientDto);
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "UPDATE Client SET client_id=?, client_pw=?, name=?, phone=? WHERE client_code=?";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, client.getClient_id());
			this.pstmt.setString(2, client.getClient_pw());
			this.pstmt.setString(3, client.getName());
			this.pstmt.setString(4, client.getPhone());
			this.pstmt.setInt(5, client_code);
			
			this.pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// D
	
	public void deleteClient(int client_code) {
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "DELETE Client WHERE client_code=?";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, client_code);
			
			this.pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
