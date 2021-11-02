package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {

	public void insertMember(MemberVo vo);
	public void selectMember();
	public void selectMembers();
	public MemberTermsVo selectTerms();
	public void updateMember();
	public void deleteMember();
	
}


