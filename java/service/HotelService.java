package service;

import java.util.List;

import dao.HotelDao;
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
import vo.ThemeVO;
import vo.Users_CouponVO;


public class HotelService {
	
	private HotelDao hotelDao;
	
	public HotelService(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}
	
	public List<Hotel> hotelList(int h_region1_idx, int h_region2_idx) {
		return hotelDao.hotelList(h_region1_idx, h_region2_idx);
	}
	
	public List<H_Room> hRoomList(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		return hotelDao.hRoomList(h_region1_idx, h_region2_idx, hotel_idx);
	}
	
	public List<H_Room> hRoomRes(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		return hotelDao.hRoomRes(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
	}
	
	public int insertHotelRes(H_Res h_res) {
		return hotelDao.insertHotelRes(h_res);
	}
	
	public int insertHotelNoCoupon(H_Res h_res) {
		return hotelDao.insertHotelNoCoupon(h_res);
	}
	
	public List<String> checkin(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		return hotelDao.checkin(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
	}
	
	public List<String> checkout(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		return hotelDao.checkout(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
	}
	
	public int updateRoomNumber(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx, int room_number) {
		return hotelDao.updateRoomNumber(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx, room_number);
	}
	
	public List<H_Coupon> hotelCoupon() {
		return hotelDao.hotelCoupon();
	}
	
	public List<H_Coupon> hotelCouponIdx(int h_coupon_idx) {
		return hotelDao.hotelCouponIdx(h_coupon_idx);
	}
	
	public List<H_Res> hotelResPhone(String res_phone, String res_number) {
		return hotelDao.hotelResPhone(res_phone, res_number);
	}
	
	public String hotelName(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		return hotelDao.hotelName(h_region1_idx, h_region2_idx, hotel_idx);
	}
	
	public List<H_Room> hotelRoomInfo(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		return hotelDao.hotelRoomInfo(h_region1_idx, h_region2_idx, hotel_idx, h_room_idx);
	}
	
	public List<Hotel> hotelListOne(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		return hotelDao.hotelListOne(h_region1_idx, h_region2_idx, hotel_idx);
	}
	
	
	public List<H_Res> hotelResIdx(int h_res_idx) {
		return hotelDao.hotelResIdx(h_res_idx);
	}
	
	public int hotelReviewStar(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		return hotelDao.hotelReviewStar(h_region1_idx, h_region2_idx, hotel_idx);
	}
	
	public int insertLikeH(MyLikeHVO vo) {
		return hotelDao.insertLikeH(vo);
	}
	
	public int likeListHotel(MyLikeHVO vo) {
		return hotelDao.likeListHotel(vo);
	}
	
	public int updateHotelHeartIn(MyLikeHVO vo) {
		return hotelDao.updateHotelHeartIn(vo);
	}
	
	public int updateHotelHeartOut(MyLikeHVO vo) {
		return hotelDao.updateHotelHeartOut(vo);
	}
	
	public int deleteLikeH(int mylikeh_idx) {
		return hotelDao.deleteLikeH(mylikeh_idx);
	}
	
	public int myLikeHIdx(MyLikeHVO vo) {
		return hotelDao.myLikeHIdx(vo);
	}
	
	public List<Integer> idxFromUsersH(int users_idx) {
		return hotelDao.idxFromUsersH(users_idx);
	}
	
	public int hotelHeartAll() {
		return hotelDao.hotelHeartAll();
	}
	
	public int hHeartFromIdx(int hotel_idx) {
		return hotelDao.hHeartFromIdx(hotel_idx);
	}
	
	public int insertHPoint(HPointVO vo) {
		return hotelDao.insertHPoint(vo);
	}
	
	public int maxIdx() {
		return hotelDao.maxIdx();
	}
	
	public int cancelRes(int h_res_idx) {
		return hotelDao.cancelRes(h_res_idx);
	}
	
	public int cancelPointH(int users_idx, int h_res_idx) {
		return hotelDao.cancelPointH(users_idx, h_res_idx);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return hotelDao.selectHPointFromIdx(users_idx);
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return hotelDao.selectMPointFromIdx(users_idx);
	}
	
	public List<M_Res> motelResIdx(int m_res_idx) {
		return hotelDao.motelResIdx(m_res_idx);
	}
	
	public int updatePoint(int users_idx, int point) {
		return hotelDao.updatePoint(users_idx, point);
	}
	
	public List<H_Res> hresInfo(int h_res_idx) {
		return hotelDao.hresInfo(h_res_idx);
	}
	
	public int usersPoint(int users_idx) {
		return hotelDao.usersPoint(users_idx);
	}
	
	public int selectUse(int users_idx) {
		return hotelDao.selectUse(users_idx);
	}
	
	public int updateUse(int users_idx, int use) {
		return hotelDao.updateUse(users_idx, use);
	}
	
	public List<Users_CouponVO> ucSelect(int users_idx) {
		return hotelDao.ucSelect(users_idx);
	}
	
	public int ucDelete(int users_coupon_idx) {
		return hotelDao.ucDelete(users_coupon_idx);
	}
	
	public List<ThemeVO> hotelTheme(int theme_idx) {
		return hotelDao.hotelTheme(theme_idx);
	}
	
	public String hotelOne(int hotel_idx) {
		return hotelDao.hotelOne(hotel_idx);
	}

}
