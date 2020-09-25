package com.myboard.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	// 회원 가입
	public Map<String,Object> insert(MemberDTO mdto, MultipartFile photofile) throws Exception;
	//수정 폼에 데이터 전송
	public MemberDTO modify(String userid) throws Exception;
	// 회원 정보수정
	public String update(MemberDTO mdto, MultipartFile photofile) throws Exception;
	// 비밀번호 일치여부 확인
	public boolean checkPW(String passwd, String insertPW) throws Exception;
	// 비밀번호 변경
	public String changePW(MemberDTO dto, String oldPW, String newPW) throws Exception;
	// 회원 탈퇴
	public String delete(MemberDTO dto, String insertPW) throws Exception;
}
