package org.spring.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	// ���� �����ϰ� ���ϸ��� �����ϴ� �޼ҵ�
	public String fileUpload(MultipartFile file);
}
