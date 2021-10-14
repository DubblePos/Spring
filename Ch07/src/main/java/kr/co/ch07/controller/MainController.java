package kr.co.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.vo.UserVo;

@Controller
public class MainController {
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		String title = "스프링부트 타임리프 실습";
		String hello = "Hello Thymeleaf";
		
		UserVo user = new UserVo();
		user.setUid("a101");
		user.setName("박승필");
		user.setHp("010-2311-9156");
		user.setAge(21);
		
		List<UserVo> users = new ArrayList<UserVo>();
		users.add(new UserVo("a101","김유신","010-1111-1111",21));
		users.add(new UserVo("a102","장보고","010-1111-2222",15));
		users.add(new UserVo("a103","강감찬","010-1111-3333",44));
		users.add(new UserVo("a104","이순신","010-1111-4444",23));
		users.add(new UserVo("a105","김춘추","010-1111-5555",43));
		
		model.addAttribute("title", title);
		model.addAttribute("hello", hello);
		model.addAttribute(user);
		model.addAttribute("users",users);
		
		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
}
