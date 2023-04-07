package controller;

import controller.action.Action;
import controller.action.JoinAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.PostDeleteAction;
import controller.action.PostEditAction;
import controller.action.ClientUpdateAction;
import controller.action.PostAction;

public class ActionFactory {
	// single tone 불필요한 instance 생성을 막기 위해 생성
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println(command);
		
		if(command.equals("join")) 
			action = new JoinAction();
		
		if(command.equals("login")) 
			action = new LoginAction();
		
		if(command.equals("logout")) 
			action = new LogoutAction();
		
		if(command.equals("clientUpdate")) 
			action = new ClientUpdateAction();
		
		if(command.equals("post")) 
			action = new PostAction();
		
		if(command.equals("postDelete")) 
			action = new PostDeleteAction();
		
		if(command.equals("postEdit")) 
			action = new PostEditAction();
		
		return action;
	}
}
