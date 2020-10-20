package biz.board.vo;

public class BoardVO {
	
	private int boardno;
	private String title;
	private String content;
	private String writer;
	private String boarddate;
	int viewcount;
	
	public BoardVO() {}
	public BoardVO(int boardno, String title, String content, String writer, String boarddate, int viewcount) {
		this.boardno = boardno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.boarddate = boarddate;
		this.viewcount = viewcount;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardno=" + boardno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", boarddate=" + boarddate + ", viewcount=" + viewcount + "]";
	}
	
	
	
}
