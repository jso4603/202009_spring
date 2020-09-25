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

//������ �׽�Ʈ�� ���� ����
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration : � xml�� �����ð���
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class dataSourceTest {
	
	@Inject
	private DataSource ds;
	
	@Test
	public void test() {
		//������ �ҽ� �׽�Ʈ
		try {
			Connection con = ds.getConnection();
			System.out.println("con : "+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
