package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.ProductCartService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class ProductController {

	
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductCartService cartService;
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	
	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartService.selectCountCart(vo);
		
		if(result == 0) {
			cartService.insertCart(vo);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model) {
		
		List<ProductVo> products = service.selectProducts(vo);
		CategoriesVo cateVo = service.selectCategoryTitle(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cateVo", cateVo);
		model.addAttribute("order", vo.getOrder()); //list 오더값을 참조하기위해 사용
		
		return "/product/list";
	}
	
	@GetMapping("/product/order")
	public String order() {
		return "/product/order";
	}
	
	@GetMapping("/product/order-complete")
	public String orderComplete() {
		return "/product/order-complete";
	}
	
	@GetMapping("/product/search")
	public String search() {
		return "/product/search";
	}
	
	@GetMapping("/product/view")
	public String view(int productCode, Model model) {
		
		ProductVo vo = service.selectProduct(productCode);
		model.addAttribute(vo);
		
		return "/product/view";
	}
}
