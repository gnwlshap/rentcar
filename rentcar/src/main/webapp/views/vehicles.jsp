<%@page import="venue.contoller.VenueDao"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	
	String pickUpTime = request.getParameter("pickup_date") + " " + request.getParameter("pickup_time");
	String returnTime = request.getParameter("return_date") + " " + request.getParameter("return_time");
	
	String venue_id = request.getParameter("venue_id");
	
	VenueDao venueDao = VenueDao.getInstance();
	VehicleDao vehicleDao = VehicleDao.getInstance();
	%>
	<jsp:include page="header"></jsp:include>
	<section>
		<h1>목록</h1>
			<form id="rent_form" method="post" action="service">
				<input type="hidden" name="command" value="rent">
				<input type="hidden" id="pickup_time" name="pickup_time" value="<%=pickUpTime %>"> 
				<input type="hidden" id="return_time" name="return_time" value="<%=returnTime %>"> 
				<input type="hidden" name="venue_id" value="<%=venue_id %>">
				<input type="hidden" id="venue_name" name="venue_name" value="<%=venueDao.getVenueById(venue_id) %>">
				<input type="hidden" id="vehicle_id" name="vehicle_id">
				<table>
					<%
					ArrayList<Vehicle> vehicleList = vehicleDao.getRentableVehicle_id(returnTime, pickUpTime, venue_id);
					for(int i=0; i<vehicleList.size(); i++){
						
						String vehicle_name = vehicleList.get(i).getVehicle_name();
						String vehicle_id = vehicleList.get(i).getVehicle_id();
						int hour_rate = vehicleList.get(i).getHour_rate();
					%>
					<tr>
						<td><%=i+1 %></td>
						<td class="button" id="vehicle_name" onclick="rent(document.getElementById('rent_form'),'<%=vehicle_id %>', '<%=vehicleDao.getVehicleNameByVehicleId(vehicle_id) %>')"><%=vehicle_name %></td>
						<td>시간당 요금 : <%=hour_rate %>원</td>
					</tr>
					<%
					}
					%>
				</table>
			</form>
	</section>
	<script src="../resources/rent.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>