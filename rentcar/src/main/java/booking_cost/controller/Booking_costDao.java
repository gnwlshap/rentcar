package booking_cost.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import booking_cost.Booking_cost;
import util.DBManager;

public class Booking_costDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Booking_costDao() {}
	private static Booking_costDao instance = new Booking_costDao();
	public static Booking_costDao getInstance() {
		return instance;
	}

	public ArrayList<Booking_cost> getAllBookingCost(){
		ArrayList<Booking_cost> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Booking_cost";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Booking_cost booking_cost = null;
				String vehicle_id = this.rs.getString(1);
				String client_id = this.rs.getString(2);
				String venue_id = this.rs.getString(3);
				Timestamp pick_date = this.rs.getTimestamp(4);
				Timestamp return_date = this.rs.getTimestamp(5);
				int rent_hour = this.rs.getInt(6);
				int total_cost = this.rs.getInt(7);
				
				booking_cost = new Booking_cost(vehicle_id, client_id, venue_id, pick_date, return_date, rent_hour, total_cost);
				list.add(booking_cost);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
