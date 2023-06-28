package service;

import java.util.List;

import dao.PointDAO;
import vo.HPointVO;
import vo.H_Res;
import vo.MPointVO;
import vo.M_Res;

public class PointService {
	
	private PointDAO pointDAO;
	
	public PointService(PointDAO pointDAO) {
		this.pointDAO = pointDAO;
	}
	
	public List<MPointVO> selectMPointFromIdx(int users_idx) {
		return pointDAO.selectMPointFromIdx(users_idx);
	}
	
	public List<HPointVO> selectHPointFromIdx(int users_idx) {
		return pointDAO.selectHPointFromIdx(users_idx);
	}
	
	public List<M_Res> mresInfo(int m_res_idx) {
		return pointDAO.mresInfo(m_res_idx);
	}
	
	public List<H_Res> hresInfo(int h_res_idx) {
		return pointDAO.hresInfo(h_res_idx);
	}
	
	public String motelName(int m_res_idx) {
		return pointDAO.motelName(m_res_idx);
	}
	
	public String hotelName(int h_res_idx) {
		return pointDAO.hotelName(h_res_idx);
	}
	
	public int usersPoint(int users_idx) {
		return pointDAO.usersPoint(users_idx);
	}

}
