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
	
	//자동주입(객체를 변수에 대입 : new MemberDAO(); 를 쓸 필요가 없다.)
	@Resource
	private MemberDAO dao;
	
	// 암호화 주입
	@Resource
	private BCryptPasswordEncoder encoder;

	// 로그인 체크
	@Override
	public Map<String, Object> loginCheck(String userid, String passwd) {
		String msg = null;
		//result : 0(로그인성공),1(아이디미존재),2(패스워드불일치)
		int result = -1;
		
		MemberDTO mdto = dao.selectOne(userid);		
		logger.debug("loginCheck id/pw : "+userid+"/"+passwd);

		if(mdto == null) {
			msg = "존재하지 않는 아이디입니다.";
			result = 1;	
		}else {
			if(encoder.matches(passwd, mdto.getPasswd())){
				msg = "로그인 성공";
				result = 0;
			} else {
				msg = "비밀번호가 다릅니다.";
				result = 2;
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("msg", msg);
		map.put("result", result);
		return map;	
	}
}
