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
	int board_code = Integer.parseInt(request.getParameter("board_code"));
	
	String title = boardDao.getBoardByCode(board_code).getTitle();
	String content = boardDao.getBoardByCode(board_code).getContent();
	
	%>
	<jsp:include page="header"></jsp:include>
		<section>
			<h1>작성</h1>
			<form method="post" action="service">
				<input type="hidden" name="command" value="postEdit">
				<input type="hidden" name="board_code" value="<%=board_code %>">
				<div>	
				<input type="text" name="title" id="title" placeholder="제목" value="<%=title %>">
				</div>
				<div>	
				<textarea name="content" id="content" placeholder="내용을 입력하세요"><%=content %></textarea>
				</div>
				<div id="button">	
					<input type="button" value="수정" onclick="editPost(form)">
				</div>
			</form>
		</section>
	<script src="../resources/board.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>