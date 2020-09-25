package com.myboard.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;


public interface NaverLoginService {
	public Map<String,String> getLoginUrl() throws UnsupportedEncodingException;
	public Map<String, String> getUserInfo(String code, String state) throws Exception;
	public String getToken(String code, String state) throws Exception;
}
