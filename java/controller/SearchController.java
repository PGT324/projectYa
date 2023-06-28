package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SearchService;
import vo.Hotel;
import vo.Motel;

@Controller
public class SearchController {
	
	private SearchService searchService;
	
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@RequestMapping("/search/list")
	public String search(Model model , String search) {
		
		List<Motel> list1 = new ArrayList<Motel>();
		List<Hotel> list2 = new ArrayList<Hotel>();
		int size = 0;
		
	
			
		list1 = searchService.searchNameM(search);
		list2 = searchService.searchNameH(search);
		
		size = list1.size() + list2.size();
		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("size", size);
		
		return "/WEB-INF/views/search/list.jsp";
		
	}

}
