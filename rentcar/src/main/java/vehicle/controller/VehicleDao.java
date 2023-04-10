package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;
import vehicle.Vehicle;

public class VehicleDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VehicleDao() {}
	private static VehicleDao instance = new VehicleDao();
	public static VehicleDao getInstance() {
		return instance;
	}
	
	// R
	public ArrayList<Vehicle> getAllVehicle(){
		ArrayList<Vehicle> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Vehicle ORDER BY hour_rate";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Vehicle vehicle = null;
				String vehicle_id = this.rs.getString(1);
				String venue_id = this.rs.getString(2);
//				Timestamp regist_date = this.rs.getTimestamp(3);
				int hour_rate = this.rs.getInt(4);
				String vehicle_name = this.rs.getString(5);
				
				vehicle = new Vehicle(hour_rate, vehicle_id, venue_id, vehicle_name);
				list.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<Vehicle> getVehicleByVenue(String venue){
		ArrayList<Vehicle> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Vehicle WHERE venue_id=? GROUP BY vehicle_name ORDER BY hour_rate, vehicle_name";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, venue);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Vehicle vehicle = null;
				String vehicle_id = this.rs.getString(1);
				String venue_id = this.rs.getString(2);
//				Timestamp regist_date = this.rs.getTimestamp(3);
				int hour_rate = this.rs.getInt(4);
				String vehicle_name = this.rs.getString(5);
				
				vehicle = new Vehicle(hour_rate, vehicle_id, venue_id, vehicle_name);
				list.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	public ArrayList<Vehicle> getRentableVehicle_id(String return_date, String pick_date, String venueId){
		ArrayList<Vehicle> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM vehicle WHERE vehicle_id NOT IN (SELECT vehicle_id FROM booking WHERE pick_date < ? AND return_date > ?) AND venue_id =? GROUP BY vehicle_name ORDER BY hour_rate, vehicle_name";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, return_date);
			this.pstmt.setString(2, pick_date);
			this.pstmt.setString(3, venueId);
			
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Vehicle vehicle = null;
				String vehicle_id = this.rs.getString(1);
				String venue_id = this.rs.getString(2);
//				Timestamp regist_date = this.rs.getTimestamp(3);
				int hour_rate = this.rs.getInt(4);
				String vehicle_name = this.rs.getString(5);
				
				vehicle = new Vehicle(hour_rate, vehicle_id, venue_id, vehicle_name);
				list.add(vehicle);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
