package booking;

import java.sql.Date;
import java.sql.Timestamp;

public class Booking {
	private String vehicle_id, client_id, venue_id;
	private Timestamp book_date;
	private Date pick_date;
	private int hour;
	
	public Booking(String vehicle_id, String client_id, String venue_id, Timestamp book_date, Date pick_date, int hour ) {
		this.vehicle_id = vehicle_id;
		this.client_id = client_id;
		this.venue_id = venue_id;
		this.book_date = book_date;
		this.pick_date = pick_date;
		this.hour = hour;
	}
	
	public Booking(BookingDto bd) {
		this.vehicle_id = bd.getVehicle_id();
		this.client_id = bd.getClient_id();
		this.venue_id = bd.getVenue_id();
		this.pick_date = bd.getPick_date();
		this.hour = bd.getHour();
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getVenue_id() {
		return venue_id;
	}

	public Timestamp getBook_date() {
		return book_date;
	}

	public Date getPick_date() {
		return pick_date;
	}

	public int getHour() {
		return hour;
	}

	
}
