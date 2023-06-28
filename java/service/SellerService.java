package service;

import java.util.List;

import dao.SellerDAO;
import vo.SellerVO;

public class SellerService {
	
	private SellerDAO sellerDAO;
	
	public SellerService(SellerDAO sellerDAO) {
		this.sellerDAO = sellerDAO;
	}
	
	public int insertSeller(SellerVO vo) {
		return sellerDAO.insertSeller(vo);
	}
	
	public List<SellerVO> selectSeller(int users_idx) {
		return sellerDAO.selectSeller(users_idx);
	}
	
	public int updateSeller(SellerVO vo) {
		return sellerDAO.updateSeller(vo);
	}
	
	public int updateStatus(int snumber) {
		return sellerDAO.updateStatus(snumber);
	}

}
