package com.myboard.service;

import java.util.Map;

public interface LoginService {
	// 로그인
	public Map<String, Object> loginCheck(String userid, String passwd) throws Exception;
}
