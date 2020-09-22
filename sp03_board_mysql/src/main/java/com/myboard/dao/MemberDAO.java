package com.myboard.dao;

import com.myboard.dto.MemberDTO;

public interface MemberDAO {
	// ȸ�� ����
	public void insert(MemberDTO mdto) throws Exception;
	// ȸ������ ����
	public void update(MemberDTO mdto) throws Exception;
	// ȸ�� Ż��
	public void delete(String userid) throws Exception;
	// ȸ�� �� �� ��ȸ
	public MemberDTO selectOne(String userid) throws Exception;
	// ��й�ȣ ����
	public void changePW(MemberDTO dto) throws Exception;
}