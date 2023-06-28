package vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SecessionVO {
	
	private int secession_idx;
	private int users_idx;
	private Date date_exit;
	private Date date_end;
	private String content;
	private int type;
	
	public SecessionVO() {}
	
	public SecessionVO(int secession_idx, int users_idx, Date date_exit, Date date_end,String content, int type) {
		this.secession_idx = secession_idx;
		this.users_idx = users_idx;
		this.date_exit = date_exit;
		this.date_end = date_end;
		this.content = content;
		this.type = type;
	}

	public int getSecession_idx() {
		return secession_idx;
	}
	public void setSecession_idx(int secession_idx) {
		this.secession_idx = secession_idx;
	}
	public int getUsers_idx() {
		return users_idx;
	}
	public void setUsers_idx(int users_idx) {
		this.users_idx = users_idx;
	}
	public Date getDate_exit() {
		return date_exit;
	}
	public void setDate_exit(Date date_exit) {
		this.date_exit = date_exit;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
