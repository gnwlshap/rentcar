package board;

import java.sql.Timestamp;

public class Board {
	
	private int board_code;
	private String client_id, title, content;
	private Timestamp post_date;
	
	public Board(int board_code, String client_id, String title, String content, Timestamp post_date) {
		this.board_code = board_code;
		this.client_id = client_id;
		this.title = title;
		this.content = content;
		this.post_date = post_date;
	}
	
	public Board(String client_id, String title, String content) {
		this.client_id = client_id;
		this.title = title;
		this.content = content;
	}
	
	public Board(BoardDto BoardDto) {
		this.client_id = BoardDto.getClient_id();
		this.title = BoardDto.getTitle();
		this.content = BoardDto.getContent();
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
	
}
