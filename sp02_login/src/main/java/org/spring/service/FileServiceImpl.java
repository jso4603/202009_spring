package org.spring.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	// 저장 디렉토리
	// servlet-context.xml에 파일 저장 디렉토리 빈
	@Resource(name="saveDir")
	String saveDir;
	
	@Override
	public String fileUpload(MultipartFile file) {
		// 파일 이름
		String filename = null;
		
		try {
			// 파일이름이 겹치지 않게 생성
			filename = System.currentTimeMillis() + file.getOriginalFilename();
			File f = new File(saveDir,filename); // 저장할 파일 생성
			file.transferTo(f); // f 의 경로에 파일 저장
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
