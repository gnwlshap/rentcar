package client;

import java.sql.Timestamp;

public class Client {
	private int client_code;
	private String client_id, client_pw, name, phone;
	private Timestamp sign_date;

	public Client(int client_code, String client_id, String client_pw, Timestamp sign_date, String name, String phone) {
		this.client_code = client_code;
		this.client_id = client_id;
		this.client_pw = client_pw;
		this.sign_date = sign_date;
		this.name = name;
		this.phone = phone;
	}
	
	public Client(String client_id, String client_pw, String name, String phone) {
		this.client_id = client_id;
		this.client_pw = client_pw;
		this.name = name;
		this.phone = phone;
	}
	
	public Client(ClientDto ClientDto) {
		this.client_id = ClientDto.getClient_id();
		this.client_pw = ClientDto.getClient_pw();
		this.name = ClientDto.getName();
		this.phone = ClientDto.getPhone();
	}
	
	public int getClient_code() {
		return client_code;
	}
	
	public String getClient_id() {
		return client_id;
	}

	public String getClient_pw() {
		return client_pw;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Timestamp getSign_date() {
		return sign_date;
	}
	
	
}
