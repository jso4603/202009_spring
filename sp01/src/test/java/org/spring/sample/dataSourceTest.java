package org.spring.sample;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링 테스트를 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration : 어떤 xml을 가져올건지
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class dataSourceTest {
	
	@Inject
	private DataSource ds;
	
	@Test
	public void test() {
		//데이터 소스 테스트
		try {
			Connection con = ds.getConnection();
			System.out.println("con : "+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
