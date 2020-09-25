package com.myboard.service;

import java.util.Map;

public interface LoginService {
	// ·Î±×ÀÎ
	public Map<String, Object> loginCheck(String userid, String passwd) throws Exception;
}
