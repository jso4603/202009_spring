package com.myboard.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myboard.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Resource
	private SqlSession session;

	// 회원 가입
	@Override
	public void insert(MemberDTO mdto) throws Exception {
		session.insert("memberMapper.insert",mdto);
	}
	
	// 회원 정보 수정
	@Override
	public void update(MemberDTO mdto) throws Exception {
		session.update("memberMapper.update",mdto);
	}

	// 회원 탈퇴
	@Override
	public void delete(String userid) throws Exception {
		session.delete("memberMapper.delete",userid);
	}

	// 회원 한 건 조회
	@Override
	public MemberDTO selectOne(String userid) throws Exception {
		return session.selectOne("memberMapper.selectOne",userid);
	}
	
	// 비밀번호 변경
	@Override
	public void changePW(MemberDTO dto) throws Exception {
		session.update("memberMapper.changePW",dto);
	}

}
