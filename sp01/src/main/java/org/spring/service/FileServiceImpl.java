package org.spring.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	// servlet-context.xml에 파일 저장 디렉토리 빈
	@Resource(name="saveDir")
	String saveDir;
	
	// 하나의 파일 업로드
	@Override
	public Map<String, Object> fileUpload(String name, MultipartFile myfile) {
		// 파일 업로드 처리
		logger.info(myfile.getOriginalFilename());
		logger.info(myfile.getContentType());
		logger.info(myfile.getName());
		logger.info("사이즈 : "+myfile.getSize());
		
		// 업로드할 폴더
		logger.info(saveDir);
		
		// 파일이름이 겹치지 않게 생성
		String filename = System.currentTimeMillis() + myfile.getOriginalFilename();
		logger.info(filename);
		
		File savefile = new File(saveDir,filename); // 저장할 파일 생성
		
		try {
			myfile.transferTo(savefile); // savefile의 경로에 파일 저장
		} catch (IllegalStateException e) {
			logger.info(e.toString());
			// e.printStackTrace();
		} catch (IOException e) {
			logger.info(e.toString());
			// e.printStackTrace();
		}
		
		// 파일 정보 반환
		Map<String, Object> map = new HashMap<>();
		map.put("savefile", "\\" +saveDir +"\\"+ filename);
		map.put("filesize", myfile.getSize());
		map.put("filetype", myfile.getContentType());
		
		return map;
	}

	// 여러개 파일 업로드
	@Override
	public List<Map<String, Object>> fileUploads(String name, List<MultipartFile> myfiles) {
		List<Map<String, Object>> list = new ArrayList<>();
		
		for(MultipartFile myfile : myfiles) {
			Map<String, Object> map = new HashMap<>();
			String filename = System.currentTimeMillis() + myfile.getOriginalFilename();
			File savefile = new File(saveDir,filename);
			logger.info(filename);
			try {
				myfile.transferTo(savefile);
				
				// 파일 정보 반환
				map.put("savefile", filename);
				map.put("filesize", myfile.getSize());
				map.put("filetype", myfile.getContentType());
				list.add(map);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			logger.info("list : "+list);
		}
		
		return list;
	}
	
	// 파일 다운로드
	@Override
	public void fileDownload(String filename,HttpServletResponse response) {
		String fileUrl = saveDir +"/"+ filename;
		logger.info("fileUrl : "+fileUrl);
		
		try {
			// 파일 읽기 스트림 생성
			FileInputStream fis = new FileInputStream(fileUrl);
			
			// 한글파일이름 인코딩
			filename = URLEncoder.encode(filename,"utf-8");
			// 두 방법 다 가능 
			//filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
			
			// 응답객체의 헤더설정 변경
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			
			// 파일 내보내기 스트림 생성
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fis, out);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
