package kr.co.farmstory.dao;

import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Repository
public interface MemberDao {

	public void insertMember(MemberVo vo);
	
	public int selectCountUid(String uid);
	
	public int selectCountNick(String nick);
	
	public int selectCountEmail(String email);
	
	public int selectCountHp(String hp);
	
	public MemberVo selectMember(String uid, String pass);
	
	public TermsVo selectTerms();
	public void selectMembers();
	public void updateMember();
	public void deleteMember();
}
