package venue.contoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;
import venue.Venue;

public class VenueDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VenueDao() {}
	private static VenueDao instance = new VenueDao();
	public static VenueDao getInstance() {
		return instance;
	}
	
	// R
	public ArrayList<Venue> getAllVenue(){
		ArrayList<Venue> list = new ArrayList<>();
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT * FROM Venue ORDER BY open_date";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				Venue venue = null;
				String veneu_id = this.rs.getString(1);
				String veneu_name = this.rs.getString(2);
				Timestamp open_date = this.rs.getTimestamp(3);
				
				venue = new Venue(veneu_id, veneu_name);
				list.add(venue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public String getVenueById(String venueId){
		String venueName = null;
		
		this.conn = DBManager.getConnectionFromMySQL();
		
		String sql = "SELECT venue_name FROM Venue WHERE venue_id =?";
		
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, venueId);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next())
				venueName = this.rs.getString(1);
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return venueName;
	}
}
