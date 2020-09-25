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
	
	//aop�� �̿��� Ʈ����� ����
	//Ʈ����� : �۾��� ������ ��� commit�ǰų� rollback�� ���� �ǰ� �Ѵ�
	@Transactional
	public void insert(int money) {
		//mondy ��ü�ݾ� : A���忡�� B�������� ��ü
		adao.insert(new BankDTO(0,0,money)); 
		bdao.insert(new BankDTO(0,money,0));
	}
	
}
