package org.spring.service;

import java.util.Map;

import org.spring.dto.MemberDTO;

public interface LoginService {
	// �α��� üũ
	public Map<String, Object> loginCheck(String userid, String passwd);
}
