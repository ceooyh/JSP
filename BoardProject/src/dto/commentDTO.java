package dto;

public class commentDTO {
	private int cno;
	private int bno;
	private String content;
	private String cDate;
	private String writer;
	private int bLike;
	private int bHate;

	public commentDTO(int bno, String content, String writer) {
		super();
		this.bno = bno;
		this.content = content;
		this.writer = writer;
	}
	
	public commentDTO(int cno, int bno, String content, String cDate, String writer, int bLike, int bHate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.cDate = cDate;
		this.writer = writer;
		this.bLike = bLike;
		this.bHate = bHate;
	}
	private int getCno() {
		return cno;
	}
	private void setCno(int cno) {
		this.cno = cno;
	}
	private int getBno() {
		return bno;
	}
	private void setBno(int bno) {
		this.bno = bno;
	}
	private String getContent() {
		return content;
	}
	private void setContent(String content) {
		this.content = content;
	}
	private String getcDate() {
		return cDate;
	}
	private void setcDate(String cDate) {
		this.cDate = cDate;
	}
	private String getWriter() {
		return writer;
	}
	private void setWriter(String writer) {
		this.writer = writer;
	}
	private int getbLike() {
		return bLike;
	}
	private void setbLike(int bLike) {
		this.bLike = bLike;
	}
	private int getbHate() {
		return bHate;
	}
	private void setbHate(int bHate) {
		this.bHate = bHate;
	}
	@Override
	public String toString() {
		return "commentDTO [cno=" + cno + ", bno=" + bno + ", content=" + content + ", cDate=" + cDate + ", writer="
				+ writer + ", bLike=" + bLike + ", bHate=" + bHate + "]";
	}

	
}
