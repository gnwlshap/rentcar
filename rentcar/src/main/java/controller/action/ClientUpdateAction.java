package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.ClientDto;
import client.controller.ClientDao;

public class ClientUpdateAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String client_id = request.getParameter("client_id");
		String client_pw = request.getParameter("client_pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
			ClientDao cd = ClientDao.getInstance();
			ClientDto crd = new ClientDto(client_id, client_pw, name, phone);
			
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("log");
			int client_code = cd.getCodeById(client.getClient_id());
			
			cd.updateClient(crd, client_code);
			
			session.setAttribute("log", cd.getClientByCode(client_code));
			
			response.sendRedirect("mypage");
		
	}

}
