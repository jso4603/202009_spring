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
	
	// servlet-context.xml�� ���� ���� ���丮 ��
	@Resource(name="saveDir")
	String saveDir;
	
	// �ϳ��� ���� ���ε�
	@Override
	public Map<String, Object> fileUpload(String name, MultipartFile myfile) {
		// ���� ���ε� ó��
		logger.info(myfile.getOriginalFilename());
		logger.info(myfile.getContentType());
		logger.info(myfile.getName());
		logger.info("������ : "+myfile.getSize());
		
		// ���ε��� ����
		logger.info(saveDir);
		
		// �����̸��� ��ġ�� �ʰ� ����
		String filename = System.currentTimeMillis() + myfile.getOriginalFilename();
		logger.info(filename);
		
		File savefile = new File(saveDir,filename); // ������ ���� ����
		
		try {
			myfile.transferTo(savefile); // savefile�� ��ο� ���� ����
		} catch (IllegalStateException e) {
			logger.info(e.toString());
			// e.printStackTrace();
		} catch (IOException e) {
			logger.info(e.toString());
			// e.printStackTrace();
		}
		
		// ���� ���� ��ȯ
		Map<String, Object> map = new HashMap<>();
		map.put("savefile", "\\" +saveDir +"\\"+ filename);
		map.put("filesize", myfile.getSize());
		map.put("filetype", myfile.getContentType());
		
		return map;
	}

	// ������ ���� ���ε�
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
				
				// ���� ���� ��ȯ
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
	
	// ���� �ٿ�ε�
	@Override
	public void fileDownload(String filename,HttpServletResponse response) {
		String fileUrl = saveDir +"/"+ filename;
		logger.info("fileUrl : "+fileUrl);
		
		try {
			// ���� �б� ��Ʈ�� ����
			FileInputStream fis = new FileInputStream(fileUrl);
			
			// �ѱ������̸� ���ڵ�
			filename = URLEncoder.encode(filename,"utf-8");
			// �� ��� �� ���� 
			//filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
			
			// ���䰴ü�� ������� ����
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			
			// ���� �������� ��Ʈ�� ����
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(fis, out);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
