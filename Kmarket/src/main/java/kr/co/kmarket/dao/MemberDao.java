package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {

	public void insertMember(MemberVo vo);
	public MemberVo selectMember(MemberVo vo);
	public void selectMembers();
	public MemberTermsVo selectTerms();
	public void updateMember();
	public void deleteMember();
	
	public int selectCountUid(String uid);
	
	public int selectCountNick(String nick);
	
	public int selectCountEmail(String email);
	
	public int selectCountHp(String hp);
	
}


