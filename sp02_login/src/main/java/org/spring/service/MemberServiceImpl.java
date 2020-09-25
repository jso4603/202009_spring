package org.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dao.MemberDAO;
import org.spring.dto.MemberDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Resource
	private BCryptPasswordEncoder encoder;
	
	@Resource
	private MemberDAO dao;
	
	@Resource
	private FileService fservice;
	
	// ȸ������
	@Override
	public Map<String,Object> insert(MemberDTO dto,MultipartFile photofile) {
		String msg = null;
		//result : 0(ȸ������ ����),1(ȸ������ ����)
		int result = -1; 
		
		//���̵� �ߺ� üũ
		MemberDTO rdto = dao.selectOne(dto.getUserid());
		
		if(rdto == null) { // ���� ���̵� ������
			// �н����� ��ȣȭ
			dto.setPasswd(encoder.encode(dto.getPasswd()));
			
			// ȸ������ �����ϰ� ����� ���� �̸�
			String filename = fservice.fileUpload(photofile);
			dto.setFilename(filename);
			logger.info("insert dto : "+dto);
			
			dao.insert(dto);
			msg = "ȸ�������� �Ϸ�Ǿ����ϴ�.";
			result = 0;
		} else {
			msg = "�ߺ��� ���̵� �ֽ��ϴ�.";
			result = 1;
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("msg", msg);
		map.put("result", result);
		return map;
	}

	//���� ���� ������ ������
	@Override
	public MemberDTO modify(String userid) {
		MemberDTO dto = dao.selectOne(userid);
		return dto;
	}
	
	// ȸ������ ����
	@Override
	public String update(MemberDTO dto,MultipartFile photofile) {
		String msg = null;
		logger.debug("photofile : "+photofile);

		if (!photofile.isEmpty()) {
			String filename = fservice.fileUpload(photofile);
			dto.setFilename(filename);
		}
			
		dao.update(dto);
		msg = "���������� �Ϸ�Ǿ����ϴ�.";

		return msg;
	}

	// ȸ�� Ż��
	@Override
	public String delete(MemberDTO dto,String insertPW) {
		String msg = null;

		
		// ��ġ�ϸ� ��й�ȣ ��ȣȭ �Ͽ� dto ���� �� DB�� �Է�
		if(encoder.matches(insertPW, dto.getPasswd())) {
			dao.delete(dto.getUserid());
			msg = "ȸ��Ż�� �Ϸ�Ǿ����ϴ�.";
		} else {
			msg = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		}
		
		return msg;
	}

	// ��й�ȣ ����
	@Override
	public String changePW(MemberDTO dto,String oldPW,String newPW) {
		String msg = null;
		
		if(encoder.matches(oldPW, dto.getPasswd())) {
			String passwd = encoder.encode(newPW);
			dto.setPasswd(passwd);
			
			dao.changePW(dto);
			msg = "��й�ȣ�� ����Ǿ����ϴ�.";
		} else {
			msg = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		}
		return msg;
	}
	
	// ��й�ȣ ��ġ���� Ȯ��
	@Override
	public boolean checkPW(String passwd, String insertPW) {
		if(encoder.matches(insertPW, passwd)) {
			return true;
		}
		return false;
	}
}
