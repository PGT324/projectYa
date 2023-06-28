package controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import path.YaPath;
import service.ChatService;
import vo.ChatVO;
import webSocket.Chat;
import webSocket.FileInputOutput;

@Controller
public class ChatController implements YaPath{

	private ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@RequestMapping("/chat/admin")
	public String adminChat(Model m) {
		List<Map<String,Object>> list = chatService.getAllRoomList();
		m.addAttribute("list",list);
		return CHAT_CHATSERVER+"server.jsp";
	}
	
	@RequestMapping("/chat/getChat")
	@ResponseBody
	public List<Chat> getChat(int idx){
		FileInputOutput fio = new FileInputOutput();
		List<Chat> list = fio.input(idx);
		return list;
	}
	
	
	
}
