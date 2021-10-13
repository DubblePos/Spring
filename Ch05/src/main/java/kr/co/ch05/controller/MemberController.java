package kr.co.ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch05.service.MemberService;
import kr.co.ch05.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<MemberVO> members = service.selectMembers();
		
		model.addAttribute("members", members);
		
		return "/member/list";
		
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVO vo) {
		service.inserMember(vo);
		return "redirect:/member/register";
	}
		
}
