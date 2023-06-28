package service;

import java.util.List;

import dao.MotelDao;
import vo.HPointVO;
import vo.H_Res;
import vo.MPointVO;
import vo.M_Coupon;
import vo.M_Res;
import vo.M_Room;
import vo.Motel;
import vo.MyLikeMVO;
import vo.ThemeVO;
import vo.Users_CouponVO;

public class MotelService {
	
	private MotelDao motelDao;
	
	public MotelService(MotelDao motelDao) {
		this.motelDao = motelDao;
	}
	
	public List<Motel> motelList(int m_region1_idx, int m_region2_idx) {
		return motelDao.motelList(m_region1_idx, m_region2_idx);
	}
	
	public List<M_Room> mRoomList(int m_region1_idx, int m_region2_idx, int motel_idx) {
		return motelDao.mRoomList(m_region1_idx, m_region2_idx, motel_idx);
	}
	
	public List<M_Room> mRoomRes(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		return motelDao.mRoomRes(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
	}
	
	public int insertMotelRes(M_Res m_res) {
		return motelDao.insertMotelRes(m_res);
	}
	
	public int insertMotelNoCoupon(M_Res m_res) {
		return motelDao.insertMotelNoCoupon(m_res);
	}
	
	public List<String> checkin(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		return motelDao.checkin(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
	}
	
	public List<String> checkout(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		return motelDao.checkout(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
	}
	
	public int updateRoomNumber(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx, int room_number) {
		return motelDao.updateRoomNumber(m_region1_idx, m_region2_idx, motel_idx, m_room_idx, room_number);
	}
	
	public List<M_Coupon> motelCoupon() {
		return motelDao.motelCoupon();
	}
	
	public List<M_Coupon> motelCouponIdx(int m_coupon_idx) {
		return motelDao.motelCouponIdx(m_coupon_idx);
	}
	
	public List<M_Res> motelResPhone(String res_phone, String res_number) {
		return motelDao.motelResPhone(res_phone, res_number);
	}
	
	public String motelName(int m_region1_idx, int m_region2_idx, int motel_idx) {
		return motelDao.motelName(m_region1_idx, m_region2_idx, motel_idx);
	}
	
	public List<M_Room> motelRoomInfo(int m_region1_idx, int m_region2_idx, int motel_idx, int m_room_idx) {
		return motelDao.motelRoomInfo(m_region1_idx, m_region2_idx, motel_idx, m_room_idx);
	}
	
	public List<Motel> motelListOne(int m_region1_idx, int m_region2_idx, int motel_idx) {
		return motelDao.motelListOne(m_region1_idx, m_region2_idx, motel_idx);
	}
	
	
	public List<M_Res> motelResIdx(int m_res_idx) {
		return motelDao.motelResIdx(m_res_idx);
	}
	
	public int motelReviewStar(int m_region1_idx, int m_region2_idx, int motel_idx) {
		return motelDao.motelReviewStar(m_region1_idx, m_region2_idx, motel_idx);
	}
	
	public int insertLikeM(MyLikeMVO vo) {
		return motelDao.insertLikeM(vo);
	}
	
	public int likeListMotel(MyLikeMVO vo) {
		return motelDao.likeListMotel(vo);
	}
	
	public int updateMotelHeartIn(MyLikeMVO vo) {
		return motelDao.updateMotelHeartIn(vo);
	}
	
	public int updateMotelHeartOut(MyLikeMVO vo) {
		return motelDao.updateMotelHeartOut(vo);
	}
	
	public int deleteLikeM(int mylikem_idx) {
		return motelDao.deleteLikeM(mylikem_idx);
	}
	
	public int myLikeMIdx(MyLikeMVO vo) {
		return motelDao.myLikeMIdx(vo);
	}
	
	public List<Integer> idxFromUsers(int users_idx) {
		return motelDao.idxFromUsers(users_idx);
	}
	
	public int motelHeartAll() {
		return motelDao.motelHeartAll();
	}
	
	public int mHeartFromIdx(int motel_idx) {
		return motelDao.mHeartFromIdx(motel_idx);
	}
	
	public int insertMPoint(MPointVO vo) {
		return motelDao.insertMPoint(vo);
	}
	
	public int maxIdx() {
		return motelDao.maxIdx();
	}
	
	public int cancelRes(int m_res_idx) {
		return motelDao.cancelRes(m_res_idx);
	}
	
	public int cancelPointM(int users_idx, int m_res_idx) {
		return motelDao.cancelPointM(users_idx, m_res_idx);
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return motelDao.selectMPointFromIdx(users_idx);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return motelDao.selectHPointFromIdx(users_idx);
	}
	
	public List<H_Res> hotelResIdx(int h_res_idx) {
		return motelDao.hotelResIdx(h_res_idx);
	}
	
	public int updatePoint(int users_idx, int point) {
		return motelDao.updatePoint(users_idx, point);
	}
	
	public List<M_Res> mresInfo(int m_res_idx) {
		return motelDao.mresInfo(m_res_idx);
	}
	
	public int usersPoint(int users_idx) {
		return motelDao.usersPoint(users_idx);
	}
	
	public int selectUse(int users_idx) {
		return motelDao.selectUse(users_idx);
	}
	
	public int updateUse(int users_idx, int use) {
		return motelDao.updateUse(users_idx, use);
	}
	
	public List<Users_CouponVO> ucSelect(int users_idx) {
		return motelDao.ucSelect(users_idx);
	}
	
	public int ucDelete(int users_coupon_idx) {
		return motelDao.ucDelete(users_coupon_idx);
	}
	
	public List<ThemeVO> motelTheme(int theme_idx) {
		return motelDao.motelTheme(theme_idx);
	}
	
	public String motelOne(int motel_idx) {
		return motelDao.motelOne(motel_idx);
	}

}
