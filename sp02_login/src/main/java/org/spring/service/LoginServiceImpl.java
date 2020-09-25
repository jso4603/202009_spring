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

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	//�ڵ�����(��ü�� ������ ���� : new MemberDAO(); �� �� �ʿ䰡 ����.)
	@Resource
	private MemberDAO dao;
	
	// ��ȣȭ ����
	@Resource
	private BCryptPasswordEncoder encoder;

	// �α��� üũ
	@Override
	public Map<String, Object> loginCheck(String userid, String passwd) {
		String msg = null;
		//result : 0(�α��μ���),1(���̵������),2(�н��������ġ)
		int result = -1;
		
		MemberDTO mdto = dao.selectOne(userid);		
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
