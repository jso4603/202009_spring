package org.spring.sample;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.dto.BankDTO;
import org.spring.service.BankService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ServiceTest {
	
	@Resource
	private BankService service;


	@Test
	public void test() {
		service.insert(3000);
	}

}
