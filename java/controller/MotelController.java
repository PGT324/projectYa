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
import service.MotelService;
import service.ReviewService;
import vo.HPointVO;
import vo.H_Res;
import vo.MPointVO;
import vo.M_Coupon;
import vo.M_Res;
import vo.M_Room;
import vo.Motel;
import vo.MyLikeMVO;
import vo.Users_CouponVO;

@Controller
public class MotelController {
	
	private MotelService motelService;
	
	public MotelController(MotelService motelService) {
		this.motelService = motelService;
	}
	
	
	@RequestMapping("/motel/motellist")
	public String motelList(Model model, int m_region1_idx, int m_region2_idx, int users_idx) {
		
		List<Double> star = new ArrayList<Double>();
		List<Integer> intList = motelService.idxFromUsers(users_idx);
		
		motelService.motelHeartAll();
		
		if(!intList.isEmpty()) {
			for (int i = 0; i < intList.size(); i++) {
				motelService.mHeartFromIdx(intList.get(i));
			}
		}
		
		List<Motel> list = motelService.motelList(m_region1_idx, m_region2_idx);
		
		for (int i = 0; i < list.size(); i++) {
			int a = motelService.motelReviewStar(m_region1_idx, m_region2_idx, list.get(i).getMotel_idx());
			
			double d = a/4.0;
			star.add(d);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("star", star);
		
		
		return ViewPath.MOTEL + "motellist.jsp";
	}
	
	@RequestMapping("/motel/checkdate")
	public String checkDate(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, String checkin, String checkout, int max_date, int users_idx) {
		
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
			model.addAttribute("m_region1_idx", m_region1_idx);
			model.addAttribute("m_region2_idx", m_region2_idx);
			
			return ViewPath.MOTEL + "result.jsp";
		}else if((out-in)>max_date) {
			model.addAttribute("m_region1_idx", m_region1_idx);
			model.addAttribute("m_region2_idx", m_region2_idx);
			
			return ViewPath.MOTEL + "maxdateresult.jsp";
		}else if(in < today) {
			model.addAttribute("m_region1_idx", m_region1_idx);
			model.addAttribute("m_region2_idx", m_region2_idx);
			
			return ViewPath.MOTEL + "result.jsp";
		}else {
			
			//point check
			List<MPointVO> point1 = motelService.selectMPointFromIdx(users_idx);
			List<HPointVO> point2 = motelService.selectHPointFromIdx(users_idx);
			for (int i = 0; i < point1.size(); i++) {
				List<M_Res> mres = motelService.motelResIdx(point1.get(i).getM_res_idx());
				int ci = Integer.parseInt(mres.get(0).getCheckin().replaceAll("-", ""));
				if(ci-today<2) {
					value = value + point1.get(i).getValue();
				}
			}
			
			
			
			for (int i = 0; i < point2.size(); i++) {
				List<H_Res> hres = motelService.hotelResIdx(point2.get(i).getH_res_idx());
				int ci = Integer.parseInt(hres.get(0).getCheckin().replaceAll("-", ""));
				if(ci-today<2) {
					value = value + point2.get(i).getValue();
				}
			}
			
			int use = motelService.selectUse(users_idx);
			value = value - use;
			
			motelService.updatePoint(users_idx, value);
			
			List<M_Room> list = motelService.mRoomList(m_region1_idx, m_region2_idx, motel_idx);
			List<M_Room> list_backup = list;
			
			for (int i = 0; i < list.size(); i++) {
				List<String> list1 = motelService.checkin(m_region1_idx, m_region2_idx, motel_idx, list.get(i).getM_room_idx());
				List<String> list2 = motelService.checkout(m_region1_idx, m_region2_idx, motel_idx, list.get(i).getM_room_idx());
				int rn = list.get(i).getRoom_number();
				
				for (int j = 0; j < list1.size(); j++) {
					int ci = Integer.parseInt((list1.get(j)).replaceAll("-", ""));
					int co = Integer.parseInt((list2.get(j)).replaceAll("-", ""));
					
					if(ci < out && co > in) {
						
						rn--;
					}
				}

				motelService.updateRoomNumber(m_region1_idx, m_region2_idx, motel_idx, list.get(i).getM_room_idx(), rn);
			}
			
			list = motelService.mRoomList(m_region1_idx, m_region2_idx, motel_idx);
			
			List<M_Coupon> couponList = motelService.motelCoupon();
			List<Users_CouponVO> ucList = motelService.ucSelect(users_idx);
			if(!ucList.isEmpty()) {
				model.addAttribute("ucList", ucList);
			}
			
			model.addAttribute("list", list);
			model.addAttribute("couponList", couponList);
			model.addAttribute("checkin", checkin);
			model.addAttribute("checkout", checkout);
			model.addAttribute("value", value);
			
			for (int i = 0; i < list_backup.size(); i++) {
				motelService.updateRoomNumber(m_region1_idx, m_region2_idx, motel_idx, list_backup.get(i).getM_room_idx(), list_backup.get(i).getRoom_number());
			}
			
			return ViewPath.MOTEL + "mroomlist.jsp";
		}
		
		
	}
	
	
	@RequestMapping("/motel/mroomlist")
	public String mRoomList(Model model, int m_region1_idx, int m_region2_idx, int motel_idx) {
		
		List<M_Room> list = motelService.mRoomList(m_region1_idx, m_region2_idx, motel_idx);
		
		model.addAttribute("list", list);
		
		return ViewPath.MOTEL + "mroomlist.jsp";
	}
	
	@RequestMapping("/res/m_res")
	public String m_res(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx, 
						String checkin, String checkout, int person_size, String day_price, String m_coupon_idx, int users_idx, String point, String value) {
		
		List<M_Room> list = motelService.mRoomRes(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
		
		String checkin1 = checkin.replaceAll("-", "");
		String checkout1 = checkout.replaceAll("-", "");
		
		int in = Integer.parseInt(checkin1);
		int out = Integer.parseInt(checkout1);
		
		int sum = 0;
		int m_coupon_idx1 = 0;
		
		int total_price = Integer.parseInt(day_price.replaceAll(",", "")) * (out - in);
		int coupon_price = 0;
		
		if(m_coupon_idx.contains("%")) {
			int c =  Integer.parseInt(m_coupon_idx.replaceAll("%", ""));
			
			coupon_price = total_price - (total_price / 100 * c);
			
			m_coupon_idx1 = motelService.ucSelect(users_idx).get(0).getUsers_coupon_idx();
		}else {
		
			m_coupon_idx1 = Integer.parseInt(m_coupon_idx);
			
			if(m_coupon_idx1 != 0) {
				List<M_Coupon> couponList = motelService.motelCouponIdx(m_coupon_idx1);
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
		model.addAttribute("m_coupon_idx", m_coupon_idx1);
		model.addAttribute("sum", sum);
		model.addAttribute("point", point);
		
		
		
		return "/WEB-INF/views/res/m_res.jsp";
	}
	
	@RequestMapping("/res/resultmotel")
	public String insertMotelRes(Model model, M_Res m_res, int users_idx, String sum, String point) {
		
			String msg = "";
			String res_phone = m_res.getRes_phone().replaceAll("-", "");
			String use_phone = m_res.getUse_phone().replaceAll("-", "");
			m_res.setRes_phone(res_phone);
			m_res.setUse_phone(use_phone);
			
			LocalDate d = LocalDate.now();
			DateTimeFormatter d1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			String date = d.format(d1);
		    
			date = date.replaceAll("-", "");
			int idate = Integer.parseInt(date);
			
			int res_number = idate + ((int) (Math.random() * 10000000)+1);
			m_res.setRes_number(res_number);
			
			int i = 0;
			
			if(m_res.getM_coupon_idx() != 0) {
				i = motelService.insertMotelRes(m_res);
			}else {
				i = motelService.insertMotelNoCoupon(m_res);
			}
			
			
			if(i != 0) {
				
				int max = motelService.maxIdx();
				int value = Integer.parseInt(m_res.getTotal_price().replaceAll(",", ""))/100;
				
				MPointVO vo = new MPointVO();
				
				vo.setUsers_idx(users_idx);
				vo.setM_res_idx(max);
				vo.setValue(value);
				
				motelService.insertMPoint(vo);
				motelService.updatePoint(users_idx, Integer.parseInt(sum));
				
				motelService.updateUse(users_idx, Integer.parseInt(point) + motelService.selectUse(users_idx));
				
				motelService.ucDelete(m_res.getM_coupon_idx());
				
				msg = "예약 성공! 예약번호는 " + res_number + "입니다!";
				
				model.addAttribute("msg", msg);
				
				return ViewPath.RES + "resultmotel.jsp";
			}else {
				msg = "예약 실패!";
				
				model.addAttribute("msg", msg);
				
				return ViewPath.RES + "resultmotel.jsp";
			}
	}
	
	@RequestMapping("/res/motel")
	public String motelResList(Model model, String res_phone, String res_number) {
		
		String res_phone1 = res_phone.replaceAll("-", "");
		
		List<M_Res> list = motelService.motelResPhone(res_phone1, res_number);
		if(list.isEmpty()) {
			return ViewPath.RES + "result.jsp";
		}
		List<String> motelName = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			String name = motelService.motelName(list.get(i).getM_region1_idx(), list.get(i).getM_region2_idx(), list.get(i).getMotel_idx());
			motelName.add(name);
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
		model.addAttribute("motelName", motelName);
		model.addAttribute("check", check);
		
		return ViewPath.RES + "motelresphone.jsp";
	}
	
	@RequestMapping("/res/motelroominfo")
	public String motelRoomInfo(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx, int m_res_idx) {
		List<M_Room> list = motelService.motelRoomInfo(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("m_res_idx", m_res_idx);
		
		return ViewPath.RES + "motelroominfo.jsp";
		
	}
	
	@RequestMapping("/review/motelinput")
	public String motelReview(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx, int m_res_idx) {
		
		List<M_Room> list = motelService.motelRoomInfo(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
		List<Motel> list1 = motelService.motelListOne(m_region1_idx, m_region2_idx, motel_idx);
		List<M_Res> list2 = motelService.motelResIdx(m_res_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		
		return "/WEB-INF/views/review/motelinput.jsp";
	}
	
	@RequestMapping("/mylikemotel")
	public String myLikeMotel(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int users_idx) {
		
		List<Motel> list = motelService.motelList(m_region1_idx, m_region2_idx);
		List<Integer> number = new ArrayList<Integer>();
		
		MyLikeMVO vo = new MyLikeMVO();
		
		vo.setUsers_idx(users_idx);
		vo.setM_region1_idx(m_region1_idx);
		vo.setM_region2_idx(m_region2_idx);
		
		
		for (int i = 0; i < list.size(); i++) {
			
			vo.setMotel_idx(list.get(i).getMotel_idx());
			
			int n = motelService.likeListMotel(vo);
			number.add(n);
		}
		
		vo.setMotel_idx(motel_idx);
		
		int i = motelService.insertLikeM(vo);
		
		if(i != 0) {
			
			model.addAttribute("number", number);
			model.addAttribute("m_region1_idx", m_region1_idx);
			model.addAttribute("m_region2_idx", m_region2_idx);
			model.addAttribute("users_idx", users_idx);
			
			motelService.updateMotelHeartIn(vo);
			
			return "redirect:/motel/motellist";
		}else {
			return ViewPath.PRO + "index.jsp";
		}
	}
	
	
	@RequestMapping("/mylikedeletemotel")
	public String myLikeDeleteMotel(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int users_idx) {
		
		MyLikeMVO vo = new MyLikeMVO();
		
		vo.setUsers_idx(users_idx);
		vo.setM_region1_idx(m_region1_idx);
		vo.setM_region2_idx(m_region2_idx);
		vo.setMotel_idx(motel_idx);
		
		int mylikem_idx = motelService.myLikeMIdx(vo);
		
		
		int i = motelService.deleteLikeM(mylikem_idx);
		
		if(i != 0) {
			
			model.addAttribute("m_region1_idx", m_region1_idx);
			model.addAttribute("m_region2_idx", m_region2_idx);
			model.addAttribute("users_idx", users_idx);
			
			motelService.updateMotelHeartOut(vo);
		}
		
		return "redirect:/motel/motellist";
	}

	@RequestMapping("/motel/onelist")
	public String oneList(Model model, int m_region1_idx, int m_region2_idx, int motel_idx, int users_idx) {
		
		List<Double> star = new ArrayList<Double>();
		List<Integer> intList = motelService.idxFromUsers(users_idx);
		
		motelService.motelHeartAll();
		
		if(!intList.isEmpty()) {
			for (int i = 0; i < intList.size(); i++) {
				motelService.mHeartFromIdx(intList.get(i));
			}
		}
		
		List<Motel> list = motelService.motelListOne(m_region1_idx, m_region2_idx, motel_idx);
		
		for (int i = 0; i < list.size(); i++) {
			int a = motelService.motelReviewStar(m_region1_idx, m_region2_idx, list.get(i).getMotel_idx());
			
			double d = a/4.0;
			star.add(d);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("star", star);
		
		
		return ViewPath.MOTEL + "motellist.jsp";
	}
	
	//삭제 성공!
	@RequestMapping("/mdelete")
	public String delete(Model model, int users_idx, int m_res_idx) {
		
		int point = 0;
		int userPoint = 0;
		
		point = motelService.mresInfo(m_res_idx).get(0).getPoint();
		
		userPoint = motelService.usersPoint(users_idx);
		
		point = point + userPoint;
		
		motelService.cancelPointM(users_idx, m_res_idx);
		int i = motelService.cancelRes(m_res_idx);
		String msg = "";
		
		
		
		if(i != 0) {
			
			motelService.updatePoint(users_idx, point);
			
			msg = "삭제 성공!";
			model.addAttribute("msg", msg);
			return "/WEB-INF/views/res/resultmotel.jsp";
		}else {
			msg = "삭제 실패!";
			model.addAttribute("msg", msg);
			return "/WEB-INF/views/res/resultmotel.jsp";
		}
	}
	
	@RequestMapping("/motel/theme")
	public String theme(Model model ,int motel_idx) {
		
		String theme = motelService.motelOne(motel_idx);
		
		String[] arr = theme.split(",");
		
		List<String> image = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		
		for (int i = 0; i < arr.length; i++) {
			image.add(motelService.motelTheme(Integer.parseInt(arr[i])).get(0).getImage());
			name.add(motelService.motelTheme(Integer.parseInt(arr[i])).get(0).getName());
		}
		
		model.addAttribute("image", image);
		model.addAttribute("name", name);
		
		return "/WEB-INF/views/motel/theme.jsp";
	}
}























