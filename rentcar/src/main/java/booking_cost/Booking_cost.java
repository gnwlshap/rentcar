package booking_cost;

import java.sql.Timestamp;

public class Booking_cost {
	private String vehicle_id, client_id, venue_id;
	private Timestamp pick_date, return_date;
	private int rent_hour, total_cost;
	
	public Booking_cost(String vehicle_id, String client_id, String venue_id, Timestamp pick_date2, Timestamp return_date2, int rent_hour, int total_cost) {
		this.vehicle_id = vehicle_id;
		this.client_id = client_id;
		this.vehicle_id = venue_id;
		this.pick_date = pick_date2;
		this.return_date = return_date2;
		this.rent_hour = rent_hour;
		this.total_cost = total_cost;
		
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
	public Timestamp getPick_date() {
		return pick_date;
	}
	public Timestamp getReturn_date() {
		return return_date;
	}
	public int getRent_hour() {
		return rent_hour;
	}
	public int getTotal_cost() {
		return total_cost;
	}
	
}
