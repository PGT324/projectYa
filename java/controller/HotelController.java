package controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.HotelService;
import vo.HPointVO;
import vo.H_Coupon;
import vo.H_Res;
import vo.H_Room;
import vo.Hotel;
import vo.MPointVO;
import vo.M_Res;
import vo.M_Room;
import vo.Motel;
import vo.MyLikeHVO;
import vo.MyLikeMVO;
import vo.Users_CouponVO;


@Controller
public class HotelController {
	
	private HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	@RequestMapping("/hotel/hotellist")
	public String hotelList(Model model, int h_region1_idx, int h_region2_idx, int users_idx) {
		
		
		List<Double> star = new ArrayList<Double>();
		List<Integer> intList = hotelService.idxFromUsersH(users_idx);
		
		
		hotelService.hotelHeartAll();
		
		if(!intList.isEmpty()) {
			for (int i = 0; i < intList.size(); i++) {
				hotelService.hHeartFromIdx(intList.get(i));
			}
		}
		
		
		List<Hotel> list = hotelService.hotelList(h_region1_idx, h_region2_idx);
		for (int i = 0; i < list.size(); i++) {
			int a = hotelService.hotelReviewStar(h_region1_idx, h_region2_idx, list.get(i).getHotel_idx());
			
			double d = a/4.0;
			star.add(d);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("star", star);
		
		return ViewPath.HOTEL + "hotellist.jsp";
	}
	
	@RequestMapping("/hotel/checkdate")
	public String checkDate(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, String checkin, String checkout, int max_date, int users_idx) {
		
		int value = 0;
		
		String checkin1 = checkin.replaceAll("-", "");
		String checkout1 = checkout.replaceAll("-", "");
		
		LocalDate l = LocalDate.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		String now = f.format(l);
		int today = Integer.parseInt(now);
		
		int in = Integer.parseInt(checkin1);
		int out = Integer.parseInt(checkout1);
		
		if(out<=in) {
			model.addAttribute("h_region1_idx", h_region1_idx);
			model.addAttribute("h_region2_idx", h_region2_idx);
			
			return ViewPath.HOTEL + "result.jsp";
		}else if((out-in)>max_date) {
			model.addAttribute("m_region1_idx", h_region1_idx);
			model.addAttribute("m_region2_idx", h_region2_idx);
			
			return ViewPath.MOTEL + "maxdateresult.jsp";
		}else if(in < today) {
			model.addAttribute("h_region1_idx", h_region1_idx);
			model.addAttribute("h_region2_idx", h_region2_idx);
			
			return ViewPath.HOTEL + "result.jsp";
		}else {
			
			//point check
			List<MPointVO> point1 = hotelService.selectMPointFromIdx(users_idx);
			List<HPointVO> point2 = hotelService.selectHPointFromIdx(users_idx);
			for (int i = 0; i < point1.size(); i++) {
				List<M_Res> mres = hotelService.motelResIdx(point1.get(i).getM_res_idx());
				int ci = Integer.parseInt(mres.get(0).getCheckin().replaceAll("-", ""));
				if(ci-today<2) {
					value = value + point1.get(i).getValue();
				}
			}
			for (int i = 0; i < point2.size(); i++) {
				List<H_Res> hres = hotelService.hotelResIdx(point2.get(i).getH_res_idx());
				int ci = Integer.parseInt(hres.get(0).getCheckin().replaceAll("-", ""));
				if(ci-today<2) {
					value = value + point2.get(i).getValue();
				}
			}
			
			int use = hotelService.selectUse(users_idx);
			value = value - use;
			
			hotelService.updatePoint(users_idx, value);
			
			List<H_Room> list = hotelService.hRoomList(h_region1_idx, h_region2_idx, hotel_idx);
			List<H_Room> list_backup = list;
			
			for (int i = 0; i < list.size(); i++) {
				List<String> list1 = hotelService.checkin(h_region1_idx, h_region2_idx, hotel_idx, list.get(i).getH_room_idx());
				List<String> list2 = hotelService.checkout(h_region1_idx, h_region2_idx, hotel_idx, list.get(i).getH_room_idx());
				int rn = list.get(i).getRoom_number();
				
				for (int j = 0; j < list1.size(); j++) {
					int ci = Integer.parseInt((list1.get(j)).replaceAll("-", ""));
					int co = Integer.parseInt((list2.get(j)).replaceAll("-", ""));
					
					if(ci < out && co > in) {
						
						rn--;
					}
				}

				hotelService.updateRoomNumber(h_region1_idx, h_region2_idx, hotel_idx, list.get(i).getH_room_idx(), rn);
			}
			
			list = hotelService.hRoomList(h_region1_idx, h_region2_idx, hotel_idx);
			
			List<H_Coupon> couponList = hotelService.hotelCoupon();
			List<Users_CouponVO> ucList = hotelService.ucSelect(users_idx);
			if(!ucList.isEmpty()) {
				model.addAttribute("ucList", ucList);
			}
			
			model.addAttribute("list", list);
			model.addAttribute("couponList", couponList);
			model.addAttribute("checkin", checkin);
			model.addAttribute("checkout", checkout);
			model.addAttribute("value", value);
			
			for (int i = 0; i < list_backup.size(); i++) {
				hotelService.updateRoomNumber(h_region1_idx, h_region2_idx, hotel_idx, list_backup.get(i).getH_room_idx(), list_backup.get(i).getRoom_number());
			}
			
			return ViewPath.HOTEL + "hroomlist.jsp";
		}
	}
	
	
	@RequestMapping("/hotel/hroomlist")
	public String hRoomList(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx) {
		
		List<H_Room> list = hotelService.hRoomList(h_region1_idx, h_region2_idx, hotel_idx);
		
		model.addAttribute("list", list);
		
		return ViewPath.HOTEL + "hroomlist.jsp";
	}
	
	@RequestMapping("/res/h_res")
	public String h_res(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx, 
			String checkin, String checkout, int person_size, String day_price, String h_coupon_idx, int users_idx, String point, String value) {
		
		List<H_Room> list = hotelService.hRoomRes(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
		
		String checkin1 = checkin.replaceAll("-", "");
		String checkout1 = checkout.replaceAll("-", "");
		
		int in = Integer.parseInt(checkin1);
		int out = Integer.parseInt(checkout1);
		
		int sum = 0;
		int h_coupon_idx1 = 0;
		
		int total_price = Integer.parseInt(day_price.replaceAll(",", "")) * (out - in);
		int coupon_price = 0;
		
		if(h_coupon_idx.contains("%")) {
			int c =  Integer.parseInt(h_coupon_idx.replaceAll("%", ""));
			
			coupon_price = total_price - (total_price / 100 * c);
			
			h_coupon_idx1 = hotelService.ucSelect(users_idx).get(0).getUsers_coupon_idx();
		}else {
			h_coupon_idx1 = Integer.parseInt(h_coupon_idx);

			if(h_coupon_idx1 != 0) {
				
				List<H_Coupon> couponList = hotelService.hotelCouponIdx(h_coupon_idx1);
				if(couponList.get(0).getName().contains("%")) {
					coupon_price = total_price - (total_price / 100 * couponList.get(0).getSale());
				}else {
					coupon_price = total_price - couponList.get(0).getSale();
				}
				
			}else {
				coupon_price = total_price;
			}
		}
		
		if(!point.equals("")) {
			coupon_price = coupon_price - Integer.parseInt(point);
			
			sum = Integer.parseInt(value) - Integer.parseInt(point);
			
		}else {
			point = "0";
		}
		
		DecimalFormat f = new DecimalFormat("###,###"); 
		String total = f.format(total_price);
		String coupon = f.format(coupon_price);
		
		model.addAttribute("list", list);
		model.addAttribute("checkin", checkin);
		model.addAttribute("checkout", checkout);
		model.addAttribute("total_price", total);
		model.addAttribute("coupon_price", coupon);
		model.addAttribute("person_size", person_size);
		model.addAttribute("h_coupon_idx", h_coupon_idx1);
		model.addAttribute("sum", sum);
		model.addAttribute("point", point);
		
		return "/WEB-INF/views/res/h_res.jsp";
	}
	
	@RequestMapping("/res/resulthotel")
	public String insertHotelRes(Model model, H_Res h_res, int users_idx, String sum, String point) {
		
			String msg = "";
			String res_phone = h_res.getRes_phone().replaceAll("-", "");
			String use_phone = h_res.getUse_phone().replaceAll("-", "");
			h_res.setRes_phone(res_phone);
			h_res.setUse_phone(use_phone);
			
			LocalDate d = LocalDate.now();
			DateTimeFormatter d1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			String date = d.format(d1);
		    
			date = date.replaceAll("-", "");
			int idate = Integer.parseInt(date);
			
			int res_number = idate + ((int) (Math.random() * 10000000)+1);
			h_res.setRes_number(res_number);
			
			
			int i = 0;
			
			if(h_res.getH_coupon_idx() != 0) {
				i = hotelService.insertHotelRes(h_res);
			}else {
				i = hotelService.insertHotelNoCoupon(h_res); 
			}
			
			
			if(i != 0) {
				
				int max = hotelService.maxIdx();
				int value = Integer.parseInt(h_res.getTotal_price().replaceAll(",", ""))/100;
				
				HPointVO vo = new HPointVO();
				
				vo.setUsers_idx(users_idx);
				vo.setH_res_idx(max);
				vo.setValue(value);
				
				hotelService.insertHPoint(vo);
				hotelService.updatePoint(users_idx, Integer.parseInt(sum));
				
				hotelService.updateUse(users_idx, Integer.parseInt(point) + hotelService.selectUse(users_idx));
				
				hotelService.ucDelete(h_res.getH_coupon_idx());
				
				msg = "예약 성공! 예약번호는 " + res_number + "입니다!";
				
				model.addAttribute("msg", msg);
				
				return ViewPath.RES + "resulthotel.jsp";
			}else {
				msg = "예약 실패!";
				
				model.addAttribute("msg", msg);
				
				return ViewPath.RES + "resulthotel.jsp";
			}
	}
	

	@RequestMapping("/res/hotel")
	public String hotelResList(Model model, String res_phone, String res_number) {
		
		String res_phone1 = res_phone.replaceAll("-", "");
		
		List<H_Res> list = hotelService.hotelResPhone(res_phone1, res_number);
		if(list.isEmpty()) {
			return ViewPath.RES + "result.jsp";
		}
		List<String> hotelName = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			String name = hotelService.hotelName(list.get(i).getH_region1_idx(), list.get(i).getH_region2_idx(), list.get(i).getHotel_idx());
			hotelName.add(name);
			list.get(i).setRes_phone(res_phone);
		}
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		
		int n = Integer.parseInt(formatedNow.replaceAll("-", ""));
		int ci = Integer.parseInt(list.get(0).getCheckin().replaceAll("-", ""));
		
		int check = 0;
		
		if((ci - n) > 1) {
			check = 1;
		}else {
			check = 0;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("hotelName", hotelName);
		model.addAttribute("check", check);
		
		return ViewPath.RES + "hotelresphone.jsp";
	}
	
	@RequestMapping("/res/hotelroominfo")
	public String hotelRoomInfo(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx, int h_res_idx) {
		List<H_Room> list = hotelService.hotelRoomInfo(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("h_res_idx", h_res_idx);
		
		return ViewPath.RES + "hotelroominfo.jsp";
		
	}
	
	@RequestMapping("/review/hotelinput")
	public String hotelReview(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx, int h_res_idx) {
		
		List<H_Room> list = hotelService.hotelRoomInfo(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
		List<Hotel> list1 = hotelService.hotelListOne(h_region1_idx, h_region2_idx, hotel_idx);
		List<H_Res> list2 = hotelService.hotelResIdx(h_res_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		
		return "/WEB-INF/views/review/hotelinput.jsp";
	}
	
	@RequestMapping("/mylikehotel")
	public String myLikeHotel(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int users_idx) {
		
		List<Hotel> list = hotelService.hotelList(h_region1_idx, h_region2_idx);
		List<Integer> number = new ArrayList<Integer>();
		
		MyLikeHVO vo = new MyLikeHVO();
		
		vo.setUsers_idx(users_idx);
		vo.setH_region1_idx(h_region1_idx);
		vo.setH_region2_idx(h_region2_idx);
		
		
		for (int i = 0; i < list.size(); i++) {
			
			vo.setHotel_idx(list.get(i).getHotel_idx());
			
			int n = hotelService.likeListHotel(vo);
			number.add(n);
		}
		
		vo.setHotel_idx(hotel_idx);
		
		int i = hotelService.insertLikeH(vo);
		
		if(i != 0) {
			
			model.addAttribute("number", number);
			model.addAttribute("h_region1_idx", h_region1_idx);
			model.addAttribute("h_region2_idx", h_region2_idx);
			model.addAttribute("users_idx", users_idx);
			
			hotelService.updateHotelHeartIn(vo);
			
			return "redirect:/hotel/hotellist";
		}else {
			return ViewPath.PRO + "index.jsp";
		}
	}
	
	
	@RequestMapping("/mylikedeletehotel")
	public String myLikeDeleteHotel(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int users_idx) {
		
		MyLikeHVO vo = new MyLikeHVO();
		
		vo.setUsers_idx(users_idx);
		vo.setH_region1_idx(h_region1_idx);
		vo.setH_region2_idx(h_region2_idx);
		vo.setHotel_idx(hotel_idx);
		
		int mylikeh_idx = hotelService.myLikeHIdx(vo);
		
		
		int i = hotelService.deleteLikeH(mylikeh_idx);
		
		if(i != 0) {
			
			model.addAttribute("h_region1_idx", h_region1_idx);
			model.addAttribute("h_region2_idx", h_region2_idx);
			model.addAttribute("users_idx", users_idx);
			
			hotelService.updateHotelHeartOut(vo);
		}
		
		return "redirect:/hotel/hotellist";
	}
	
	@RequestMapping("/hotel/onelist")
	public String oneList(Model model, int h_region1_idx, int h_region2_idx, int hotel_idx, int users_idx) {
		
		List<Double> star = new ArrayList<Double>();
		List<Integer> intList = hotelService.idxFromUsersH(users_idx);
		
		hotelService.hotelHeartAll();
		
		if(!intList.isEmpty()) {
			for (int i = 0; i < intList.size(); i++) {
				hotelService.hHeartFromIdx(intList.get(i));
			}
		}
		
		List<Hotel> list = hotelService.hotelListOne(h_region1_idx, h_region2_idx, hotel_idx);
		
		for (int i = 0; i < list.size(); i++) {
			int a = hotelService.hotelReviewStar(h_region1_idx, h_region2_idx, list.get(i).getHotel_idx());
			
			double d = a/4.0;
			star.add(d);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("star", star);
		
		
		return ViewPath.HOTEL + "hotellist.jsp";
	}
	
	
	//삭제 성공!
	@RequestMapping("/hdelete")
	public String delete(Model model, int users_idx, int h_res_idx) {
		
		int point = 0;
		int userPoint = 0;
		
		point = hotelService.hresInfo(h_res_idx).get(0).getPoint();
		
		userPoint = hotelService.usersPoint(users_idx);
		
		point = point + userPoint;
		
		hotelService.cancelPointH(users_idx, h_res_idx);
		int i = hotelService.cancelRes(h_res_idx);
		String msg = "";
		
		
		
		if(i != 0) {
			
			hotelService.updatePoint(users_idx, point);
			
			msg = "삭제 성공!";
			model.addAttribute("msg", msg);
			return "/WEB-INF/views/res/resulthotel.jsp";
		}else {
			msg = "삭제 실패!";
			model.addAttribute("msg", msg);
			return "/WEB-INF/views/res/resulthotel.jsp";
		}
		
	}
	
	@RequestMapping("/hotel/theme")
	public String theme(Model model ,int hotel_idx) {
		
		String theme = hotelService.hotelOne(hotel_idx);
		
		String[] arr = theme.split(",");
		
		List<String> image = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		
		for (int i = 0; i < arr.length; i++) {
			image.add(hotelService.hotelTheme(Integer.parseInt(arr[i])).get(0).getImage());
			name.add(hotelService.hotelTheme(Integer.parseInt(arr[i])).get(0).getName());
		}
		
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		
		return "/WEB-INF/views/hotel/theme.jsp";
	}
}
