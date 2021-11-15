package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="km_member_terms")
public class MemberTermsVo {

	@Id
	public int seq;
	public String terms;
	public String privacy;
	public String location;
	public String finance;
	public String tax;
}
