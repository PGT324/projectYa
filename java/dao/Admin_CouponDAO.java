package dao;

import org.apache.ibatis.session.SqlSession;

public class Admin_CouponDAO {
	
	private SqlSession admin_couponSqlSession;
	
	public Admin_CouponDAO(SqlSession admin_couponSqlSession) {
		this.admin_couponSqlSession = admin_couponSqlSession;
	}
	
	
	
}
