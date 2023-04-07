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
		
		String sql = "SELECT * FROM Vehicle ORDER BY regist_date";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Vehicle vehicle = null;
				int hour_rate = this.rs.getInt(1);
				Timestamp regist_date = this.rs.getTimestamp(2);
				String vehicle_id = this.rs.getString(3);
				String veneu_id = this.rs.getString(4);
				
				vehicle = new Vehicle(hour_rate, vehicle_id, veneu_id);
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
