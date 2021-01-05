package dto;

public class boardDTO {
	private int bno;
	private String title;
	private String bDate;
	private int bCount;
	private String writer;
	private String content;
	private int bLike;
	private int bHate;
	
	public boardDTO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public boardDTO(int bno, String title, String bDate, int bCount, String writer, String content, int bLike,
			int bHate) {
		super();
		this.bno = bno;
		this.title = title;
		this.bDate = bDate;
		this.bCount = bCount;
		this.writer = writer;
		this.content = content;
		this.bLike = bLike;
		this.bHate = bHate;
	}
	private int getBno() {
		return bno;
	}
	private void setBno(int bno) {
		this.bno = bno;
	}
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private String getbDate() {
		return bDate;
	}
	private void setbDate(String bDate) {
		this.bDate = bDate;
	}
	private int getbCount() {
		return bCount;
	}
	private void setbCount(int bCount) {
		this.bCount = bCount;
	}
	private String getWriter() {
		return writer;
	}
	private void setWriter(String writer) {
		this.writer = writer;
	}
	private String getContent() {
		return content;
	}
	private void setContent(String content) {
		this.content = content;
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
		return "boardDTO [bno=" + bno + ", title=" + title + ", bDate=" + bDate + ", bCount=" + bCount + ", writer="
				+ writer + ", content=" + content + ", bLike=" + bLike + ", bHate=" + bHate + "]";
	}
}
