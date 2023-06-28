package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import path.YaPath;
import service.SecessionService;
import service.UsersService;
import vo.SecessionVO;
import vo.UsersVO;

@Controller
public class SecessionController implements YaPath{
	
	private SecessionService secessionService;
	private UsersService usersService;
	
	public SecessionController(SecessionService secessionService,UsersService usersService) {
		System.out.println("secession컨트롤러 실행");
		this.secessionService = secessionService;
		this.usersService = usersService;
	}
	
	@RequestMapping("/secession/joinout")
	public String joinout(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		SecessionVO dto = new SecessionVO();
		UsersVO usersDto = (UsersVO)request.getSession().getAttribute("login");
		
		
		long d1 = System.currentTimeMillis();
		long d2 = d1 +Long.valueOf("15811115631");
		int idx = usersDto.getUsers_idx();
		
		Date dd1 = new Date(d1);
		Date dd2 = new Date(d2);
		
		dto.setType(Integer.parseInt(request.getParameter("type")));
		dto.setContent(dto.getType() == 4 ? request.getParameter("text") : null);
		dto.setUsers_idx(idx);
		dto.setDate_exit(dd1);
		dto.setDate_end(dd2);
		
		System.out.println(dto.getType());
		System.out.println(dto.getContent());
		System.out.println(dto.getUsers_idx());
		System.out.println(dto.getDate_exit());
		System.out.println(dto.getDate_end());
		
		
		if(secessionService.insert(dto) != 0) {
			if(usersService.updateStatus(idx) == 1) {
				request.getSession().invalidate();
			}
		}
		return "/";
	}
	
	@RequestMapping("/secession/admin/getTotal")
	public String getTotal(Model m) {
		List<Map<String,Object>> total = secessionService.getTotal();
		m.addAttribute("total",total);
		return SECESSION_SELECT + "getTotal.jsp";
	}
	
	@RequestMapping("/secession/admin/oneType")
	@ResponseBody
	public List<Map<String,Object>> oneType(int type){
		List<Map<String,Object>> list = secessionService.oneType(type);
		for(int i = 0; i < list.size(); i++) {
			java.util.Date exdate =  new java.util.Date(((Timestamp)list.get(i).get("DATE_EXIT")).getTime());
			java.util.Date edate = new java.util.Date(((Timestamp)list.get(i).get("DATE_END")).getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
			list.get(i).put("DATE_EXIT", sdf.format(exdate));
			list.get(i).put("DATE_END", sdf.format(edate));
		}
		return list;
	}
	
	
	
}
