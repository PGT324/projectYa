package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.Hotel;
import vo.Motel;
import vo.MyLikeHVO;
import vo.MyLikeMVO;

public class MyLikeDAO {
	
	private SqlSession sqlSession;
	
	public MyLikeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MyLikeMVO> mLikeList(int users_idx) {
		return sqlSession.selectList("mylike.mLikeList", users_idx);
	}
	
	public List<MyLikeHVO> hLikeList(int users_idx) {
		return sqlSession.selectList("mylike.hLikeList", users_idx);
	}
	
	public Motel motelFromLike(int motel_idx) {
		return sqlSession.selectOne("mylike.motelFromLike", motel_idx);
	}

	public Hotel hotelFromLike(int hotel_idx) {
		return sqlSession.selectOne("mylike.hotelFromLike", hotel_idx);
	}
	
	public int motelReviewStar(int m_region1_idx, int m_region2_idx, int motel_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("m_region1_idx", m_region1_idx);
		map.put("m_region2_idx", m_region2_idx);
		map.put("motel_idx", motel_idx);
		
		return sqlSession.selectOne("review.motelReviewStar", map);
	}
	
	public int hotelReviewStar(int h_region1_idx, int h_region2_idx, int hotel_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("h_region1_idx", h_region1_idx);
		map.put("h_region2_idx", h_region2_idx);
		map.put("hotel_idx", hotel_idx);
		
		return sqlSession.selectOne("review.hotelReviewStar", map);
	}

}
