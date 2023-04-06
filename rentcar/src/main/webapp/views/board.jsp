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
	<jsp:include page="header"></jsp:include>
		<section>
			<h1>게시판</h1>
			<form>
				<div id="button">	
					<input type="button" value="게시물 작성" onclick="location.href ='update'">
				</div>
				<table>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>글쓴이</td>
					</tr>
					<%BoardDao boardDao = BoardDao.getInstance();
					ArrayList<Board> boardList = boardDao.getAllBoard();
					for(Board board : boardList){
					%>
					<tr>
						<td><%=boardList.size()+1 %></td>
						<td><%=board.getTitle() %></td>
						<td><%=board.getClient_id() %></td>
					</tr><%
					}%>
				</table>
				<div id="button">	
<!-- 					<input type="button" value="정보수정" onclick="location.href ='update'"> -->
				</div>
			</form>
		</section>
	<jsp:include page="footer"></jsp:include>
</body>
</html>