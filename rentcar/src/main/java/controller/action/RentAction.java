package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.BookingDto;
import booking.contoller.BookingDao;
import client.Client;

public class RentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		Client client = (Client) session.getAttribute("log");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
		String vehicle_id = request.getParameter("vehicle_id");
		String client_id = client.getClient_id();
		String venue_id = request.getParameter("venue_id");
		
		try {
			Date pickUpDate = sdf.parse(request.getParameter("pickup_time"));
			Date returnDate = sdf.parse(request.getParameter("return_time"));
			
			Timestamp pickUpTime = new Timestamp(pickUpDate.getTime());
			Timestamp returnTime =  new Timestamp(returnDate.getTime());
			
			BookingDao bookingDao = BookingDao.getInstance();
			BookingDto bookingDto = new BookingDto(vehicle_id, client_id, venue_id, pickUpTime, returnTime);
			bookingDao.createBooking(bookingDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		response.sendRedirect("mypage");
	}
}
