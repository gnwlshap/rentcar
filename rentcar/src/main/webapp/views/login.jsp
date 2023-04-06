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
	String client_pw = null;
	%>
	<jsp:include page="header"></jsp:include>
	<section>
		<h1>login</h1>
		<form method="post" action="service">
			<input type="hidden" name="command" value="login">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="client_id" name="client_id" value="<%=client_id != null ? client_id : ""%>" <%=client_id == null ? "autofocus" : "" %>> </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="client_pw" name="client_pw" value="<%=client_pw != null ? client_pw : ""%>" <%=client_pw == null ? "autofocus" : "" %>> </td>
				</tr>
			</table>
			<div id="button">	
				<input type="button" value="로그인" onclick="checkLoginValues(form)">
				<input type="button" value="회원가입" onclick="location.href='join'">
			</div>
		</form>
	</section>
	<script src="../resources/validation.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>