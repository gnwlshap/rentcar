<%@page import="client.Client"%>
<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
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
	
	Client log = (Client) session.getAttribute("log");
	%>
	<jsp:include page="header"></jsp:include>
		<section>
			<h1>게시판</h1>
			<form>
				<div id="button">	
					<input type="button" value="게시물 작성" onclick=<%= log != null ? "location.href='post'" : "checkLoggedIn()" %>>
				</div>
				<table>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>글쓴이</td>
					</tr>
					<%BoardDao boardDao = BoardDao.getInstance();
					ArrayList<Board> boardList = boardDao.getAllBoard();
					
					for(int i=boardList.size()-1; i>=0; i--){
						
						int code = boardList.get(i).getBoard_code();
						String title = boardList.get(i).getTitle();
						String id = boardList.get(i).getClient_id();
						
					%>
					<tr>
						<td><%=i+1 %></td>
						<td><a href="post_view?board_code=<%=code %>"><%=title %></a></td>
						<td><%=id %></td>
					</tr><%
					}%>
				</table>
			</form>
		</section>
	<script src="../resources/board.js"></script>
	<jsp:include page="footer"></jsp:include>
</body>
</html>