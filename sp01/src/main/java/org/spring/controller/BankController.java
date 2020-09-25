package org.spring.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dao.BankADAO;
import org.spring.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bank")
public class BankController {
	private static final Logger logger = LoggerFactory.getLogger(BankController.class);
	
	@Resource
	private BankService service;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String main() {
		return "12_bankTest";	
	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String insert(@RequestParam("money") int money) {
		service.insert(money);
		return "12_bankTest";
	}
}
