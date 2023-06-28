package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.PointService;
import vo.HPointVO;
import vo.H_Res;
import vo.MPointVO;
import vo.M_Res;

@Controller
public class PointController {
	
	private PointService pointService;
	
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	@RequestMapping("/mypage/point")
	public String point(Model model, int users_idx) {
		
		List<MPointVO> list1 = pointService.selectMPointFromIdx(users_idx);
		List<HPointVO> list2 = pointService.selectHPointFromIdx(users_idx);
		
		List<Integer> value1 = new ArrayList<Integer>();
		List<Integer> value2 = new ArrayList<Integer>();
		
		List<String> name1 = new ArrayList<String>();
		List<String> name2 = new ArrayList<String>();
		
		List<List<M_Res>> list3 = new ArrayList<List<M_Res>>();
		List<List<H_Res>> list4 = new ArrayList<List<H_Res>>();
		
		int totalValue = 0;
		
		for (int i = 0; i < list1.size(); i++) {
			List<M_Res> list = pointService.mresInfo(list1.get(i).getM_res_idx()); 
			
			value1.add(list1.get(i).getValue());
			name1.add(pointService.motelName(list1.get(i).getM_res_idx()));
			
			totalValue = totalValue + list1.get(i).getValue();
			
			list3.add(list);
		}
		
		for (int i = 0; i < list2.size(); i++) {
			List<H_Res> list = pointService.hresInfo(list2.get(i).getH_res_idx()); 
			value2.add(list2.get(i).getValue());
			
			totalValue = totalValue + list2.get(i).getValue();
			name2.add(pointService.hotelName(list2.get(i).getH_res_idx()));
			
			list4.add(list);
		}
		
		totalValue = pointService.usersPoint(users_idx);
		
		model.addAttribute("value1", value1);
		model.addAttribute("value2", value2);
		model.addAttribute("list3", list3);
		model.addAttribute("list4", list4);
		model.addAttribute("totalValue", totalValue);
		model.addAttribute("name1", name1);
		model.addAttribute("name2", name2);
		
		return "/WEB-INF/views/users/mypage/point.jsp";
	}
	
	@RequestMapping("/mypage/pr")
	public String pr() {
		return "/WEB-INF/views/users/mypage/pr.jsp";
	}

}
