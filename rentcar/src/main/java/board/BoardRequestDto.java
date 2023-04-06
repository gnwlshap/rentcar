package board;

import java.sql.Timestamp;

public class BoardRequestDto {
	
	private int board_code;
	private String client_id, title, content;
	private Timestamp post_date;
	
	public BoardRequestDto(int board_code, String client_id, String content, String title, Timestamp post_date) {
		this.board_code = board_code;
		this.client_id = client_id;
		this.title = title;
		this.content = content;
		this.post_date = post_date;
	}
	
	public BoardRequestDto(String client_id, String content, String title) {
		this.client_id = client_id;
		this.title = title;
		this.content = content;
	}

	public int getBoard_code() {
		return board_code;
	}

	public String getClient_id() {
		return client_id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getPost_date() {
		return post_date;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPost_date(Timestamp post_date) {
		this.post_date = post_date;
	}
	
}
