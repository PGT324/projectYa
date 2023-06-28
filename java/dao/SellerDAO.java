package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SellerVO;

public class SellerDAO {
	
	private SqlSession sqlSession;
	
	public SellerDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertSeller(SellerVO vo) {
		return sqlSession.insert("seller.insertSeller", vo);
	}
	
	public List<SellerVO> selectSeller(int users_idx) {
		return sqlSession.selectList("seller.selectSeller", users_idx);
	}
	
	public int updateSeller(SellerVO vo) {
		return sqlSession.update("seller.updateSeller", vo);
	}
	
	public int updateStatus(int snumber) {
		return sqlSession.update("seller.updateStatus", snumber);
	}

}
