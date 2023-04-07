package venue;

import java.sql.Timestamp;

public class Venue {
	private Timestamp open_date;
	private String venue_id, venue_name;
	
	public Venue(String venue_id, String venue_name) {
		this.venue_id = venue_id;
		this.venue_name = venue_name;
	}

	public Timestamp getOpen_date() {
		return open_date;
	}

	public String getVenue_id() {
		return venue_id;
	}

	public String getVenue_name() {
		return venue_name;
	}
	
}
