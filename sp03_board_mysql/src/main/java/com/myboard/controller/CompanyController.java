package com.myboard.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService cservice;

	// ȸ��Ұ� ȭ�� �̵�
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String company() throws Exception {
		return "/company/info";
	}
	
	// ȸ�� ���� ���
	@RequestMapping("/geocodingFind")
	@ResponseBody
	public Map<String,Double> mapGeocodingFind(@RequestParam String address) throws IOException, ParseException {
		Map<String,Double> resultMap = cservice.getGeocoding(address);
		
		return resultMap;
	}
	
}