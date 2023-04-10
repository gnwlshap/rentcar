package booking;

import java.sql.Timestamp;

public class BookingDto {
	private String vehicle_id, client_id, venue_id, pick_date, return_date;
	private Timestamp book_date;
	
	public BookingDto(String vehicle_id, String client_id, String venue_id, String pick_date, String return_date ) {
		this.vehicle_id = vehicle_id;
		this.client_id = client_id;
		this.venue_id = venue_id;
		this.pick_date = pick_date;
		this.return_date = return_date;
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

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public void setVenue_id(String venue_id) {
		this.venue_id = venue_id;
	}

	public void setBook_date(Timestamp book_date) {
		this.book_date = book_date;
	}

	public void setPick_date(String pick_date) {
		this.pick_date = pick_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
}
