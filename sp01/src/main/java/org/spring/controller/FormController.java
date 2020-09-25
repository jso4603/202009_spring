package org.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
	@RequestMapping("/main")
	public String mainForm() {
		
		return "16_mainForm/02_main";
	}
	
	
	@RequestMapping("/home")
	public String home() {
		
		return "16_mainForm/02_home";
	}
}
