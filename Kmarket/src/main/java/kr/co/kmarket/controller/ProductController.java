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
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductCartService cartService;
	
	
	@GetMapping("/product/cart")
	public String cart(HttpSession sess, Model model) {
		
		// 로그인 여부확인
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo != null) {
			
			List<ProductCartVo> cartProducts = cartService.selectCarts(vo.getUid());
			model.addAttribute("cartProducts", cartProducts);
			
			return "/product/cart";	
			
		}else {
			return "redirect:/member/login?success=201";
		}
	}
	
	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartService.selectCountCart(vo);
		
		if(result == 0) {
			cartService.insertCart(vo);	
		}
		
		System.out.println("result : "+result);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/product/cartDelete")
	public String cartDelete(int[] cartIds) {
		
		int result =cartService.deleteCart(cartIds);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model, String pg) {
		
		// 리스트 번호 처리
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectProductCountTotal(vo);
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		vo.setStart(start);
		
		List<ProductVo> products = service.selectProducts(vo);
		CategoriesVo cateVo = service.selectCategoryTitle(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cateVo", cateVo);
		model.addAttribute("order", vo.getOrder());
		
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);
		
		
		
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
	public String search(SearchVo vo, Model model) {
		
		List<ProductVo> products = service.selectProductSearch(vo);
		model.addAttribute("products", products);
		model.addAttribute("productCount", products.size());		
		model.addAttribute("keyword", vo.getKeyword());
		
		return "/product/search";
	}
		
	
	@GetMapping("/product/view")
	public String view(HttpSession sess, int productCode, Model model) {
		
		ProductVo vo = service.selectProduct(productCode);
		model.addAttribute(vo);
		
		return "/product/view";
	}
}