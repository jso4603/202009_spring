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

	// 로그인 체크
		@Transactional
		@Override
		public Map<String, Object> loginCheck(String userid, String passwd) throws Exception {
			String msg = null;
			//result : 0(로그인성공),1(아이디미존재),2(패스워드불일치)
			int result = -1;
			
			MemberDTO mdto = mdao.selectOne(userid);		
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
