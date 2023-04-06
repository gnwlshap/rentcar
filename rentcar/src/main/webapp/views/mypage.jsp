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
	</section>
	<script src="../resources/validation.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>