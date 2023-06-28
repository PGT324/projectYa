package vo;

import java.sql.Date;

public class Users_CouponVO {
	
	private int users_coupon_idx;
	private int users_idx;
	private String name;
	private String sale;
	private String code;
	private Date regdate;
	
	public Users_CouponVO() {;}

	public int getUsers_coupon_idx() {
		return users_coupon_idx;
	}

	public void setUsers_coupon_idx(int users_coupon_idx) {
		this.users_coupon_idx = users_coupon_idx;
	}

	public int getUsers_idx() {
		return users_idx;
	}

	public void setUsers_idx(int users_idx) {
		this.users_idx = users_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}
