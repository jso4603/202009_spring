package org.spring.dao;

import org.spring.dto.MemberDTO;

//�ڽ�Ŭ������ �����ؾ� �ϴ� �޼ҵ带 �����ؾ� �Ѵ�.
public interface MemberDAO{
	// �� �� ��ȸ
	public MemberDTO selectOne(String userid);
	// ȸ������
	public void insert(MemberDTO dto);
	// ȸ������ ����
	public void update(MemberDTO dto);
	// ȸ��Ż��
	public void delete(String userid);
	// ��й�ȣ ����
	public void changePW(MemberDTO dto);
}
