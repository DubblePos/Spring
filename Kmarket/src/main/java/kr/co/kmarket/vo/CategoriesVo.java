package kr.co.kmarket.vo;

import java.util.List;

import lombok.Data;

@Data
public class CategoriesVo {

	private int cate1;
	private String tit1;
	private List<ProductCate2Vo> cate2List;
	
}
