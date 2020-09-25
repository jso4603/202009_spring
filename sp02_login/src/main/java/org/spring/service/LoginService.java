package org.spring.service;

import java.util.Map;

import org.spring.dto.MemberDTO;

public interface LoginService {
	// 로그인 체크
	public Map<String, Object> loginCheck(String userid, String passwd);
}
