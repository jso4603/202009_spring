package org.spring.service;

import java.util.Map;

import org.spring.dto.MemberDTO;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	
	// 회원가입
	public Map<String,Object> insert(MemberDTO dto,MultipartFile photofile);
	//수정 폼에 가져갈 데이터
	public MemberDTO modify(String userid);
	// 회원정보 수정
	public String update(MemberDTO dto,MultipartFile photofile);
	// 회원 탈퇴
	public String delete(MemberDTO dto,String insertPW);
	// 비밀번호 변경
	public String changePW(MemberDTO dto,String oldPW,String newPW);
	// 비밀번호 일치여부 확인
	public boolean checkPW(String passwd, String insertPW);
}
