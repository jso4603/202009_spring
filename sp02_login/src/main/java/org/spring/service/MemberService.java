package org.spring.service;

import java.util.Map;

import org.spring.dto.MemberDTO;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	
	// ȸ������
	public Map<String,Object> insert(MemberDTO dto,MultipartFile photofile);
	//���� ���� ������ ������
	public MemberDTO modify(String userid);
	// ȸ������ ����
	public String update(MemberDTO dto,MultipartFile photofile);
	// ȸ�� Ż��
	public String delete(MemberDTO dto,String insertPW);
	// ��й�ȣ ����
	public String changePW(MemberDTO dto,String oldPW,String newPW);
	// ��й�ȣ ��ġ���� Ȯ��
	public boolean checkPW(String passwd, String insertPW);
}
