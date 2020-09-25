package org.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

// �߻�޼ҵ常 ��(�����δ� ���� �޼ҵ忡 ���� ���Ǹ� �ִ� ��)
public interface FileService {
	
	// ���� ���ε�
	public Map<String, Object> fileUpload(String name, MultipartFile myfile);
	// ���� ���� ���ε�
	public List<Map<String, Object>> fileUploads(String name, List<MultipartFile> myfiles);
	// ���� �ٿ�ε�
	public void fileDownload(String filename,HttpServletResponse response);
	
}
