package com.myboard.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	// ȸ�� ����
	public Map<String,Object> insert(MemberDTO mdto, MultipartFile photofile) throws Exception;
	//���� ���� ������ ����
	public MemberDTO modify(String userid) throws Exception;
	// ȸ�� ��������
	public String update(MemberDTO mdto, MultipartFile photofile) throws Exception;
	// ��й�ȣ ��ġ���� Ȯ��
	public boolean checkPW(String passwd, String insertPW) throws Exception;
	// ��й�ȣ ����
	public String changePW(MemberDTO dto, String oldPW, String newPW) throws Exception;
	// ȸ�� Ż��
	public String delete(MemberDTO dto, String insertPW) throws Exception;
}
