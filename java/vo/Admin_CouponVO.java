package vo;

import java.sql.Date;

public class Admin_CouponVO {
	
	private int admin_coupon_idx;
	private String name;
	private String sale;
	private String code;
	private Date regdate;
	
	public Admin_CouponVO() {;}

	public int getAdmin_coupon_idx() {
		return admin_coupon_idx;
	}

	public void setAdmin_coupon_idx(int admin_coupon_idx) {
		this.admin_coupon_idx = admin_coupon_idx;
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
