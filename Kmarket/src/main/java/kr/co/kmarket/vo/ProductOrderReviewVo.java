package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderReviewVo {

	public int reviewId;
	public int productCode;
	public String content;
	public String uid;
	public int rating;
	public String ip;
	public String rdate;
}
