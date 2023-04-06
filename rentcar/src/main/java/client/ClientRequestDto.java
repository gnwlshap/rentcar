package client;

import java.sql.Timestamp;

public class ClientRequestDto {
	private int client_code;
	private String client_id, client_pw, name, phone;
	private Timestamp sign_date;

	public ClientRequestDto(int client_code, String client_id, String client_pw, Timestamp sign_date, String name, String phone) {
		this.client_code = client_code;
		this.client_id = client_id;
		this.client_pw = client_pw;
		this.sign_date = sign_date;
		this.name = name;
		this.phone = phone;
	}
	
	public ClientRequestDto(String client_id, String client_pw, String name, String phone) {
		this.client_id = client_id;
		this.client_pw = client_pw;
		this.name = name;
		this.phone = phone;
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

	public void setClient_code(int client_code) {
		this.client_code = client_code;
	}
	
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public void setClient_pw(String client_pw) {
		this.client_pw = client_pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSign_date(Timestamp sign_date) {
		this.sign_date = sign_date;
	}
	
}
