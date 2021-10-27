package kr.co.farmstory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.MemberService;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		MemberVo vo = service.selectMember(uid, pass);
		
		if(vo == null) {
			return "/member/login?success=100";
		}else {
			
			sess.setAttribute("sessMember", vo);
			return "/index";
		}
		
	}
	
	@GetMapping("/member/terms")
	public String terms(Model medel) {
		
		TermsVo vo = service.selectTerms();
		medel.addAttribute(vo);
		return "/member/terms";
		}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@ResponseBody /*포워드 안해주고 데이터만 주려고!*/
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		
		System.out.println("uid : "+uid);
		
		int result = service.selectCountUid(uid);
		
		// Gson 라이브러리로 json 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
		
		/*Jackson 라이브러리 json 생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		String strJson2 = new ObjectMapper().writeValueAsString(resultMap);
		
		return strJson2; */
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
	
	@ResponseBody
	@GetMapping("/member/checkHp")
	public String checkHp(String hp) {
		System.out.println("hp : "+hp);

		int result = service.selectCountHp(hp);

		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
}
