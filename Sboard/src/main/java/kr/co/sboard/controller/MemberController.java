package kr.co.sboard.controller;

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

import kr.co.sboard.service.MemberService;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) { //String uid, String pass 이것도 가능
		
		MemberVo vo =  service.selectMember(uid, pass);
		
		if(vo == null) {
			//System.out.println("회원이 아닙니다");
			// 회원이 아닐경우
			return "redirect:/member/login?success=100";
		}else {
			//System.out.println("회원이 맞습니다");
			// 회원이 맞을경우
			sess.setAttribute("sessMember", vo);
			return "redirect:/list";
		}
	}
			
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		// 현재 사용자 정보객체 세션삭제
		sess.invalidate();
		return "redirect:/member/login?success=102";
	}
		
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		model.addAttribute(vo);
		
		return "/member/terms";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertMember(vo);
		
		return "redirect:/member/login?success=101";
	}
	
	@ResponseBody /* 밑의 결과를 리스폰스객체에 실어서 전송 */
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		
		//System.out.println("uid : "+uid);
		int result = service.selectCountUid(uid);
		//System.out.println("result : "+result);
		// Json 객체 생성
		
	
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json); // 템플릿지정한걸
		
		//return "/member/register";
	}
	
	@ResponseBody
	@GetMapping("/member/checkNick")
	public String checkNick(String nick) {
	
		int result = service.selectCountNick(nick);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
		}
	
	@ResponseBody
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) {
	
		int result = service.selectCountEmail(email);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
		}
	}
