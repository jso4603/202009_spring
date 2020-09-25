package com.myboard.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dao.MemberDAO;
import com.myboard.dto.MemberDTO;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource
	private BCryptPasswordEncoder encoder;
	
	@Resource
	private MemberDAO mdao;

	// �α��� üũ
		@Transactional
		@Override
		public Map<String, Object> loginCheck(String userid, String passwd) throws Exception {
			String msg = null;
			//result : 0(�α��μ���),1(���̵������),2(�н��������ġ)
			int result = -1;
			
			MemberDTO mdto = mdao.selectOne(userid);		
			logger.debug("loginCheck id/pw : "+userid+"/"+passwd);

			if(mdto == null) {
				msg = "�������� �ʴ� ���̵��Դϴ�.";
				result = 1;	
			}else {
				if(encoder.matches(passwd, mdto.getPasswd())){
					msg = "�α��� ����";
					result = 0;
				} else {
					msg = "��й�ȣ�� �ٸ��ϴ�.";
					result = 2;
				}
			}
			
			Map<String, Object> map = new HashMap<>();
			map.put("msg", msg);
			map.put("result", result);
			return map;	
		}
}