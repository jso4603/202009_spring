package com.myboard.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myboard.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Resource
	private SqlSession session;

	// ȸ�� ����
	@Override
	public void insert(MemberDTO mdto) throws Exception {
		session.insert("memberMapper.insert",mdto);
	}
	
	// ȸ�� ���� ����
	@Override
	public void update(MemberDTO mdto) throws Exception {
		session.update("memberMapper.update",mdto);
	}

	// ȸ�� Ż��
	@Override
	public void delete(String userid) throws Exception {
		session.delete("memberMapper.delete",userid);
	}

	// ȸ�� �� �� ��ȸ
	@Override
	public MemberDTO selectOne(String userid) throws Exception {
		return session.selectOne("memberMapper.selectOne",userid);
	}
	
	// ��й�ȣ ����
	@Override
	public void changePW(MemberDTO dto) throws Exception {
		session.update("memberMapper.changePW",dto);
	}

}