package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

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


public class HotelDao {
	
	private SqlSession sqlSession;
	
	public HotelDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Hotel> hotelList(int h_region1_idx, int h_region2_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		
		return sqlSession.selectList("hotel.hotelList", map);
	}
	
	public List<H_Room> hRoomList(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		
		return sqlSession.selectList("hotel.hRoomList", map);
	}
	
	public List<H_Room> hRoomRes(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		map.put("h_room_idx", h_room_idx);
		
		return sqlSession.selectList("hotel.hRoomRes", map);
	}
	
	public int insertHotelRes(H_Res h_res) {
		return sqlSession.insert("hotel.insertHotelRes", h_res);
	}
	
	public int insertHotelNoCoupon(H_Res h_res) {
		return sqlSession.insert("hotel.insertHotelNoCoupon", h_res);
	}
	
	
	public List<String> checkin(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		map.put("h_room_idx", h_room_idx);
		
		return sqlSession.selectList("hotel.checkin", map);
	}
	
	public List<String> checkout(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		map.put("h_room_idx", h_room_idx);
		
		return sqlSession.selectList("hotel.checkout", map);
	}
	
	public int updateRoomNumber(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx, int room_number) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		map.put("h_room_idx", h_room_idx);
		map.put("room_number", room_number);
		
		return sqlSession.update("hotel.updateRoomNumber", map);
	}
	
	public List<H_Coupon> hotelCoupon() {
		return sqlSession.selectList("hotel.hotelCoupon");
	}
	
	public List<H_Coupon> hotelCouponIdx(int h_coupon_idx) {
		return sqlSession.selectList("hotel.hotelCouponIdx", h_coupon_idx);
	}
	
	public List<H_Res> hotelResPhone(String res_phone, String res_number) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("res_phone", res_phone);
		map.put("res_number", res_number);
		
		return sqlSession.selectList("hotel.hotelResPhone", map);
	}
	
	public String hotelName(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		
		return sqlSession.selectOne("hotel.hotelName", map);
	}
	
	public List<H_Room> hotelRoomInfo(int h_region1_idx, int h_region2_idx, int hotel_idx, int h_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		map.put("h_room_idx", h_room_idx);
		
		return sqlSession.selectList("hotel.hotelRoomInfo", map);
	}
	
	public List<Hotel> hotelListOne(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		
		return sqlSession.selectList("hotel.hotelList", map);
	}
	
	public List<H_Res> hotelResIdx(int h_res_idx) {
		
		return sqlSession.selectList("hotel.hotelResIdx", h_res_idx);
	}
	
	public int hotelReviewStar(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		
		return sqlSession.selectOne("review.hotelReviewStar", map);
	}
	
	public int insertLikeH(MyLikeHVO vo) {
		return sqlSession.insert("mylike.insertLikeH", vo);
	}
	
	public int likeListHotel(MyLikeHVO vo) {
		return sqlSession.selectOne("mylike.likeListHotel", vo);
	}
	
	public int updateHotelHeartIn(MyLikeHVO vo) {
		return sqlSession.update("mylike.updateHotelHeartIn", vo);
	}
	
	public int updateHotelHeartOut(MyLikeHVO vo) {
		return sqlSession.update("mylike.updateHotelHeartOut", vo);
	}
	
	public int deleteLikeH(int mylikeh_idx) {
		return sqlSession.delete("mylike.deleteLikeH", mylikeh_idx);
	}
	
	public int myLikeHIdx(MyLikeHVO vo) {
		return sqlSession.selectOne("mylike.mylikehIdx", vo);
	}
	
	public List<Integer> idxFromUsersH(int users_idx) {
		return sqlSession.selectList("mylike.idxFromUsersH", users_idx);
	}
	
	public int hotelHeartAll() {
		return sqlSession.update("mylike.hotelHeartAll");
	}
	
	public int hHeartFromIdx(int hotel_idx) {
		return sqlSession.update("mylike.hHeartFromIdx", hotel_idx);
	}
	
	public int insertHPoint(HPointVO vo) {
		return sqlSession.insert("point.insertHPoint", vo);
	}
	
	public int maxIdx() {
		return sqlSession.selectOne("hotel.maxIdx");
	}
	
	public int cancelRes(int h_res_idx) {
		return sqlSession.delete("hotel.cancelRes", h_res_idx);
	}
	
	public int cancelPointH(int users_idx, int h_res_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("users_idx", users_idx);
		map.put("h_res_idx", h_res_idx);
		
		return sqlSession.delete("point.cancelPointH", map);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectHPointFromIdx", users_idx);
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectMPointFromIdx", users_idx);
	}
	
	public List<M_Res> motelResIdx(int m_res_idx) {
		
		return sqlSession.selectList("motel.motelResIdx", m_res_idx);
	}
	
	public int updatePoint(int users_idx, int point) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("users_idx", users_idx);
		map.put("point", point);
		
		return sqlSession.update("users.updatePoint", map);
	}
	
	public List<H_Res> hresInfo(int h_res_idx) {
		return sqlSession.selectList("point.hresInfo", h_res_idx);
	}
	
	public int usersPoint(int users_idx) {
		return sqlSession.selectOne("point.usersPoint", users_idx);
	}
	
	public int selectUse(int users_idx) {
		return sqlSession.selectOne("point.selectUse", users_idx);
	}
	
	public int updateUse(int users_idx, int use) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("users_idx", users_idx);
		map.put("use", use);
		
		return sqlSession.update("point.updateUse", map);
	}
	
	public List<Users_CouponVO> ucSelect(int users_idx) {
		return sqlSession.selectList("usersCoupon.ucSelect", users_idx);
	}
	
	public int ucDelete(int users_coupon_idx) {
		return sqlSession.delete("usersCoupon.ucDelete", users_coupon_idx);
	}
	
	public List<ThemeVO> hotelTheme(int theme_idx) {
		return sqlSession.selectList("hotel.hotelTheme", theme_idx);
	}
	
	public String hotelOne(int hotel_idx) {
		return sqlSession.selectOne("hotel.hotelOne", hotel_idx);
	}

}
