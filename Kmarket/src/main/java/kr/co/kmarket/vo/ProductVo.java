package kr.co.kmarket.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVo {

	public int productCode;
	public int cate1;
	public int cate2;
	public String name;
	public String descript;
	public String company;
	public String seller;
	public int price;
	public int discount;
	public int point;
	public int stock;
	public int sold;
	public int delivery;
	public int hit;
	public int score;
	public int review;
	public String thumb1;
	public String thumb2;
	public String thumb3;
	public String detail;
	public String status;
	public String dutyFree;
	public String receipt;
	public String bizClass;
	public String origin;
	public String ip;
	public String rdate;
	public int etc1;
	public int etc2;
	public String etc3;
	public String etc4;
	public String etc5;	
	
	// 추가필드 l
	private int salePrice;
	private String tit1;
	private String tit2;
	private int order = 1;// int의 기본값은 0, 1로 하는 이유는 오더를 기본판매로 하기 위해 1로 초기화하는거다.
	private int start;
	
	
	// 추가필드 ll
	private MultipartFile thumbFile1;
	private MultipartFile thumbFile2;
	private MultipartFile thumbFile3;
	private MultipartFile detailFile4;
	
	
	
	public List<MultipartFile> getFiles(){
		List<MultipartFile> files = Arrays.asList(thumbFile1, thumbFile2, thumbFile3, detailFile4);
		return files;
	}
	
}
