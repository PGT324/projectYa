package service;

import java.util.List;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import dao.UsersDAO;
import vo.Ac_UseVO;
import vo.Admin_CouponVO;
import vo.SellerVO;
import vo.UsersVO;
import vo.Users_CouponVO;

public class UsersService {

	private UsersDAO usersDao;
	JavaMailSenderImpl mailSender;
	
	
	public UsersService(UsersDAO usersDao) {
		System.out.println("서비스 실행");
		this.usersDao = usersDao;
	}

	public Map<String,Object> checkEmail(String email) {
		return usersDao.checkEmail(email);
	}

	public int checkPhone(String phone) {
		return usersDao.checkPhone(phone);
	}

	public int insertUsers(UsersVO dto) {
		return usersDao.insertUsers(dto);
	}

	public Map<String, Object> checkLogin(Map<String, Object> map) {
		return usersDao.checkLogin(map);
	}

	public UsersVO selectUser(int idx) {
		return usersDao.selecUser(idx);
	}

	public int updateAgree_type(Map<String, Object> map) {
		return usersDao.updateAgree_type(map);
	}
	
	public int updateStatus(int idx) {
		return usersDao.updateStatus(idx);
	}
	
	public int updatePw(UsersVO vo) {
		return usersDao.updatePw(vo);
	}
	
	public int updatePhone(UsersVO vo) {
		return usersDao.updatePhone(vo);
	}
	
	public List<SellerVO> selectSeller(int users_idx) {
		return usersDao.selectSeller(users_idx);
	}
	
	public int ucInsert(Users_CouponVO vo) {
		return usersDao.ucInsert(vo);
	}
	
	public int selectMaxIdx() {
		return usersDao.selectMaxIdx();
	}
	
	public List<Users_CouponVO> ucSelect(int users_idx) {
		return usersDao.ucSelect(users_idx);
	}
	
	public List<Admin_CouponVO> acSelect(String code) {
		return usersDao.acSelect(code);
	}
	
	public List<Ac_UseVO> acUseSelect(int users_idx, int admin_coupon_idx) {
		return usersDao.acUseSelect(users_idx, admin_coupon_idx);
	}
	
	public int acUseInsert(Ac_UseVO vo) {
		return usersDao.acUseInsert(vo);
	}
	
	public int usersPoint(int users_idx) {
		return usersDao.usersPoint(users_idx);
	}
}
