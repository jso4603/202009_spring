package org.spring.sample;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.dao.BankBDAO;
import org.spring.dto.BankDTO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DaoTest {

//	@Resource
//	private BankADAO dao;

	@Resource
	private BankBDAO dao;	
	
	@Test
	public void test() {
		dao.insert(new BankDTO(0, 0, 1000));
	}

}
