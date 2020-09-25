package com.myboard.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myboard.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private LoginService lservice;
	
	// �α��� ������ �̵�
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() throws UnsupportedEncodingException {
		return "login/login";
	}
	
	// �α���
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(String userid, String passwd,
			RedirectAttributes redirectAttributes,
			HttpSession httpSession) throws Exception {

		Map<String, Object> map = lservice.loginCheck(userid,passwd);
		redirectAttributes.addFlashAttribute("msg",map.get("msg"));
		redirectAttributes.addFlashAttribute("userid",userid);

		// �α��� ������ ���
		if((int)map.get("result") == 0) {
			httpSession.setAttribute("userid", userid);
			httpSession.setMaxInactiveInterval(60*60);
			return "redirect:/board/list";
		} 
		
		// �α��� ����
		return "redirect:/login/login";
	}

}