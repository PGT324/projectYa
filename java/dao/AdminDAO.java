package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.AdminVO;

public class AdminDAO {

	private SqlSession adminSqlSession;
	
	public AdminDAO(SqlSession adminSqlSession) {
		this.adminSqlSession = adminSqlSession;
	}
	
	public  Map<String,Object> loginCheck(AdminVO vo) {
		return adminSqlSession.selectOne("admin.loginCheck",vo) ;
	}
	
	public AdminVO login(int idx) {
		return adminSqlSession.selectOne("admin.login",idx);
	}
	
	
}
