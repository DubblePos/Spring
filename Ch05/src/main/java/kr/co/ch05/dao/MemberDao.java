package kr.co.ch05.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.ch05.vo.MemberVO;

public class MemberDao {

	private SqlSessionTemplate mybatis;
	
	public void inserMember(MemberVO vo) {
		mybatis.insert("mapper.member.insertMember", vo);
	}
	public MemberVO selectMember(String uid) {
		return mybatis.selectOne("mapper.member.selectMember", uid);
	}
	public List<MemberVO> selectMembers() {
		return mybatis.selectList("mapper.member.selectMembers");
	}
	public void updateMember() {}
	public void deleteMember() {}
}
