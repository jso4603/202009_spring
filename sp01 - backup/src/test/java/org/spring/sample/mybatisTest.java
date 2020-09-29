package org.spring.sample;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class mybatisTest {
	// 의존 주입(@Inject, @Autowired, @Resource)
	@Inject
	private SqlSessionFactory sf;
	
	@Inject
	private SqlSession session;
	
	@Test
	public void test() {
		System.out.println("Factory : "+sf);
		System.out.println("Session : "+session);
	}

}
