package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="km_member")
public class MemberVo {
	@Id
	public String uid;
	public String pass;
	public String name;
	public int gender;
	public String hp;
	public String email;
	public int type;
	public int point;
	public int grade;
	public String zip;
	public String addr1;
	public String addr2;
	public String company;
	public String ceo;
	public String bizRegNum;
	public String commRepNum;
	public String tel;
	public String manager;
	public String managerHp;
	public String fax;
	public String ip;
	public String leaveDate;
	public String rdate;
	public int etc1;
	public int etc2;
	public String etc3;
	public String etc4;
	public String etc5;
	
	// 추가필드
	@Transient
	private int productCode;
}
