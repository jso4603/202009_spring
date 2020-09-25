package org.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Resource
	private SqlSession session;
	
	public List<MemberDTO> selectList(){
		return session.selectList("memberMapper.selectList");
	}
	
	public int insert(MemberDTO dto) {
		return session.insert("memberMapper.insert", dto);
	}
	
	public MemberDTO selectOne(String userid) {
		return session.selectOne("memberMapper.selectOne", userid);
		
	}
	
}
