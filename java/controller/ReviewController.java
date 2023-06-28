package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ReviewService;
import vo.H_ReviewVO;
import vo.M_ReviewVO;

@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/motelReviewInsert")
	public String motelReview(M_ReviewVO vo, Model model) {
		
		int i = reviewService.motelReview(vo);
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "리뷰 작성 성공!";
			href = "/pro/";
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "리뷰 작성 실패!";
			href = "/pro/mypage/mypage";
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}
	}
	
	@RequestMapping("/hotelReviewInsert")
	public String hotelReview(H_ReviewVO vo, Model model) {
		
		int i = reviewService.hotelReview(vo);
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "리뷰 작성 성공!";
			href = "/pro/";
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "리뷰 작성 실패!";
			href = "/pro/mypage/mypage";
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}
	}
	
	@RequestMapping("/review/myreview")
	public String checkReview(Model model ,int users_idx) {
		
		List<M_ReviewVO> list1 = reviewService.checkReviewM(users_idx);
		List<H_ReviewVO> list2 = reviewService.checkReviewH(users_idx);
		
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		
		return "/WEB-INF/views/review/myreview.jsp";
	}
	
	@RequestMapping("/review/reviewDetailM")
	public String reviewDetailM(Model model, int m_review_idx) throws SQLException, IOException {
		
		List<M_ReviewVO> list = reviewService.reviewDetailM(m_review_idx);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/review/reviewDetailM.jsp";
	}
	
	@RequestMapping("/review/reviewDetailH")
	public String reviewDetailH(Model model, int h_review_idx) {
		
		List<H_ReviewVO> list = reviewService.reviewDetailH(h_review_idx);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/review/reviewDetailH.jsp";
	}
	
	@RequestMapping("/review/mdelete")
	public String mdelete(Model model, int m_review_idx) {
		
		int i = reviewService.deleteMReview(m_review_idx);
		
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "삭제 성공!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "삭제 실패!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}
		
	}
	
	@RequestMapping("/review/hdelete")
	public String hdelete(Model model, int h_review_idx) {
		
		int i = reviewService.deleteHReview(h_review_idx);
		
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "삭제 성공!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "삭제 실패!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}
		
	}
	
	@RequestMapping("/review/mupdate")
	public String mupdate(Model model, int m_review_idx) {
		
		List<M_ReviewVO> list = reviewService.reviewDetailM(m_review_idx);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/review/motelupdate.jsp";
	}
	
	@RequestMapping("/review/hupdate")
	public String hupdate(Model model, int h_review_idx) {
		
		List<H_ReviewVO> list = reviewService.reviewDetailH(h_review_idx);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/review/hotelupdate.jsp";
	}
	
	@RequestMapping("/review/muresult")
	public String muresult(Model model, int m_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		
		int i = reviewService.updateMReview(m_review_idx, title, content, kind, clean, convinience, location);
		
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "수정 성공!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "수정 실패!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}
		
	}
	
	@RequestMapping("/review/huresult")
	public String huresult(Model model, int h_review_idx, String title, String content, int kind, int clean, int convinience, int location) {
		
		int i = reviewService.updateHReview(h_review_idx, title, content, kind, clean, convinience, location);
		
		String msg = "";
		String href = "";
		
		if(i != 0) {
			msg = "수정 성공!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}else {
			msg = "수정 실패!";
			href = "/pro/review/myreview";
			
			model.addAttribute("msg", msg);
			model.addAttribute("href", href);
			
			return "/WEB-INF/views/review/result.jsp";
		}	
		
	}


}
