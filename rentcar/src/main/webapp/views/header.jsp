<%@page import="client.Client"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/style.css">
<title>Insert title here</title>
</head>
<body>
	<%
		Client log = (Client) session.getAttribute("log");
	%>
	<header>
		<h1 onclick="location.href='/'">동훈 렌터카</h1>
	</header>
	<nav>
		<div onclick=<%= log != null ? "location.href='venue'" : "checkLogIn()" %>>
			렌트하기
		</div>
		<div onclick="location.href='board'">
			게시판
		</div>
		<div onclick=<%= log != null ? "location.href='mypage'" : "checkLogIn()" %>>
			마이페이지
		</div>
	</nav>
	<script src="../resources/client.js"></script>
</body>
</html>