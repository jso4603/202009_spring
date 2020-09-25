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
	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
	
	//servlet-context.xml에 파일 저장 디렉토리 빈
	@Resource(name="saveDir")
	String saveDir; 
	
	@Override
	public Map<String, Object> fileUpload(String name, MultipartFile myfile) {
		//파일 업로드 처리
//		logger.info(myfile.getOriginalFilename());
//		logger.info(myfile.getContentType());
//		logger.info(myfile.getName());
//		logger.info("사이즈:" + myfile.getSize());
		//업로드할 폴더
//		logger.info(saveDir);
		//파일이름이 겹치지 않게 생성
		String filename = System.currentTimeMillis() + myfile.getOriginalFilename();
//		System.out.println(filename);
		
		File savefile = new File(saveDir,filename); //파일 객체생성
		Map<String, Object> resultMap = null;
		try {
			myfile.transferTo(savefile); //savefile의 경로에 파일저장
			//파일 정보 반환
			resultMap = new HashMap<>();
			resultMap.put("savefile", saveDir +"\\" + filename);
			resultMap.put("filesize", myfile.getSize());
			resultMap.put("filetype", myfile.getContentType());
		} catch (IllegalStateException e) {
			logger.info(e.toString());
//			e.printStackTrace();
		} catch (IOException e) {
			logger.info(e.toString());
//			e.printStackTrace();
		}

		return resultMap;
		
	}

	//다중 파일 업로드
	@Override
	public List<Map<String, Object>> fileUploads(String name, List<MultipartFile> myfiles) {
		List<Map<String,Object>> list = new ArrayList<>();
		for(MultipartFile mf: myfiles) {
			Map<String, Object> map = new HashMap<>();
			//파일이름 생성
			String filename = System.currentTimeMillis()+mf.getOriginalFilename();
			//전송할 파일경로와 이름 생성
			File f = new File(saveDir, filename);

			try {
				mf.transferTo(f);
				map.put("savefile",filename);
				map.put("filesize", mf.getSize());
				map.put("filetype", mf.getContentType());
				list.add(map);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	//파일 다운로드
	@Override
	public void fileDownload(String filename, HttpServletResponse response) {
		String fileUrl = saveDir + "/" +filename;
		logger.info(fileUrl);

		try {
			//파일 읽기 스트림 생성
			FileInputStream fis = new FileInputStream(fileUrl);
			
			//한글파일이름 인코딩
			filename = URLEncoder.encode(filename, "utf-8");
			//filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
			
			//응답객체의 헤더설정 변경
			//첨부파일 형태로 변경
			//파일이름 지정
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			
			
			//파일 내보내기 스트림  생성
			OutputStream out = response.getOutputStream();
			//inputstream에서 데이타를 읽어서 outputstream으로 내보냄
			FileCopyUtils.copy(fis, out);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
