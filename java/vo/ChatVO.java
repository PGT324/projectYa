package vo;

import java.sql.Date;

public class ChatVO {
	private int chat_idx;
	private String users_idx;
	private String lastContent;
	private Date lastDate;
	private int checked;
	
	public ChatVO() {}
	
	public ChatVO(int chat_idx, String users_idx, String lastContent, Date lastDate, int checked) {
		super();
		this.chat_idx = chat_idx;
		this.users_idx = users_idx;
		this.lastContent = lastContent;
		this.lastDate = lastDate;
		this.checked = checked;
	}

	public int getChat_idx() {
		return chat_idx;
	}

	public void setChat_idx(int chat_idx) {
		this.chat_idx = chat_idx;
	}

	public String getUsers_idx() {
		return users_idx;
	}

	public void setUsers_idx(String users_idx) {
		this.users_idx = users_idx;
	}

	public String getLastContent() {
		return lastContent;
	}

	public void setLastContent(String lastContent) {
		this.lastContent = lastContent;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	
	
	
}
