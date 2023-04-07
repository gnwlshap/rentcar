package booking;

import java.sql.Date;
import java.sql.Timestamp;

public class BookingDto {
	private String vehicle_id, client_id, venue_id;
	private Timestamp book_date;
	private Date pick_date;
	private int hour;
	
	public BookingDto(String vehicle_id, String client_id, String venue_id, Timestamp book_date, Date pick_date, int hour ) {
		this.vehicle_id = vehicle_id;
		this.client_id = client_id;
		this.venue_id = venue_id;
		this.book_date = book_date;
		this.pick_date = pick_date;
		this.hour = hour;
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

	public void setPick_date(Date pick_date) {
		this.pick_date = pick_date;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
}
