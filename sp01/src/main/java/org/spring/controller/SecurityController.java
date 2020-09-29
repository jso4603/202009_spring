package org.spring.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.service.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/security")
public class SecurityController {
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	@Resource
	private SecurityService service;
	
	// 패스워드 암호화
	@RequestMapping("/encode")
	public void security(@RequestParam String passwd) {
		logger.info(passwd);
		service.securityTestMethod(passwd);
	}
	
	// 등록된 패스워드 일치확인
	@RequestMapping("/pwcheck")
	public void sequrityCheck(String passwd) {
		service.pwCheckTestMethod(passwd);
	}
}
