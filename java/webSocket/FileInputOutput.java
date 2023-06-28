package webSocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.ChatService;
import vo.ChatVO;

public class FileInputOutput {
	
	private ChatService chatSevice;
	
	public FileInputOutput() {}
	
	public FileInputOutput(ChatService chatService) {
	    	this.chatSevice = chatService;
	}
	
	
	
	public String output(String str,String key,boolean ck) {
		boolean create = false;
		
		int keySearch = str.lastIndexOf("&key");
		str = str.substring(0,keySearch);
		//System.out.println(str);
		int idxSearch = str.lastIndexOf("&|&");
		int idx = Integer.parseInt(str.substring(idxSearch+3));
		String content = str.substring(0, idxSearch);
		String ccontent = content;
		String batang = System.getProperty("user.home");
		
		long ld = System.currentTimeMillis();
		Date dt = new Date(ld);
		java.sql.Date sqdt = new java.sql.Date(ld);
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd&a hh:mm");
		String ds = sdt.format(dt);
		
		String[] date = ds.split("&");
		String[] dateFile = date[0].split("-");
		
		
		
		 content +="&&&"+date[1]+"&|&"+idx;
		 String send = content;
		 content += "l1as1t1i1n1d1e1x";
		byte[] b = content.getBytes();
		File f = new File(batang+"\\Desktop\\chatting\\"+key+"\\"+dateFile[0]+"\\"+dateFile[1]+"\\"+dateFile[2]);
			
		if(!f.exists()) {
			f.mkdirs();
		}
		f = new File(batang+"\\Desktop\\chatting\\"+key+"\\"+dateFile[0]+"\\"+dateFile[1]+"\\"+dateFile[2]+"\\chat.txt");
		try {
			if(!f.exists())
			f.createNewFile();
			if(chatSevice.checkRoomList(key) == 0)create = true;
			if(create) {
				ChatVO vo = new ChatVO();
				vo.setUsers_idx(key);
				vo.setChecked(0);
				vo.setLastDate(sqdt);
				vo.setLastContent(ccontent);
				chatSevice.createRoomList(vo);
			}else {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("content", ccontent);
				map.put("checked", ck ? 1 : 0);
				map.put("date", sqdt);
				map.put("idx", key);
				chatSevice.oneChatUp(map);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			FileOutputStream fo = new FileOutputStream(f,true);
			
			try {
				fo.write(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return send;
	}
	
	
	public List<Chat> input(int users_idx) {
		String batang = System.getProperty("user.home");
		List<Chat> list = new ArrayList<Chat>();
		long now = System.currentTimeMillis();
		Date d = new Date(now);
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdt.format(d);
		String[] dateFile = date.split("-");
		
		File f = new File(batang+"\\Desktop\\chatting\\"+users_idx+"\\"+dateFile[0]+"\\"+dateFile[1]+"\\"+dateFile[2]+"\\chat.txt");
		if(f.exists()) {
			try {
				FileInputStream fi = new FileInputStream(f);
				byte[] bt = fi.readAllBytes();
				String bs = new String(bt);
				if(!bs.isEmpty()) {
				String[] bbs = bs.split("l1as1t1i1n1d1e1x");
				for(int i = 0; i < bbs.length; i++) {
					int idxSearch = bbs[i].lastIndexOf("&|&");
					int idx = Integer.parseInt(bbs[i].substring(idxSearch+3,bbs[i].length()));
					int dateSearch = bbs[i].lastIndexOf("&&&");
					String cdate = bbs[i].substring(dateSearch+3,idxSearch);
					String content = bbs[i].substring(0,dateSearch);
					list.add(new Chat(idx, content, cdate));
				}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
	
	
	
}
