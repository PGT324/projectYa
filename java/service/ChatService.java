package service;

import java.util.List;
import java.util.Map;

import dao.ChatDAO;
import vo.ChatVO;

public class ChatService {

	private ChatDAO chatDao;
	
	public ChatService(ChatDAO chatDao) {
		this.chatDao = chatDao;
	}
	
	public int checkRoomList(String idx) {
		return chatDao.checkRoomList(idx);
	}
	
	public int createRoomList(ChatVO vo) {
		return chatDao.createRoom(vo);
	}
	
	public List<Map<String,Object>> getAllRoomList() {
		return chatDao.getAllRoomList();
	}
	
	
	public int oneChatUp(Map<String,Object> map) {
		return chatDao.oneChatUp(map);
	}
	
}
