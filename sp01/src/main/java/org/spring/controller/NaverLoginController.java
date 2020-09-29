package org.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.spring.service.NaverLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class NaverLoginController {
	
	@Resource
	private NaverLoginService nservice;
	
	// 네이버로그인 인증코드 요청
	@RequestMapping("/naverLogin")
	public String naverLogin(Model model,HttpSession session) throws UnsupportedEncodingException {
		Map<String,String> map = nservice.getLoginUrl();

		session.setAttribute("state", map.get("state"));
		model.addAttribute("apiURL",map.get("apiURL"));
		return "15_naverLogin/01_naverlogin";
	}
	// 네이버 로그인 인증코드 콜백 매핑
	// code : 인증코드, state : 세션에 저장 된 값(클라이언트인증위함)
	@RequestMapping("/callback")
	public String callback(String code,String state,Model model,HttpSession session) throws ParseException {
		// 세션의 state값과 넘겨받은 state값 일치
		String saveState = (String)session.getAttribute("state");
		if(saveState.equals(state)) {
			Map<String, String> resultMap = nservice.getUserInfo(code,state); // 개인 정보를 요청할 수 있는 토큰값 요청
			model.addAttribute("resultMap",resultMap);
		} else {
			System.out.println("인증에러");
		}
		
		
		return "15_naverLogin/02_callback";
	}
}
