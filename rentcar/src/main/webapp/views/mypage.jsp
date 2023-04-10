<%@page import="venue.contoller.VenueDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="booking_cost.Booking_cost"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking_cost.controller.Booking_costDao"%>
<%@page import="client.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:include page="header"></jsp:include>	
	<section>
		<h1><%
		Client client = (Client) session.getAttribute("log");
		if(client != null) { %>
			<%=client.getName()%>의 페이지
	<%	}
	%>	</h1>
		<form method="post" action="service">
			<input type="hidden" name="command" value="logout">
			<table>
				<tr>
					<td>아이디</td>
					<td><%=client.getClient_id() %></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%=client.getName() %></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><%=client.getPhone().substring(0, 3)+"-"+client.getPhone().substring(3, 7)+"-"+client.getPhone().substring(7) %></td>
				</tr>
			</table>	
			<div id="button">	
				<input type="button" value="정보수정" onclick="location.href ='update'">
				<input type="button" value="로그아웃" onclick="logout(form)">
			</div>
		</form>
		<form>
			<table>
				<tr>
					<td style="text-align:center" colspan="2">나의 렌트</td>
				</tr>
				<%
				Booking_costDao bcd = Booking_costDao.getInstance();
				ArrayList<Booking_cost> myList = bcd.getMyBookingCost(client.getClient_id());
				
				VenueDao venueDao = VenueDao.getInstance();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				for(Booking_cost bc : myList){
					String vehicle_id = bc.getVehicle_id();
					String client_id = bc.getClient_id();
					String venue_id = bc.getVenue_id();
					String venue_name = venueDao.getVenueById(venue_id);
					String pick_date = sdf.format(bc.getPick_date());
					String return_date = sdf.format(bc.getReturn_date());
					String vehicle_name = bc.getVehicle_name();
					int rent_hour = bc.getRent_hour();
					int total_cost = bc.getTotal_cost();
				%>
				<tr>
					<td>차종</td>
					<td><%=vehicle_name %></td>
				</tr>
				<tr>
					<td>지점</td>
					<td><%=venue_name %>구</td>
				</tr>
				<tr>
					<td>수령일</td>
					<td><%=pick_date %></td>
				</tr>
				<tr>
					<td>반납일</td>
					<td><%=return_date %></td>
				</tr>
				<tr>
					<td>시간</td>
					<td><%=rent_hour %>시간</td>
				</tr>
				<tr>
					<td>금액</td>
					<td><%=total_cost %>원</td>
				</tr>
				<%
				}
				%>
			</table>
		</form>	
	</section>
	<script src="../resources/client.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>