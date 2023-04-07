<%@page import="board.controller.BoardDao"%>
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
	
	BoardDao boardDao = BoardDao.getInstance();
	request.getParameter("board_code");
	
	%>
	<jsp:include page="header"></jsp:include>
		<section>
			<h1>작성</h1>
			<form method="post" action="service">
				<input type="hidden" name="command" value="post">
				<div>	
				<input type="text" name="title" id="title" placeholder="제목" >
				</div>
				<div>	
				<textarea name="content" id="content" placeholder="내용을 입력하세요"></textarea>
				</div>
				<div id="button">	
					<input type="button" value="등록" onclick="checkPost(form)">
				</div>
			</form>
		</section>
	<script src="../resources/board.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>