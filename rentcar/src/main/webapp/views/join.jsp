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
	String cone = request.getParameter("phone") == "" ? null : request.getParameter("phone");
	%>
	<jsp:include page="header"></jsp:include>	
	<section>
		<h1>join</h1>
		<form method="post" action="service">
			<input type="hidden" name="command" value="join">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="client_id" name="client_id"> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="client_pw" name="client_pw"> </td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="client_pw2" name="client_pw2"> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" name="name"> </td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="phone" name="phone"> </td>
				</tr>
			</table>
			<div id="button">	
				<input type="button" value="등록" onclick="checkJoinValues(form)">
			</div>
		</form>
	</section>
	<script src="../resources/client.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>