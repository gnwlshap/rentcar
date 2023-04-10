<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
String venue_id = request.getParameter("venue_id");
String vehicle_name = request.getParameter("vehicle_name");
	
Date today = new Date();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

Calendar cal = Calendar.getInstance();

cal.setTime(today);
cal.add(Calendar.DATE, 1);

String pickUpDate = sdf.format(today);
String returnDate = sdf.format(cal.getTime());

String pickUpTime = sdf2.format(today);
String returnTime = sdf2.format(cal.getTime());
%>
	<jsp:include page="header"></jsp:include>
		<section>
			<h1>rent</h1>
			<form action="vehicles">
			<input type="hidden" name="venue_id" value="<%=venue_id %>">
				<table>
					<tr>
						<td>
						픽업 일자 및 시간
						</td>
						<td>
						<input type="date" id="pickup_date" name="pickup_date" min="<%=pickUpDate %>" value="<%=pickUpDate %>" required>
						</td>
						<td>
							<select id="pickup_time" name="pickup_time">
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
						반납 일자 및 시간
						</td>
						<td>
						<input type="date" id="return_date" name="return_date" min="<%=returnDate %>" value="<%=returnDate %>" required>						
						</td>
						<td>
							<select id="return_time" name="return_time">
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
							</select>
						</td>
					</tr>
				</table>
				<div id="button">	
					<input type="button" value="다음" onclick="submitTime(form)">
				</div>
			</form>
		</section>
		<script src="../resources/rent.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>