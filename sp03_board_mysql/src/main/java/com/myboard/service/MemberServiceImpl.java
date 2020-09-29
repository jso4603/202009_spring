package com.myboard.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.dao.MemberDAO;
import com.myboard.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Resource
	private BCryptPasswordEncoder encoder;
	
	@Resource
	private MemberDAO mdao;
	
	@Resource
	private BFileService fservice;

	// 회원 가입 
	@Transactional
	@Override
	public Map<String,Object> insert(MemberDTO mdto, MultipartFile photofile) throws Exception {
		String msg = null;
		//result : 0(회원가입 성공),1(회원가입 실패)
		int result = -1;
		
		//아이디 중복 체크
		MemberDTO rdto =mdao.selectOne(mdto.getUserid());
		
		if(rdto == null) { // 기존 아이디 미존재
			// 패스워드 암호화
			mdto.setPasswd(encoder.encode(mdto.getPasswd()));
			
			// 회원사진 저장하고 저장된 파일 이름
			String filename = fservice.fileUpload(photofile);
			mdto.setFilename(filename);
			logger.info("insert dto : "+mdto);
			
			mdao.insert(mdto);
			msg = "회원가입이 완료되었습니다.";
			result = 0;
		} else {
			msg = "중복된 아이디가 있습니다.";
			result = 1;
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("msg", msg);
		map.put("result", result);
		return map;
		
	}

	// 회원 수정 
	@Transactional
	@Override
	public String update(MemberDTO mdto,MultipartFile photofile) throws Exception {
		String msg = null;
		logger.debug("photofile : "+photofile);

		if (!photofile.isEmpty()) {
			String filename = fservice.fileUpload(photofile);
			mdto.setFilename(filename);
		}
			
		mdao.update(mdto);
		msg = "정보수정이 완료되었습니다.";

		return msg;
	}

	//수정 폼에 데이터 전송
	@Transactional
	@Override
	public MemberDTO modify(String userid) throws Exception {
		MemberDTO dto = mdao.selectOne(userid);
		return dto;
	}
	
	// 비밀번호 일치여부 확인
	@Transactional
	@Override
	public boolean checkPW(String passwd, String insertPW) throws Exception {
		if(encoder.matches(insertPW, passwd)) {
			return true;
		}
		return false;
	}

	// 비밀번호 변경
	@Transactional
	@Override
	public String changePW(MemberDTO dto, String oldPW, String newPW) throws Exception {
		String msg = null;
		
		if(encoder.matches(oldPW, dto.getPasswd())) {
			String passwd = encoder.encode(newPW);
			dto.setPasswd(passwd);
			
			mdao.changePW(dto);
			msg = "비밀번호가 변경되었습니다.";
		} else {
			msg = "비밀번호가 일치하지 않습니다.";
		}
		return msg;
	}

	// 회원 탈퇴
	@Transactional
	@Override
	public String delete(MemberDTO dto,String insertPW) throws Exception {
		String msg = null;

		
		// 일치하면 비밀번호 암호화 하여 dto 수정 후 DB에 입력
		if(encoder.matches(insertPW, dto.getPasswd())) {
			mdao.delete(dto.getUserid());
			msg = "회원탈퇴가 완료되었습니다.";
		} else {
			msg = "비밀번호가 일치하지 않습니다.";
		}
		
		return msg;
	}

}
