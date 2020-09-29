package org.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	//의존 주입
	@Inject
	private SqlSession session;
	
	//전체조회
	public List<MemberDTO> selectList(){
		return session.selectList("memberMapper.selectList");
	}
	
	//한 건 추가
	public int insert(MemberDTO dto) {
		return session.insert("memberMapper.insert",dto);
	}
}
