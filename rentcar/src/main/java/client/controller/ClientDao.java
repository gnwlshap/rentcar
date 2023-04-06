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
		
		String sql = "SELECT * FROM Client ORDER BY sign_date";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Client client = null;
				String client_id = this.rs.getString(1);
				String client_pw = this.rs.getString(2);
//				Timestamp sign_date = this.rs.getTimestamp(3);
				String name = this.rs.getString(4);
				String phone = this.rs.getString(5);
				
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
	// U
	// D
}
