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
// 		DBManager.getConnectionFromMySQL();
		
		Client client = (Client) session.getAttribute("log");
	%>
	<header>
		<h1><a href="/">동훈 렌터카</a></h1>
	</header>
	<nav>
		<div onclick="location.href='rent'">
			렌트하기
		</div>
		<div onclick="location.href='board'">
			게시판
		</div>
		<div onclick="location.href='venue'">
			지점
		</div>
		<div onclick=<%= client == null ? "location.href='login'" : "alert('뭐함')" %>>
			로그인
		</div>
		<div onclick=<%= client == null ? "checkLogIn()" : "location.href='mypage'" %>>
			마이페이지
		</div>
	</nav>
	<script src="../resources/validation.js"></script>
</body>
</html>