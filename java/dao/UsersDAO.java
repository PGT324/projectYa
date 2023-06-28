package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.Ac_UseVO;
import vo.Admin_CouponVO;
import vo.SellerVO;
import vo.UsersVO;
import vo.Users_CouponVO;

public class UsersDAO {
	
	private SqlSession usersSqlSession;
	
	public UsersDAO(SqlSession usersSqlSession) {
		System.out.println("dao 실행");
		this.usersSqlSession = usersSqlSession;
	}
	
	public Map<String,Object> checkEmail(String email) {
		return usersSqlSession.selectOne("users.checkEmail", email);
	}
	
	public int checkPhone(String phone) {
		return usersSqlSession.selectOne("users.checkPhone",phone) == null ? 0 : 1;
	}
	
	public int insertUsers(UsersVO dto) {
		return usersSqlSession.insert("users.insertUsers", dto);
	}
	
	public Map<String,Object> checkLogin(Map<String,Object> map) {
		return usersSqlSession.selectOne("users.checkLogin", map);
	}
	
	public UsersVO selecUser(int idx) {
		return usersSqlSession.selectOne("users.selectUser", idx);
	}
	
	public int updateAgree_type(Map<String,Object> map) {
		return usersSqlSession.update("users.updateAgreetype",map);
	}
	
	public int updateStatus(int idx) {
		return usersSqlSession.update("users.updateStatus",idx);
	}
	
	public int updatePw(UsersVO vo) {
		return usersSqlSession.update("users.updatePw", vo);
	}
	
	public int updatePhone(UsersVO vo) {
		return usersSqlSession.update("users.updatePhone",vo);
	}
	
	public List<SellerVO> selectSeller(int users_idx) {
		return usersSqlSession.selectList("seller.selectSeller", users_idx);
	}
	
	public int ucInsert(Users_CouponVO vo) {
		return usersSqlSession.insert("usersCoupon.ucInsert", vo);
	}
	
	public int selectMaxIdx() {
		return usersSqlSession.selectOne("users.selectMaxIdx");
	}
	
	public List<Users_CouponVO> ucSelect(int users_idx) {
		return usersSqlSession.selectList("usersCoupon.ucSelect", users_idx);
	}
	
	public List<Admin_CouponVO> acSelect(String code) {
		return usersSqlSession.selectList("usersCoupon.acSelect", code);
	}
	
	public List<Ac_UseVO> acUseSelect(int users_idx, int admin_coupon_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("users_idx", users_idx);
		map.put("admin_coupon_idx", admin_coupon_idx);
		
		return usersSqlSession.selectList("usersCoupon.acUseSelect", map);
	}
	
	public int acUseInsert(Ac_UseVO vo) {
		return usersSqlSession.insert("usersCoupon.acUseInsert", vo);
	}
	
	public int usersPoint(int users_idx) {
		return usersSqlSession.selectOne("point.usersPoint", users_idx);
	} 
	
}
