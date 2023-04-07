package vehicle;

import java.sql.Timestamp;

public class Vehicle {
	private int hour_rate;
	private String vehicle_id, venue_id;
	private Timestamp regist_date;
	
	public Vehicle(int hour_rate, String vehicle_id, String venue_id) {
		this.hour_rate = hour_rate;
		this.vehicle_id = vehicle_id;
		this.venue_id = venue_id;
	}

	public int getHour_rate() {
		return hour_rate;
	}
	
	public Timestamp getRegist_date() {
		return regist_date;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public String getVenue_id() {
		return venue_id;
	}
	
	
}
