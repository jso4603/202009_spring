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
		
	// �α��� ȭ�� ���
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(@ModelAttribute("msg") String msg) {
		return "Login/login";
	}
	
	// �α��� 
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(String userid, String passwd,
			RedirectAttributes redirectAttributes, HttpSession httpSession) {
		logger.debug("login id/pw : "+userid+"/"+passwd);
		Map<String, Object> map = service.loginCheck(userid,passwd);
		redirectAttributes.addFlashAttribute("msg",map.get("msg"));
		redirectAttributes.addFlashAttribute("userid",userid);
		
		// redirect : ȭ���̵� �ּ� �̵�(@RequestMapping�� ���� �̵�������)
		// .jsp �� ���� �̵��� �Ұ���
		
		// �α��� ������ ���
		if((int)map.get("result") == 0) {
			httpSession.setAttribute("userid", userid);
			httpSession.setMaxInactiveInterval(60*60);
			return "redirect:/login/main";
		} 

		return "redirect:/login/";
	}
	
	// �������� �̵�
	@RequestMapping(value = "/main")
	public String main(@ModelAttribute("userid") String userid) {
		logger.debug("main userid : "+userid);
		return "Login/main";
	}
	
	// �α׾ƿ�ó��
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes attributes) {
		session.invalidate(); //�������� �Ҹ�
		String msg = "�α׾ƿ� �Ǿ����ϴ�.";
		attributes.addFlashAttribute("msg",msg);
		return "redirect:/login/";
	}
}
