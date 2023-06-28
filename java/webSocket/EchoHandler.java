package webSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import service.ChatService;
 
@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler{
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    Map<String,List<WebSocketSession>> room = new HashMap<String,List<WebSocketSession>>();
    Map<WebSocketSession,String> removeKey = new HashMap<WebSocketSession, String>();
    WebSocketSession adminSession = null;
    private FileInputOutput f;
    public EchoHandler(FileInputOutput f) {
    	this.f = f;
    }
 
    
    
    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
 
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	sessionList.add(session);
    }
 
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	    	String str = message.getPayload();
	    	int keySearch = str.lastIndexOf("&key");
			String key = str.substring(keySearch+4);
			//System.out.println(message.getPayload());
			boolean create = false;
			
			if(key.equals("admin")) {
				for(String s : room.keySet()) {
					room.get(s).add(session);
				}
				adminSession = session;
				return;
			}
			
			
			if(room.get(key) == null) {
	    		List<WebSocketSession> inwon = new ArrayList<WebSocketSession>();
	    		inwon.add(session);
	    		if(adminSession != null && session != adminSession) {
	    			inwon.add(adminSession);
	    			//System.out.println("어드민 입장");
	    		}
	    		room.put(key,inwon);
	    		removeKey.put(session, key);
	    		//System.out.println("방생성");	    			
	    	}else {
	    			boolean tf = false;
		    		List<WebSocketSession> check =  room.get(key);
		    		if(!check.contains(session)) tf = true;
		    		if(tf) {
		    			check.add(session);
		    			removeKey.put(session, key);
		    			//System.out.println("인원추가");
		    		}
	    	}

	    	List<WebSocketSession> s = room.get(key);
	    	boolean tf = s.size() == 2;
//	    	System.out.println(key+"인원명단");
//	    	for(WebSocketSession ss : s) {
//	    		System.out.println(ss);
//	    	}
	    	
	    	
	    	if(!message.getPayload().equals("&key"+key)) {
	    	String send = f.output(message.getPayload(),key,tf);
	    	//System.out.println("보낸메세지"+send);
	        for(WebSocketSession sess : s){
	            sess.sendMessage(new TextMessage(send));
	        }
    	}
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	
    	if(adminSession == session) {
    		for(String s : room.keySet()) {
    			room.get(s).remove(session);
    			if(room.get(s).isEmpty()) {
    				room.remove(s);
    				//System.out.println("마지막 어드민 나감");
    			}
    		}
    		adminSession = null;
    	}else {
	    	String key = removeKey.get(session);
	    	room.get(key).remove(session);
	    	if(room.get(key).size() == 0) {
	    		room.remove(key);
	    		//System.out.println("방삭제");
	    	}
	    	List<WebSocketSession> s = room.get(key);
	    	if(s != null) {
	    	for(WebSocketSession ss : s) {
	    		System.out.println(ss);
	    	}}
	    	removeKey.remove(session);
    	}
        sessionList.remove(session);
    }
}