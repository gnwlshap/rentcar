package controller.action;

import java.io.IOException;

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
		
		String vehicle_id = request.getParameter("vehicle_id");
		String client_id = client.getClient_id();
		String venue_id = request.getParameter("venue_id");
		String pickUpTime = request.getParameter("pickup_time");
		String returnTime =  request.getParameter("return_time");
		
		BookingDao bookingDao = BookingDao.getInstance();
		BookingDto bookingDto = new BookingDto(vehicle_id, client_id, venue_id, pickUpTime, returnTime);
		bookingDao.createBooking(bookingDto);
			
		response.sendRedirect("mypage");
	}
}
