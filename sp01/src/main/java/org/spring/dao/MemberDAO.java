package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	//���� ����
	@Inject
	private SqlSession session;
	
	//��ü��ȸ
	public List<MemberDTO> selectList(){
		return session.selectList("memberMapper.selectList");
	}
	
	//�� �� �߰�
	public int insert(MemberDTO dto) {
		return session.insert("memberMapper.insert",dto);
	}
}
