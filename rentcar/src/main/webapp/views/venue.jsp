<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="java.util.ArrayList"%>
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
			<h1>지역</h1>
			<form>
				<table id="venue">
					<tr class="button">
						<td onclick="location.href='time?venue_id=seoul01'">강남구</td>
						<td onclick="location.href='time?venue_id=seoul02'">서초구</td>
						<td onclick="location.href='time?venue_id=seoul03'">강동구</td>
						<td onclick="location.href='time?venue_id=seoul04'">용산구</td>
						<td onclick="location.href='time?venue_id=seoul05'">서초구</td>
					</tr>
				</table>
			</form>
		</section>
<!-- 	<script src="../resources/.js"></script> -->
	<jsp:include page="footer"></jsp:include>
</body>
</html>