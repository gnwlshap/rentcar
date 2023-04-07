package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.controller.ClientDao;

public class LoginAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String client_id = request.getParameter("client_id");
		String client_pw = request.getParameter("client_pw");
		
		ClientDao clientDao = ClientDao.getInstance();
		ArrayList<Client> list = clientDao.getAllClient();
		
		Client logClient = null;
		
		for(Client client : list)
			if(client.getClient_id().equals(client_id) && client.getClient_pw().equals(client_pw)) 
				logClient = client;
			
		
		if(logClient != null) {
			HttpSession session = request.getSession();
			session.setAttribute("log", logClient);
			response.sendRedirect("/");
		}
		else {
			request.getRequestDispatcher("login").forward(request, response);
		}
	}
}
