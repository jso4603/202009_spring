package org.spring.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.spring.dto.BankDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BankBDAO {
	
	//마이바티스 세션 자동주입
	@Resource
	private SqlSession session;
	
	public void insert(BankDTO dto) {
		session.insert("bankBMapper.insert",dto);
	}
	
	
}
