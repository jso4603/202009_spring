package org.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	//추상메소드
	//하나의 파일을 업로드
	public Map<String, Object> fileUpload(String name, MultipartFile myfile);
	//다중 파일 업로드
	public List<Map<String,Object>> fileUploads(String name, List<MultipartFile> myfiles);
	
	//파일다운로드
	public void fileDownload(String filename, HttpServletResponse response);
	
}
