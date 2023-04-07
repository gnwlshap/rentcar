package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDto;
import board.controller.BoardDao;
import client.Client;

public class PostAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client log = (Client) session.getAttribute("log");
		
		String log_id = log.getClient_id();
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = new BoardDto(log_id, title, content);
		boardDao.createBoard(boardDto);
		
		response.sendRedirect("board");
		
	}
}
