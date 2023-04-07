package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientDto;
import client.controller.ClientDao;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실행할 Action 파일
		String client_id = request.getParameter("client_id");
		String client_pw = request.getParameter("client_pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
				
		ClientDao clientDao = ClientDao.getInstance();
		ClientDto clientDto = new ClientDto(client_id, client_pw, name, phone);
		clientDao.createClient(clientDto);
		
		response.sendRedirect("login");
	}
}
