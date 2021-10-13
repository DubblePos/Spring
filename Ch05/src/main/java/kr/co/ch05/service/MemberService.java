package kr.co.ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.ch05.dao.MemberDao;
import kr.co.ch05.vo.MemberVO;

public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void inserMember(MemberVO vo) {
		dao.inserMember(vo);
	}
	public MemberVO selectMember(String uid) {
		return dao.selectMember(uid);
	}
	public List<MemberVO> selectMembers() {
		return dao.selectMembers();
	}
	public void updateMember() {}
	public void deleteMember() {}
}
