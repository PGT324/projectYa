package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.HPointVO;
import vo.H_Res;
import vo.Hotel;
import vo.MPointVO;
import vo.M_Coupon;
import vo.M_Res;
import vo.M_Room;
import vo.Motel;
import vo.MyLikeMVO;
import vo.ThemeVO;
import vo.Users_CouponVO;

public class MotelDao {
	
	private SqlSession sqlSession;
	
	public MotelDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Motel> motelList(int m_region1_idx, int m_region2_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		
		return sqlSession.selectList("motel.motelList", map);
	}
	
	public List<M_Room> mRoomList(int m_region1_idx, int m_region2_idx, int motel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		
		return sqlSession.selectList("motel.mRoomList", map);
	}
	
	public List<M_Room> mRoomRes(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		map.put("m_room_idx", m_room_idx);
		
		return sqlSession.selectList("motel.mRoomRes", map);
	}
	
	public int insertMotelRes(M_Res m_res) {
		return sqlSession.insert("motel.insertMotelRes", m_res);
	}
	
	public int insertMotelNoCoupon(M_Res m_res) {
		return sqlSession.insert("motel.insertMotelNoCoupon", m_res);
	}

	
	public List<String> checkin(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		map.put("m_room_idx", m_room_idx);
		
		return sqlSession.selectList("motel.checkin", map);
	}
	
	public List<String> checkout(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		map.put("m_room_idx", m_room_idx);
		
		return sqlSession.selectList("motel.checkout", map);
	}
	
	public int updateRoomNumber(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx, int room_number) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		map.put("m_room_idx", m_room_idx);
		map.put("room_number", room_number);
		
		return sqlSession.update("motel.updateRoomNumber", map);
	}
	
	public List<M_Coupon> motelCoupon() {
		return sqlSession.selectList("motel.motelCoupon");
	}
	
	public List<M_Coupon> motelCouponIdx(int m_coupon_idx) {
		return sqlSession.selectList("motel.motelCouponIdx", m_coupon_idx);
	}
	
	public List<M_Res> motelResPhone(String res_phone, String res_number) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("res_phone", res_phone);
		map.put("res_number", res_number);
		
		return sqlSession.selectList("motel.motelResPhone", map);
	}
	
	public String motelName(int m_region1_idx, int m_region2_idx, int motel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		
		return sqlSession.selectOne("motel.motelName", map);
	}
	
	public List<M_Room> motelRoomInfo(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		map.put("m_room_idx", m_room_idx);
		
		return sqlSession.selectList("motel.motelRoomInfo", map);
	}
	
	public List<Motel> motelListOne(int m_region1_idx, int m_region2_idx, int motel_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		
		return sqlSession.selectList("motel.motelList", map);
	}
	
	public List<M_Res> motelResIdx(int m_res_idx) {
		
		return sqlSession.selectList("motel.motelResIdx", m_res_idx);
	}
	
	public int motelReviewStar(int m_region1_idx, int m_region2_idx, int motel_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		
		return sqlSession.selectOne("review.motelReviewStar", map);
	}
	
	public int insertLikeM(MyLikeMVO vo) {
		return sqlSession.insert("mylike.insertLikeM", vo);
	}
	
	public int likeListMotel(MyLikeMVO vo) {
		return sqlSession.selectOne("mylike.likeListMotel", vo);
	}
	
	public int updateMotelHeartIn(MyLikeMVO vo) {
		return sqlSession.update("mylike.updateMotelHeartIn", vo);
	}
	
	public int updateMotelHeartOut(MyLikeMVO vo) {
		return sqlSession.update("mylike.updateMotelHeartOut", vo);
	}
	
	public int deleteLikeM(int mylikem_idx) {
		return sqlSession.delete("mylike.deleteLikeM", mylikem_idx);
	}
	
	public int myLikeMIdx(MyLikeMVO vo) {
		return sqlSession.selectOne("mylike.mylikemIdx", vo);
	}
	
	public List<Integer> idxFromUsers(int users_idx) {
		return sqlSession.selectList("mylike.idxFromUsers", users_idx);
	}
	
	public int motelHeartAll() {
		return sqlSession.update("mylike.motelHeartAll");
	}
	
	public int mHeartFromIdx(int motel_idx) {
		return sqlSession.update("mylike.mHeartFromIdx", motel_idx);
	}
	
	public int insertMPoint(MPointVO vo) {
		return sqlSession.insert("point.insertMPoint", vo);
	}
	
	public int maxIdx() {
		return sqlSession.selectOne("motel.maxIdx");
	}
	
	public int cancelRes(int m_res_idx) {
		return sqlSession.delete("motel.cancelRes", m_res_idx);
	}
	
	public int cancelPointM(int users_idx, int m_res_idx) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("users_idx", users_idx);
		map.put("m_res_idx", m_res_idx);
		
		return sqlSession.delete("point.cancelPointM", map);
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectMPointFromIdx", users_idx);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectHPointFromIdx", users_idx);
	}
	
	public List<H_Res> hotelResIdx(int h_res_idx) {
		
		return sqlSession.selectList("hotel.hotelResIdx", h_res_idx);
	}
	
	public int updatePoint(int users_idx, int point) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("users_idx", users_idx);
		map.put("point", point);
		
		return sqlSession.update("users.updatePoint", map);
	}
	
	public List<M_Res> mresInfo(int m_res_idx) {
		return sqlSession.selectList("point.mresInfo", m_res_idx);
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
	
	public List<ThemeVO> motelTheme(int theme_idx) {
		return sqlSession.selectList("motel.motelTheme", theme_idx);
	}
	
	public String motelOne(int motel_idx) {
		return sqlSession.selectOne("motel.motelOne", motel_idx);
	}
}



















