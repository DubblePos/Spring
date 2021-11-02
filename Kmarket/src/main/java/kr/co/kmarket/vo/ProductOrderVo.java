package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderVo {

	public int orderId;
	public String uid;
	public int count;
	public int price;
	public int discount;
	public int point;
	public int usePoint;
	public int delivery;
	public int total;
	public String orderer;
	public String hp;
	public String zip;
	public String addr1;
	public String addr2;
	public int payment;
	public int complete;
	public String rdate;
	public String completeDate;
	
}
