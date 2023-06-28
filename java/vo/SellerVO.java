package vo;

public class SellerVO {
	
	private int seller_idx;
	private int users_idx;
	private String name;
	private String exp;
	private int snumber;
	private int ad;
	private int status;
	
	public SellerVO() {;}

	public int getSeller_idx() {
		return seller_idx;
	}

	public void setSeller_idx(int seller_idx) {
		this.seller_idx = seller_idx;
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

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getSnumber() {
		return snumber;
	}

	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}

	public int getAd() {
		return ad;
	}

	public void setAd(int ad) {
		this.ad = ad;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
