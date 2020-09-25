package org.spring.sample;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.dao.BankADAO;
import org.spring.dao.BankBDAO;
import org.spring.dto.BankDTO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DaoTest {
	
	@Resource
	private BankADAO daoA;
	
	@Resource
	private BankBDAO daoB;

	@Test
	public void test() {
		daoA.insert(new BankDTO(1,1000,0));
		daoB.insert(new BankDTO(1,1000,0));
	}

}
