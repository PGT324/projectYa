package service;

import java.util.List;

import dao.SearchDAO;
import vo.Hotel;
import vo.Motel;

public class SearchService {
	
	private SearchDAO searchDAO;
	
	public SearchService(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
	
	public List<Motel> searchNameM(String name) {
		return searchDAO.searchNameM(name);
	}
	
	public List<Hotel> searchNameH(String name) {
		return searchDAO.searchNameH(name);
	}

}
