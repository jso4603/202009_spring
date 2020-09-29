package org.spring.controller;

import javax.annotation.Resource;

import org.spring.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bank")
public class BankController {
	
	@Resource
	private BankService bankService;
	
	//금액 이체 폼으로 이동
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String bank() {
		return "12_bankTransaction";
	}

	//금액 이체
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public String bank(@RequestParam("money") int money) {
		bankService.insert(money);
		return "12_bankTransaction";
	}
	
	
	

}
