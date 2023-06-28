package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.Hotel;
import vo.Motel;

public class SearchDAO {
	
	private SqlSession sqlSession;
	
	public SearchDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Motel> searchNameM(String name) {
		return sqlSession.selectList("search.searchNameM", name);
	}
	
	public List<Hotel> searchNameH(String name) {
		return sqlSession.selectList("search.searchNameH", name);
	}

}
