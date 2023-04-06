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
	String client_id = request.getParameter("client_id") == "" ? null : request.getParameter("client_id");
	String client_pw = request.getParameter("client_pw") == "" ? null : request.getParameter("client_pw");
	String client_pw2 = request.getParameter("client_pw2") == "" ? null : request.getParameter("client_pw2");
	String name = request.getParameter("name") == "" ? null : request.getParameter("name");
	String phone = request.getParameter("phone") == "" ? null : request.getParameter("phone");
	%>
	<jsp:include page="header"></jsp:include>	
	<section>
		<h1>join</h1>
		<form method="post" action="service">
			<input type="hidden" name="command" value="join">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="client_id" name="client_id" value="<%=client_id != null ? client_id : ""%>" <%=client_id == null ? "autofocus" : "" %>> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="client_pw" name="client_pw" value="<%=client_pw != null ? client_pw : ""%>" <%=client_pw == null ? "autofocus" : "" %>> </td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="client_pw2" name="client_pw2" value="<%=client_pw2 != null && client_pw2.equals(client_pw) ? client_pw2 : "" %>" <%= client_pw2 == null ? "autofocus" : "" %>> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" name="name" value="<%=name != null ? name : ""%>" <%=name == null ? "autofocus" : "" %>> </td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="phone" name="phone" value="<%=phone != null ? phone : ""%>" <%=phone == null ? "autofocus" : "" %>> </td>
				</tr>
			</table>
			<div id="button">	
				<input type="button" value="등록" onclick="checkJoinValues(form)">
			</div>
		</form>
	</section>
	<script src="../resources/validation.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>