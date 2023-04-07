<%@page import="client.Client"%>
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
			<form method="post" action="service">
			<input type="hidden" name="command" value="postDelete">
			<input type="hidden" name="board_code" value="<%=board_code %>">
				<div id="title">	
					<%=title %>
				</div>
				<div id="content">	
					<%=content %>
				</div>
				<%
				Client log = (Client) session.getAttribute("log");
				String postId = boardDao.getBoardByCode(board_code).getClient_id();
				if(log != null && log.getClient_id().equals(postId)){
				%>
				<div id="button">	
					<input type="button" value="수정" onclick="location.href='post_edit?board_code=<%=board_code %>'">
					<input type="button" value="삭제" onclick="deletePost(form)">
				</div>
				<%
				}
				%>
			</form>
		</section>
	<script src="../resources/board.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>