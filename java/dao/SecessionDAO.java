package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.SecessionVO;

public class SecessionDAO {
	private SqlSession secessionSqlSession;
	
	public SecessionDAO(SqlSession secessionSqlSession) {
		this.secessionSqlSession = secessionSqlSession;
	}
	
	public int insert(SecessionVO dto) {
		return secessionSqlSession.insert("secession.insert",dto);
	}
	
	public List<Map<String,Object>> getTotal(){
		return secessionSqlSession.selectList("secession.total");
	}
	
	public List<Map<String,Object>> oneType(int type){
		return secessionSqlSession.selectList("secession.oneType",type);
	}
}
