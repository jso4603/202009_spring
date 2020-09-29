package com.myboard.dao;

import com.myboard.dto.MemberDTO;

public interface MemberDAO {
	// 회원 가입
	public void insert(MemberDTO mdto) throws Exception;
	// 회원정보 수정
	public void update(MemberDTO mdto) throws Exception;
	// 회원 탈퇴
	public void delete(String userid) throws Exception;
	// 회원 한 건 조회
	public MemberDTO selectOne(String userid) throws Exception;
	// 비밀번호 변경
	public void changePW(MemberDTO dto) throws Exception;
}
