package booking.contoller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import booking.Booking;
import booking.BookingDto;
import client.Client;
import util.DBManager;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BookingDao() {}
	private static BookingDao instance = new BookingDao();
	public static BookingDao getInstance() {
		return instance;
	}
	
	// C
	public void createBooking(BookingDto bd) {
		
		Booking booking = new Booking(bd);
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "INSERT INTO Booking(vehicle_id, client_id, venue_id, pick_date, hour)"
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, booking.getVehicle_id());
			this.pstmt.setString(2, booking.getClient_id());
			this.pstmt.setString(3, booking.getVenue_id());
			this.pstmt.setDate(4, booking.getPick_date());
			this.pstmt.setInt(5, booking.getHour());
			
			this.pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// R
	public ArrayList<Booking> getAllBooking(){
		ArrayList<Booking> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Booking ORDER BY book_date";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Booking booking = null;
				String vehicle_id = this.rs.getString(1);
				String client_id = this.rs.getString(2);
				String venue_id = this.rs.getString(3);
				Timestamp book_date = this.rs.getTimestamp(4);
				Date pick_date = this.rs.getDate(5);
				int hour = this.rs.getInt(6);
				
				booking = new Booking(vehicle_id, client_id, venue_id, book_date, pick_date, hour);
				list.add(booking);
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
