package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.BoardDao;
import client.Client;

public class PostDeleteAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client log = (Client) session.getAttribute("log");
		
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		String client_id = log.getClient_id();

		BoardDao boardDao = BoardDao.getInstance();
		boardDao.deleteBoard(board_code, client_id);
		
		response.sendRedirect("board");
	}
}
