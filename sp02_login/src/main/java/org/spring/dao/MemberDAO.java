package org.spring.dao;

import org.spring.dto.MemberDTO;

//자식클래스가 정의해야 하는 메소드를 포함해야 한다.
public interface MemberDAO{
	// 한 건 조회
	public MemberDTO selectOne(String userid);
	// 회원가입
	public void insert(MemberDTO dto);
	// 회원정보 수정
	public void update(MemberDTO dto);
	// 회원탈퇴
	public void delete(String userid);
	// 비밀번호 변경
	public void changePW(MemberDTO dto);
}
