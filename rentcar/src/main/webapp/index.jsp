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
	<jsp:include page="header"></jsp:include>
	<section>
		<h1>
	<%
		Client client = (Client) session.getAttribute("log");
		if(client != null) { %>
			<%=client.getName()%> 님 하위요~~
	<%	}
			
	%>
		</h1>
	</section>
	<jsp:include page="footer"></jsp:include>
</body>
</html>