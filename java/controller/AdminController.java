package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import path.YaPath;
import service.AdminService;
import service.Admin_CouponService;
import vo.AdminVO;

@Controller
public class AdminController implements YaPath{
	
	private AdminService adminService;
	private Admin_CouponService admin_couponService;
	
	public AdminController(AdminService adminService,Admin_CouponService admin_couponService) {
		this.adminService = adminService;
		this.admin_couponService = admin_couponService;
	}
	
	@RequestMapping("/admin/loginCheck")
	@ResponseBody
	public Map<String,Object> loginCheck(AdminVO vo) {
		return adminService.loginCheck(vo);
	}
	
	@RequestMapping("/admin/loginForm/{idx}")
	public String login(@PathVariable("idx") int idx,HttpServletRequest req) {
		AdminVO dto = adminService.login(idx);
		HttpSession session = req.getSession();
		session.setAttribute("login", dto);
		return ADMIN_PAGE+"index.jsp";
	}
	
	@RequestMapping("/admin/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "/";
	}
	
	
	
	@RequestMapping("/admin/")
	public String adminpage() {
		
		return ADMIN_PAGE+"index.jsp";
	}
	
	@RequestMapping("/admin/addAdmin_CouponForm")
	public String addAdmin_CouponForm() {
		
		return ADMIN_COUPON+"addAdmin_CouponForm.jsp";
	}
	
	@RequestMapping("/admin/insertCoupon")
	public String insertCoupon() {
		return "";
	}
	
	
	
}

