package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.HomeService;

@Controller
public class HomeController {
	
	private HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping("/")
	public String home() {
		return ViewPath.PRO + "index.jsp";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "/WEB-INF/views/search/main.jsp";
	}
	
	@RequestMapping("/users/mypage/seller")
	public String seller() {
		return "/WEB-INF/views/users/mypage/seller.jsp";
	}
	
	@RequestMapping("/qalist")
	public String qalist() {
		return "/WEB-INF/views/users/mypage/qalist.jsp";
	}

}
