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
	
	// ���̹��α��� �����ڵ� ��û
	@RequestMapping("/naverLogin")
	public String naverLogin(Model model,HttpSession session) throws UnsupportedEncodingException {
		Map<String,String> map = nservice.getLoginUrl();

		session.setAttribute("state", map.get("state"));
		model.addAttribute("apiURL",map.get("apiURL"));
		return "15_naverLogin/01_naverlogin";
	}
	// ���̹� �α��� �����ڵ� �ݹ� ����
	// code : �����ڵ�, state : ���ǿ� ���� �� ��(Ŭ���̾�Ʈ��������)
	@RequestMapping("/callback")
	public String callback(String code,String state,Model model,HttpSession session) throws ParseException {
		// ������ state���� �Ѱܹ��� state�� ��ġ
		String saveState = (String)session.getAttribute("state");
		if(saveState.equals(state)) {
			Map<String, String> resultMap = nservice.getUserInfo(code,state); // ���� ������ ��û�� �� �ִ� ��ū�� ��û
			model.addAttribute("resultMap",resultMap);
		} else {
			System.out.println("��������");
		}
		
		
		return "15_naverLogin/02_callback";
	}
}