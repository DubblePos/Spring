package kr.co.sboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.MemberVo;

@Controller
public class BoardController {
	
	private BoardService service;
	
	@GetMapping(value = {"/index", "/"})
	public String index(HttpSession sess) { //(httpserver req)해도됨 그러나 sess하는게 좋음?????
		
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo == null) {
			return "forward:/member/login";
		}else {
			return "forward:/list"; //redirect도 됨
		}
	}
	
	@GetMapping("/list")
	public String list(HttpSession sess) {
		
		ArticleVo vo = (ArticleVo) sess.getAttribute("sessArticle");
		
		return "/list";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, ArticleVo vo) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertArticle(vo);
		
		return "redirect:/list";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
}
