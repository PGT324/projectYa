package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.HPointVO;
import vo.H_Res;
import vo.MPointVO;
import vo.M_Res;

public class PointDAO {
	
	private SqlSession sqlSession;
	
	public PointDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectMPointFromIdx", users_idx);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return sqlSession.selectList("point.selectHPointFromIdx", users_idx);
	}
	
	public List<M_Res> mresInfo(int m_res_idx) {
		return sqlSession.selectList("point.mresInfo", m_res_idx);
	}

	public List<H_Res> hresInfo(int h_res_idx) {
		return sqlSession.selectList("point.hresInfo", h_res_idx);
	}
	
	public String motelName(int m_res_idx) {
		return sqlSession.selectOne("point.motelName", m_res_idx);
	}
	
	public String hotelName(int h_res_idx) {
		return sqlSession.selectOne("point.hotelName", h_res_idx);
	}
	
	public int usersPoint(int users_idx) {
		return sqlSession.selectOne("point.usersPoint", users_idx);
	}
}
