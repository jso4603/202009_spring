package org.spring.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);
	
	//root-context.xml에서 스프링이 만든 객체를 자동주입 
	@Resource 
	private BCryptPasswordEncoder encoder;
	
	//암호화 테스트
	public void securityTestMethod(String passwd) {
		String encodePw = encoder.encode(passwd);
		logger.info(encodePw);
		logger.info("길이:" + encodePw.length());
	}
	//암호일치여부 테스트
	public void pwCheckTestMethod(String passwd) {
		String mypw = "$2a$10$DaTNxpj.MDoQC90oe5mWieyV55LqM2avFLJQzr8qH0W8PeSq5pr2K";
//		String mypw = "$2a$10$NwQxCIpJHSw5PpQgGCSBMOfwjcokDiCCjiP/9V.NOaqTMcYF2ZKo6";
		//암화화된 패스워드 일치 여부
		boolean matchB =  encoder.matches(passwd, mypw);
		logger.info("일치여부:"+ matchB);

	}
	
	
	
	
	
}
