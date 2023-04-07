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
	Client client = (Client) session.getAttribute("log");
	String client_id = client.getClient_id();
	String client_pw = client.getClient_pw();
	String client_pw2 = client.getClient_pw();
	String name = client.getName();
	String phone = client.getPhone();
	%>
	<jsp:include page="header"></jsp:include>	
	<section>
		<h1>회원 정보 수정</h1>
		<form method="post" action="service">
			<input type="hidden" name="command" value="clientUpdate">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="client_id" name="client_id" value="<%=client_id%>"> </td>
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
					<td><input type="text" id="name" name="name" value="<%=name %>"> </td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="phone" name="phone" value="<%=phone %>"> </td>
				</tr>
			</table>
			<div id="button">	
				<input type="button" value="정보수정" onclick="checkUpdate(form)">
			</div>
		</form>
	</section>
	<script src="../resources/client.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>