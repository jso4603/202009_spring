package org.spring.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

	@Resource
	private BCryptPasswordEncoder encoder;
	
	// ��ȣȭ �׽�Ʈ 
	public void securityTestMethod(String passwd) {
		String encodePW = encoder.encode(passwd);
		logger.info(encodePW);
		// �ؽ��Լ��� ���ؼ� 60�ڸ��� ���� �ȴ�.
		logger.info("���� : "+encodePW.length());
	}
	
	// ��ȣ��ġ���� �׽�Ʈ
	public void pwCheckTestMethod(String passwd) {
		String mypw = "$2a$10$xeleil2U2NGGI/K.wmONiu/FiJobGHR9nNjb0iKEK.lR3EBRfyqWm";
		
		// ��ȣȭ�� �н����� ��ġ ����
		boolean matchB = encoder.matches(passwd, mypw);
		logger.info("��ġ���� : "+matchB);
	}
}
