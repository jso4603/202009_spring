package org.spring.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	// ���� ���丮
	// servlet-context.xml�� ���� ���� ���丮 ��
	@Resource(name="saveDir")
	String saveDir;
	
	@Override
	public String fileUpload(MultipartFile file) {
		// ���� �̸�
		String filename = null;
		
		try {
			// �����̸��� ��ġ�� �ʰ� ����
			filename = System.currentTimeMillis() + file.getOriginalFilename();
			File f = new File(saveDir,filename); // ������ ���� ����
			file.transferTo(f); // f �� ��ο� ���� ����
		} catch (IllegalStateException e) {
			filename = null;	
			e.printStackTrace();
		} catch (IOException e) {
			filename = null;
			e.printStackTrace();
		} 	
		return filename;
	}
}
