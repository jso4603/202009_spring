package org.spring.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSession session;

	// ���̵� �̿��Ͽ� �� �� ��ȸ
	public MemberDTO selectOne(String userid) {
		return session.selectOne("memberMapper.selectOne",userid);
	}

	// ȸ������
	public void insert(MemberDTO dto) {
		session.insert("memberMapper.insert",dto);
	}
	
	// ȸ�� ���� ����
	public void update(MemberDTO dto) {
		session.update("memberMapper.update",dto);
	}

	// ȸ�� Ż��
	public void delete(String userid) {
		session.delete("memberMapper.delete",userid);
	}

	// ��й�ȣ ����
	public void changePW(MemberDTO dto) {
		session.update("memberMapper.changePW",dto);
	}

}
