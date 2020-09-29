package org.spring.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSession session;

	// 아이디를 이용하여 한 건 조회
	public MemberDTO selectOne(String userid) {
		return session.selectOne("memberMapper.selectOne",userid);
	}

	// 회원가입
	public void insert(MemberDTO dto) {
		session.insert("memberMapper.insert",dto);
	}
	
	// 회원 정보 수정
	public void update(MemberDTO dto) {
		session.update("memberMapper.update",dto);
	}

	// 회원 탈퇴
	public void delete(String userid) {
		session.delete("memberMapper.delete",userid);
	}

	// 비밀번호 변경
	public void changePW(MemberDTO dto) {
		session.update("memberMapper.changePW",dto);
	}

}
