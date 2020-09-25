package org.spring.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);
	
	//root-context.xml���� �������� ���� ��ü�� �ڵ����� 
	@Resource 
	private BCryptPasswordEncoder encoder;
	
	//��ȣȭ �׽�Ʈ
	public void securityTestMethod(String passwd) {
		String encodePw = encoder.encode(passwd);
		logger.info(encodePw);
		logger.info("����:" + encodePw.length());
	}
	//��ȣ��ġ���� �׽�Ʈ
	public void pwCheckTestMethod(String passwd) {
		String mypw = "$2a$10$DaTNxpj.MDoQC90oe5mWieyV55LqM2avFLJQzr8qH0W8PeSq5pr2K";
//		String mypw = "$2a$10$NwQxCIpJHSw5PpQgGCSBMOfwjcokDiCCjiP/9V.NOaqTMcYF2ZKo6";
		//��ȭȭ�� �н����� ��ġ ����
		boolean matchB =  encoder.matches(passwd, mypw);
		logger.info("��ġ����:"+ matchB);

	}
	
	
	
	
	
}
