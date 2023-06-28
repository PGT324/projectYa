package service;

import java.util.List;
import java.util.Map;

import dao.SecessionDAO;
import vo.SecessionVO;

public class SecessionService {
	
	private SecessionDAO secessionDao;
	
	public SecessionService(SecessionDAO secessionDao) {
		this.secessionDao = secessionDao;
	}
	
	public int insert(SecessionVO dto) {
		return secessionDao.insert(dto);
	}
	
	public List<Map<String,Object>> getTotal(){
		return secessionDao.getTotal();
	}
	
	public List<Map<String,Object>> oneType(int type){
		return secessionDao.oneType(type);
	}
}
