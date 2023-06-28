package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MyLikeService;
import vo.Hotel;
import vo.Motel;
import vo.MyLikeHVO;
import vo.MyLikeMVO;

@Controller
public class MyLikeController {
	
	private MyLikeService myLikeService;
	
	public MyLikeController(MyLikeService myLikeService) {
		this.myLikeService = myLikeService;
	}
	
	@RequestMapping("/like/mylike")
	public String mLikeList(Model model, int users_idx) {
		
		List<MyLikeMVO> list1 = myLikeService.mLikeList(users_idx);
		List<MyLikeHVO> list2 = myLikeService.hLikeList(users_idx);
		
		List<Double> star1 = new ArrayList<Double>();
		List<Double> star2 = new ArrayList<Double>();
		
		List<Motel> list3 = new ArrayList<Motel>();
		List<Hotel> list4 = new ArrayList<Hotel>();
		
		for (int i = 0; i < list1.size(); i++) {
			list3.add(myLikeService.motelFromLike(list1.get(i).getMotel_idx()));
			
			int a = myLikeService.motelReviewStar(list1.get(i).getM_region1_idx(), list1.get(i).getM_region2_idx(), list1.get(i).getMotel_idx());
			
			double d = a/4.0;
			star1.add(d);
		}
		for (int i = 0; i < list2.size(); i++) {
			list4.add(myLikeService.hotelFromLike(list2.get(i).getHotel_idx()));
			
			int a = myLikeService.hotelReviewStar(list2.get(i).getH_region1_idx(), list2.get(i).getH_region2_idx(), list2.get(i).getHotel_idx());
			
			double d = a/4.0;
			star2.add(d);
		}
		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("list4", list4);
		model.addAttribute("star1", star1);
		model.addAttribute("star2", star2);
		
		return "/WEB-INF/views/like/mylike.jsp";
	}

}
