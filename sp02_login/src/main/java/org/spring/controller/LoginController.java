package org.spring.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dto.MemberDTO;
import org.spring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private LoginService service;
		
	// 로그인 화면 출력
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(@ModelAttribute("msg") String msg) {
		return "Login/login";
	}
	
	// 로그인 
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(String userid, String passwd,
			RedirectAttributes redirectAttributes, HttpSession httpSession) {
		logger.debug("login id/pw : "+userid+"/"+passwd);
		Map<String, Object> map = service.loginCheck(userid,passwd);
		redirectAttributes.addFlashAttribute("msg",map.get("msg"));
		redirectAttributes.addFlashAttribute("userid",userid);
		
		// redirect : 화면이동 주소 이동(@RequestMapping에 의한 이동만가능)
		// .jsp 로 직접 이동이 불가능
		
		// 로그인 성공한 경우
		if((int)map.get("result") == 0) {
			httpSession.setAttribute("userid", userid);
			httpSession.setMaxInactiveInterval(60*60);
			return "redirect:/login/main";
		} 

		return "redirect:/login/";
	}
	
	// 메인으로 이동
	@RequestMapping(value = "/main")
	public String main(@ModelAttribute("userid") String userid) {
		logger.debug("main userid : "+userid);
		return "Login/main";
	}
	
	// 로그아웃처리
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes attributes) {
		session.invalidate(); //세션정보 소멸
		String msg = "로그아웃 되었습니다.";
		attributes.addFlashAttribute("msg",msg);
		return "redirect:/login/";
	}
}
