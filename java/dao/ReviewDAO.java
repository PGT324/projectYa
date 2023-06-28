package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.H_ReviewVO;
import vo.M_ReviewVO;

public class ReviewDAO {
	
	private SqlSession sqlSession;
	
	public ReviewDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int motelReview(M_ReviewVO vo) {
		return sqlSession.insert("review.motelReview", vo);
	}
	
	public int hotelReview(H_ReviewVO vo) {
		return sqlSession.insert("review.hotelReview", vo);
	}
	
	public List<M_ReviewVO> checkReviewM(int users_idx) {
		return sqlSession.selectList("review.checkReviewM", users_idx);
	}
	
	public List<H_ReviewVO> checkReviewH(int users_idx) {
		return sqlSession.selectList("review.checkReviewH", users_idx);
	}
	
	public List<M_ReviewVO> reviewDetailM(int m_review_idx) {
		return sqlSession.selectList("review.reviewDetailM", m_review_idx);
	}
	
	public List<H_ReviewVO> reviewDetailH(int h_review_idx) {
		return sqlSession.selectList("review.reviewDetailH", h_review_idx);
	}
	
	public int deleteMReview(int m_review_idx) {
		return sqlSession.delete("review.deleteMReview", m_review_idx);
	}
	
	public int deleteHReview(int h_review_idx) {
		return sqlSession.delete("review.deleteHReview", h_review_idx);
	}
	
	public int updateMReview(int m_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		
		M_ReviewVO vo = new M_ReviewVO();
		vo.setContent(content);
		vo.setTitle(title);
		vo.setM_review_idx(m_review_idx);
		vo.setKind(kind);
		vo.setClean(clean);
		vo.setConvinience(convinience);
		vo.setLocation(location);
		
		return sqlSession.update("review.updateMReview", vo);
	}
	
	public int updateHReview(int h_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		
		H_ReviewVO vo = new H_ReviewVO();
		vo.setContent(content);
		vo.setTitle(title);
		vo.setH_review_idx(h_review_idx);
		vo.setKind(kind);
		vo.setClean(clean);
		vo.setConvinience(convinience);
		vo.setLocation(location);
		
		return sqlSession.update("review.updateHReview", vo);
	}

}
