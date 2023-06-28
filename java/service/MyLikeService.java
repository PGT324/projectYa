package service;

import java.util.List;

import dao.MyLikeDAO;
import vo.Hotel;
import vo.Motel;
import vo.MyLikeHVO;
import vo.MyLikeMVO;

public class MyLikeService {
	
	private MyLikeDAO myLikeDAO;
	
	public MyLikeService(MyLikeDAO myLikeDAO) {
		this.myLikeDAO = myLikeDAO;
	}
	
	public List<MyLikeMVO> mLikeList(int users_idx) {
		return myLikeDAO.mLikeList(users_idx);
	}
	
	public List<MyLikeHVO> hLikeList(int users_idx) {
		return myLikeDAO.hLikeList(users_idx);
	}
	
	public Motel motelFromLike(int motel_idx) {
		return myLikeDAO.motelFromLike(motel_idx);
	}

	public Hotel hotelFromLike(int hotel_idx) {
		return myLikeDAO.hotelFromLike(hotel_idx);
	}
	
	public int motelReviewStar(int m_region1_idx, int m_region2_idx, int motel_idx) {
		return myLikeDAO.motelReviewStar(m_region1_idx, m_region2_idx, motel_idx);
	}
	
	public int hotelReviewStar(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		return myLikeDAO.hotelReviewStar(h_region1_idx, h_region2_idx, hotel_idx);
	}
}
