package booking;

import java.sql.Timestamp;

public class Booking {
	private String vehicle_id, client_id, venue_id , pick_date, return_date;
	private Timestamp book_date;
	
	public Booking(String vehicle_id, String client_id, String venue_id, String pick_date, String return_date) {
		this.vehicle_id = vehicle_id;
		this.client_id = client_id;
		this.venue_id = venue_id;
		this.pick_date = pick_date;
		this.return_date = return_date;
	}
	
	public Booking(BookingDto bd) {
		this.vehicle_id = bd.getVehicle_id();
		this.client_id = bd.getClient_id();
		this.venue_id = bd.getVenue_id();
		this.pick_date = bd.getPick_date();
		this.return_date = bd.getReturn_date();
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

	public String getPick_date() {
		return pick_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	
}
