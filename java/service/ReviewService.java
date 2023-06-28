package service;

import java.util.List;

import dao.ReviewDAO;
import vo.H_ReviewVO;
import vo.M_ReviewVO;

public class ReviewService {
	
	private ReviewDAO reviewDAO;
	
	public ReviewService(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	public int motelReview(M_ReviewVO vo) {
		return reviewDAO.motelReview(vo);
	}
	
	public int hotelReview(H_ReviewVO vo) {
		return reviewDAO.hotelReview(vo);
	}
	
	public List<M_ReviewVO> checkReviewM(int users_idx) {
		return reviewDAO.checkReviewM(users_idx);
	}
	
	public List<H_ReviewVO> checkReviewH(int users_idx) {
		return reviewDAO.checkReviewH(users_idx);
	}
	
	public List<M_ReviewVO> reviewDetailM(int m_review_idx) {
		return reviewDAO.reviewDetailM(m_review_idx);
	}
	
	public List<H_ReviewVO> reviewDetailH(int h_review_idx) {
		return reviewDAO.reviewDetailH(h_review_idx);
	}
	
	public int deleteMReview(int m_review_idx) {
		return reviewDAO.deleteMReview(m_review_idx);
	}
	
	public int deleteHReview(int h_review_idx) {
		return reviewDAO.deleteHReview(h_review_idx);
	}
	
	public int updateMReview(int m_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		return reviewDAO.updateMReview(m_review_idx, title, content, kind, clean, convinience, location);
	}
	
	public int updateHReview(int h_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		return reviewDAO.updateHReview(h_review_idx, title, content, kind, clean, convinience, location);
	}

}
