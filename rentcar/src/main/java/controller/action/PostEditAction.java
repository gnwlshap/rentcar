package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDto;
import board.controller.BoardDao;
import client.Client;

public class PostEditAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client log = (Client) session.getAttribute("log");
		
		String log_id = log.getClient_id();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int board_code = Integer.parseInt(request.getParameter("board_code"));
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = new BoardDto(log_id, title, content);
		boardDao.updateBoard(boardDto, board_code);
		
		response.sendRedirect("post_view?board_code="+board_code);
	}
}
