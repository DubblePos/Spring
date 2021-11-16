package kr.co.thejoenmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.thejoenmovie.service.MainService;
import kr.co.thejoenmovie.vo.MovieVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		List<MovieVo> movieinfo = service.selectMovieInfo();
		
		model.addAttribute("movieinfo", movieinfo);
		
		return "/index";
	}
}
