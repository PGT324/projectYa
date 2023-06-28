package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.ChatVO;

public class ChatDAO {
	
	private SqlSession chatSqlSession;
	
	public ChatDAO(SqlSession chatSqlSession) {
		this.chatSqlSession = chatSqlSession;
	}
	
	
	public int checkRoomList(String idx) {
		return chatSqlSession.selectOne("chat.checkRoomList",idx) == null ? 0 : 1;
	}
	
	public int createRoom(ChatVO vo) {
		return chatSqlSession.insert("chat.createRoom",vo);
	}
	
	public List<Map<String,Object>> getAllRoomList() {
		return chatSqlSession.selectList("chat.getAllRoomList");
	}
	
	public int oneChatUp(Map<String,Object> map){
		return chatSqlSession.update("chat.oneChatUp", map);
	}
}
