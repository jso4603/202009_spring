package org.spring.service;

import javax.annotation.Resource;

import org.spring.dao.BankADAO;
import org.spring.dao.BankBDAO;
import org.spring.dto.BankDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
	
	@Resource
	private BankADAO adao;
	
	@Resource
	private BankBDAO bdao;
	
	// aop를 이용한 트랜잭션 관리
	@Transactional
	public void insert(int money) {
		// money : 이체금액(A통장에서 B통장으로 이체)
		adao.insert(new BankDTO(0,0,money));
		bdao.insert(new BankDTO(0,money,0));
	}
}
