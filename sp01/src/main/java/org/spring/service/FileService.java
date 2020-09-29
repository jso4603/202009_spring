package org.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

// 추상메소드만 들어감(구현부는 없고 메소드에 대한 정의만 있는 것)
public interface FileService {
	
	// 파일 업로드
	public Map<String, Object> fileUpload(String name, MultipartFile myfile);
	// 다중 파일 업로드
	public List<Map<String, Object>> fileUploads(String name, List<MultipartFile> myfiles);
	// 파일 다운로드
	public void fileDownload(String filename,HttpServletResponse response);
	
}
