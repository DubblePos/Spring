package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCartVo {

	public int cartId;
	public String uid;
	public int productCode;
	public int count;
	public int price;
	public int discount;
	public int point;
	public int delivery;
	public int total;
	public String rdate;
	
	// μΆκ°νλ
	private int cate1;
	private int cate2;
	private String name;
	private String thumb1;
}
