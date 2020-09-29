package org.spring.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Resource
	private FileService service;
	
	//한개의 파일업로드 폼으로 가기
	@RequestMapping(value="/upload" , method = RequestMethod.GET)
	public String fileUpload() {
		return "10_fileUpload";
	}
	
	//한개의 파일을 업로드
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String fileUpload(String name, MultipartFile myfile, Model model) {
		logger.info(name);
		logger.info(myfile.toString());
		Map<String, Object> resultMap = service.fileUpload(name, myfile);
		model.addAttribute("resultMap",resultMap);
		
		return "10_fileUpload";
		
	}
	
	//여러개 파일 업로드 폼으로 이동
	@RequestMapping(value = "/uploads", method = RequestMethod.GET)
	public String fileUploads() {
		return "11_multiFileUpload";
	}
	//여러개 파일 업로드
	@RequestMapping(value = "/uploads", method = RequestMethod.POST)
	public String fileUploads(String name, List<MultipartFile> myfiles, Model model) {
		logger.info(name);
		logger.info(myfiles.toString());
		List<Map<String,Object>> resultList = service.fileUploads(name, myfiles);
		//화면에 리스트 전달
		model.addAttribute("resultList", resultList);
		
		
		return "11_multiFileUpload";
	}
	
	//파일 다운로드
	@RequestMapping("/download")
	public void fileDownload(String filename, HttpServletResponse response) {
		logger.info(filename);
		service.fileDownload(filename, response);
	}
	
	
	
	
	
}
