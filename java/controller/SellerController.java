package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.SellerService;
import vo.SellerVO;

@Controller
public class SellerController {
	
	private SellerService sellerService;
	
	public SellerController(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	
	@RequestMapping("/insert")
	public String insert(Model model, SellerVO vo) {
		
		vo.setStatus(1);
		
		List<SellerVO> list = sellerService.selectSeller(vo.getUsers_idx());
		
		String msg = "";
		String href = "";
		
		if(!list.isEmpty()) {
			
			sellerService.updateSeller(vo);
			
			msg = "사업자 등록 성공!";
			href = "/pro/";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/users/mypage/sellerresult.jsp";
		}else {
			
			int i = sellerService.insertSeller(vo);
			
			if(i != 0) {
				msg = "사업자 등록 성공!";
				href = "/pro/";
				
				model.addAttribute("msg", msg);
				model.addAttribute("href", href);
				
				return "/WEB-INF/views/users/mypage/sellerresult.jsp";
			}else {
				msg = "사업자 등록 실패!";
				href = "/pro/";
				
				model.addAttribute("msg", msg);
				model.addAttribute("href", href);
				
				return "/WEB-INF/views/users/mypage/sellerresult.jsp";
			}
		}
	}
	
	@RequestMapping("/out")
	public String out() {
		return "/WEB-INF/views/users/mypage/outseller.jsp";
	}
	
	
	
	@RequestMapping("/outseller")
	public String outSeller(Model model, int snumber) {

		int i = sellerService.updateStatus(snumber);
		
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "사업자 해지 성공!";
			href = "/pro/";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/users/mypage/sellerresult.jsp";
		}else {
			msg = "사업자 해지 실패!";
			href = "/pro/";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/users/mypage/sellerresult.jsp";
		}
	}

}
