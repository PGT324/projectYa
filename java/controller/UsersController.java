package controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import email.MailSendService;
import path.YaPath;
import service.UsersService;
import vo.Ac_UseVO;
import vo.Admin_CouponVO;
import vo.SellerVO;
import vo.UsersVO;
import vo.Users_CouponVO;

@Controller
public class UsersController implements YaPath{
	
    private JavaMailSenderImpl mailSender;
	private UsersService usersService;
	
	MailSendService ms = new MailSendService();
	
	private String checkEmail;
	private int checkNan;

	
	public UsersController(UsersService usersService,JavaMailSenderImpl mailSender) {
		this.usersService = usersService;
		this.mailSender = mailSender;
		ms.setMailSender(mailSender);
		System.out.println("컨트롤러 실행");
		System.out.println(mailSender == null);
	}

	
	

	
	@RequestMapping("/users/join")
	public String join() {
		return USERS_JOIN+"checkEmail.jsp";
	}

	
	@RequestMapping("/users/checkEmail")
	@ResponseBody
	public Map<String,Object> checkEmail(String email) {//map타입이 아니다
		return usersService.checkEmail(email);
	}
	
	@RequestMapping("/users/checkPhone")
	@ResponseBody
	public int checkPhone(String phone) {
		return usersService.checkPhone(phone);
	}
	
	
	@RequestMapping("/users/sendEmail/{num}")
	@ResponseBody
	public int sendEmail(@PathVariable("num") int num ,String email) {
		if(num == 1) {
			return ms.joinEmail(email,num);
		}else {
			checkEmail = email;
			checkNan = ms.joinEmail(email, num);
			return 0;
		}
	}
	
	
	@RequestMapping("/users/joinData")
	public String joinForm(UsersVO dto) {
		System.err.println(dto.getEmail()+dto.getPhone());
		usersService.insertUsers(dto);
		return "/";
	}
	@RequestMapping("/users/joinForm")
	public String joinForm() {
		return USERS_JOIN+"joinForm.jsp";
	}
	

	@RequestMapping("/users/login")
	public String login() {
		return USERS_LOGIN+"login.jsp";
	}
	
	
	@RequestMapping("/users/checkLogin")
	@ResponseBody
	public Map<String, Object> checkLogin(HttpServletRequest req,HttpServletResponse res) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("email", req.getParameter("email"));
		map.put("pw", req.getParameter("pw"));
		map = usersService.checkLogin(map);
		
//		Cookie[] cks = req.getCookies();
//		boolean tf = false;
//		Cookie ck = null;
//		
//		if(cks != null) {
//			for(Cookie c : cks) {
//				if(c.getName().equals("failLog")) {
//					ck = c;
//					tf = true;
//				}
//			}
//		}
//		
//		if(map == null) {
//			map = new HashMap<String, Object>();
//			int num = 0;
//			if(tf) {
//				num = Integer.parseInt(ck.getValue());
//				num++;
//				ck.setValue(""+num);
//				ck.setMaxAge(999999999);
//				ck.setPath("/");
//				res.addCookie(ck);
//			}else {
//				ck = new Cookie("failLog", "1");
//				num = 1;
//				ck.setMaxAge(999999999);
//				ck.setPath("/");
//				res.addCookie(ck);
//			}
//			System.out.println(num);
//			map.put("c", num);	
//		}else {
//			if(tf) {
//				ck.setMaxAge(0);
//				ck.setPath("/");
//				res.addCookie(ck);
//			}					
//		}
		
		return map;
	}
	
	@RequestMapping("/users/loginForm/{idx}"/*,{ckid}"*/)
	public String loginForm(
			@PathVariable("idx") int idx/* ,@PathVariable("ckid")int ckid */,HttpServletRequest request,HttpServletResponse response) {
		
		Cookie[] cks = request.getCookies();
		Cookie ck = null;
		
		UsersVO dto = usersService.selectUser(idx);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("login", dto);
		
//		boolean check = false;
//		
//		for(Cookie c : cks) {
//			if(c.getName().equals("ckid")) {
//				check = true;
//				ck = c;
//			}
//		}
//		
//		if(ckid != 0) {
//			
//			if(check) {
//				System.out.println("쿠키유지");
//				ck.setMaxAge(600);
//				ck.setPath("/");
//				response.addCookie(ck);
//			}else {
//				System.out.println("쿠키생성");
//				ck = new Cookie("ckid",dto.getEmail());
//				ck.setMaxAge(600);
//				ck.setPath("/");
//				response.addCookie(ck);
//			}
//			
//		}else {
//			if(check) {
//				System.out.println("쿠키지움");
//				ck.setMaxAge(0);
//				ck.setPath("/");
//				response.addCookie(ck);
//			}	
//		}
		
		
		
		
		return "/";
	}
	
	
	@RequestMapping("/users/logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		
		return "/";
	}
	
	@RequestMapping("/users/mypage")
	public String mypage(int users_idx) {
		
		List<SellerVO> list = usersService.selectSeller(users_idx);
		
		if(!list.isEmpty() && list.get(0).getStatus() == 1) {
			return USERS_MYPAGE + "sellerlogin.jsp";
		}
		
		return USERS_MYPAGE+"mypage.jsp";
	}
	
	
	
	@RequestMapping("/users/pind")
	public String pindPassword() {
		return USERS_LOGIN+"pind.jsp";
	}
	
	
	@RequestMapping("/users/checkPw/{num}")
	public String checkPw(@PathVariable("num") int num,Model model) {

		
		model.addAttribute("num",num);
		return USERS_LOGIN+"checkPw.jsp";
	}
	
	@RequestMapping("/users/mydata/{ck}")
	public String myData(@PathVariable("ck") int ck,Model m) {
			m.addAttribute("ck", ck);
			return USERS_MYPAGE+"mydata.jsp";
	}
	@RequestMapping("/users/joinOut")
	public String joinOut(Model model ,int users_idx) {
		
		int point = usersService.usersPoint(users_idx);
		
		model.addAttribute("point", point);
		
		return USERS_JOIN+"joinOut.jsp";
	}

	
	
	
	@RequestMapping("test")
	public String test() {
		return "/WEB-INF/views/test.jsp";
	}
	
	
	
	@RequestMapping("/users/updateAgree_type")
	@ResponseBody
	public void updateAgree(String agree,int idx,HttpServletRequest req) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("agree", agree);
		map.put("idx", idx);
		if(usersService.updateAgree_type(map) != 0) {
			HttpSession session = req.getSession();
			UsersVO dto = (UsersVO)session.getAttribute("login");
			dto.setAgree_type_idx(agree);
		}
	}
	
	@RequestMapping("/users/updatePw/{num}")
	@ResponseBody
	public int updatePw(@PathVariable("num") int num,UsersVO vo,HttpServletRequest req) {
		int a = usersService.updatePw(vo);
		if(num == 0) {
			UsersVO uvo = (UsersVO)req.getSession().getAttribute("login");
			uvo.setPw(vo.getPw());
		}
		return a;
	}
	
	@RequestMapping("/users/updatePhone")
	@ResponseBody
	public int updatePhone(UsersVO vo) {
		return usersService.updatePhone(vo);
	}
	
	@RequestMapping("/users/updatePwForm")
	public String updatePwForm(String e,int n,Model m) {
		if(e.equals(checkEmail)  && n == checkNan) {
			Map<String,Object> map = usersService.checkEmail(e);
			m.addAttribute("idx", map.get("USERS_IDX"));
			return USERS_MYPAGE+"updatePwForm.jsp";		
		}else {
			return "/";
		}
	}
	
	@RequestMapping("/users/chat")
	public String chat() {
		
		
		return "/WEB-INF/views/chat/chat.jsp";
	}
	
	@RequestMapping("/users/mypage/coupon")
	public String coupon(Model model ,int users_idx) {
		
		List<Users_CouponVO> list = usersService.ucSelect(users_idx);
		int count = list.size();
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "/WEB-INF/views/users/mypage/coupon.jsp";
	}
	
	@RequestMapping("/users/mypage/crule")
	public String crule() {
		return "/WEB-INF/views/users/mypage/crule.jsp";
	}
	
	@RequestMapping("/users/mypage/couponinsert")
	public String couponInsert() {
		return "/WEB-INF/views/users/mypage/couponinsert.jsp";
	}
	
	@RequestMapping("/users/mypage/result")
	public String acResult(Model model ,String code, int users_idx) {
		
		String msg = "";
		String href = "";
		
		List<Admin_CouponVO> acList = usersService.acSelect(code);
		
		
		if(acList.isEmpty()) {
			msg = "쿠폰을 정확히 입력해주세요!";
			href = "/pro/users/mypage/couponinsert";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
		}else {
			
			List<Ac_UseVO> acUseList = usersService.acUseSelect(users_idx, acList.get(0).getAdmin_coupon_idx());
			
			if(acUseList.isEmpty()) {
				Users_CouponVO vo = new Users_CouponVO();
				
				vo.setName(acList.get(0).getName());
				vo.setSale(acList.get(0).getSale());
				vo.setCode(acList.get(0).getCode());
				vo.setUsers_idx(users_idx);
				
				int i = usersService.ucInsert(vo);
				
				if(i != 0) {
					
					Ac_UseVO vo1 = new Ac_UseVO();
					
					vo1.setUsers_idx(users_idx);
					vo1.setAdmin_coupon_idx(acList.get(0).getAdmin_coupon_idx());
					
					usersService.acUseInsert(vo1);
					
					msg = "쿠폰 입력 성공!";
					href = "/pro/";
					
					model.addAttribute("msg", msg);
					model.addAttribute("href", href);
				}else {
					msg = "쿠폰 입력 실패!";
					href = "/pro/";
					
					model.addAttribute("msg", msg);
					model.addAttribute("href", href);
				}
			}else {
				msg = "이미 등록하신 쿠폰입니다!";
				href = "/pro/";
				
				model.addAttribute("msg", msg);
				model.addAttribute("href", href);
			}
			
		}
		
		return "/WEB-INF/views/users/mypage/result.jsp";
	}
	
	
}