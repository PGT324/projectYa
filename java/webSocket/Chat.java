package webSocket;

public class Chat {
	
	private int idx;
	private String content;
	private String cdate;
	
	public Chat(int idx, String content, String cdate) {
		super();
		this.idx = idx;
		this.content = content;
		this.cdate = cdate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	
	
}
