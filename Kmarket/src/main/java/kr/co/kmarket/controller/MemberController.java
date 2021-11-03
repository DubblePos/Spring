package kr.co.kmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession sess) {
		
		MemberVo memberVo = service.selectMember(vo);
		
		if(memberVo != null) {
			sess.setAttribute("sessMember", memberVo);			
			return "redirect:/";
		}else {
			return "redirect:/member/login?success=100";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		
		String ip = req.getRemoteAddr();
		
		vo.setIp(ip);
		
		service.insertMember(vo);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/register-seller")
	public String regitserSeller() {
		return "/member/register-seller";
	}
	
	@PostMapping("/member/register-seller")
	public String regitserSeller(MemberVo vo, HttpServletRequest req) {
		
		String ip = req.getRemoteAddr();
		
		vo.setIp(ip);
		
		service.insertMember(vo);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/signup")
	public String signup(Model model, int type) {
		
		MemberTermsVo vo = service.selectTerms();
		model.addAttribute(vo);
		model.addAttribute("type", type);
		
		return "/member/signup";
	}
	
	@ResponseBody
	@GetMapping("member/checkUid")
	public String checkUid(String uid) {
		
		//System.out.println("uid : " +uid);
		
		int result = service.selectCountUid(uid);
		
		//Gson라이브러리로 json생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("member/checkEmail")
	public String checkEmail(String email) {
		int result =service.selectCountEmail(email);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("member/checkHp")
	public String checkHp(String hp) {
		int result =service.selectCountHp(hp);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
}
