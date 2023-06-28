package service;

import java.util.Map;

import dao.AdminDAO;
import vo.AdminVO;

public class AdminService {

	private AdminDAO adminDAO;
	
	public AdminService(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	public  Map<String,Object> loginCheck(AdminVO vo) {
		return adminDAO.loginCheck(vo);
	}
	
	public AdminVO login(int idx) {
		return adminDAO.login(idx);
	}
	
	
}
