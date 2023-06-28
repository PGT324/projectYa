package vo;

public class AdminVO {
	
	private int admin_idx;
	private String id;
	private String pw;
	private String email;
	private String phone;
	private String name;
	
	
	public AdminVO() {}
	
	
	public AdminVO(int admin_idx, String id, String pw, String email, String phone, String name) {
		super();
		this.admin_idx = admin_idx;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
		this.name = name;
	}
	
	
	public int getAdmin_idx() {
		return admin_idx;
	}
	public void setAdmin_idx(int admin_idx) {
		this.admin_idx = admin_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
