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
	
	// 암호화 테스트 
	public void securityTestMethod(String passwd) {
		String encodePW = encoder.encode(passwd);
		logger.info(encodePW);
		// 해시함수에 의해서 60자리로 생성 된다.
		logger.info("길이 : "+encodePW.length());
	}
	
	// 암호일치여부 테스트
	public void pwCheckTestMethod(String passwd) {
		String mypw = "$2a$10$xeleil2U2NGGI/K.wmONiu/FiJobGHR9nNjb0iKEK.lR3EBRfyqWm";
		
		// 암호화된 패스워드 일치 여부
		boolean matchB = encoder.matches(passwd, mypw);
		logger.info("일치여부 : "+matchB);
	}
}
