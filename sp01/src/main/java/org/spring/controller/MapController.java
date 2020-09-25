package org.spring.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.parser.ParseException;
import org.spring.service.MapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@Resource
	private MapService mapservice;
	
	// �⺻ ��
	@RequestMapping("/map01")
	public String mapSample() {
		return "14_map/01_mapApi";
	}
	
	@RequestMapping("/geocoding")
	public String mapGeocoding() {
		return "14_map/02_geocoding";
	}
	// �ּҸ� �̿��ؼ� ���浵 ã��
	@RequestMapping("/geocodingFind")
	@ResponseBody
	public Map<String,Double> mapGeocodingFind(@RequestParam String address) throws IOException, ParseException {
		System.out.println(address);
		Map<String,Double> resultMap = mapservice.getGeocoding(address);
		
		return resultMap;
	}
	
}
