package com.myboard.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myboard.dto.MemberDTO;
import com.myboard.service.MemberService;
import com.myboard.service.NaverLoginService;

@Controller
@RequestMapping("/member")
@SessionAttributes("pdto")
public class MemberController {
	
	@Resource
	private MemberService mservice;
	
	@Resource
	private NaverLoginService nservice;
	
	// ȸ������ ������ �̵�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		Map<String,String> map = nservice.getLoginUrl();

		session.setAttribute("state", map.get("state"));
		model.addAttribute("apiURL",map.get("apiURL"));
		return "member/join";
	}
	
	// ���̹� �α��� �����ڵ� �ݹ� ����
	// code : �����ڵ�, state : ���ǿ� ���� �� ��(Ŭ���̾�Ʈ��������)
	@RequestMapping("/callback")
	public String callback(String code,String state,Model model,HttpSession session) throws Exception {
		// ������ state���� �Ѱܹ��� state�� ��ġ
		String saveState = (String)session.getAttribute("state");
		if(saveState.equals(state)) {
			Map<String, String> resultMap = nservice.getUserInfo(code,state); // ���� ������ ��û�� �� �ִ� ��ū�� ��û
			model.addAttribute("resultMap",resultMap);
		} else {
			System.out.println("��������");
		}
		
		
		return "member/join";
	}
	
	// ȸ������ db�� ���� �� login.jsp�� �̵�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO mdto, MultipartFile photofile,
			RedirectAttributes attributes) throws Exception {

		Map<String, Object> map = mservice.insert(mdto,photofile);
		
		attributes.addFlashAttribute("msg",map.get("msg"));
		// ȸ������ ����
		if((int)map.get("result") == 0) return "redirect:/member/login";
		// ȸ������ ����
		return "redirect:/member/join";
	}
	
	// ���������� ������ �̵�
	@RequestMapping(value ="/modify", method = RequestMethod.GET)
	public String modify(@ModelAttribute("userid") String userid,
			@ModelAttribute("msg") String msg, Model model) throws Exception {
		MemberDTO dto = mservice.modify(userid);
		model.addAttribute("dto",dto);
		model.addAttribute("msg",msg);
		return "member/modify";
	}
	
	// ȸ������ ����
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	public String modify(MemberDTO mdto, MultipartFile photofile,
			RedirectAttributes attributes) throws Exception {
		
		String msg = mservice.update(mdto,photofile);
		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",mdto.getUserid());
		return "redirect:/member/modify";
	}
	
	// ��й�ȣ Ȯ��ȭ������ �̵�
	@RequestMapping(value = "/checkPW", method = RequestMethod.GET)
	public String checkPW(@ModelAttribute("msg") String msg
			,Model model) throws Exception {
		model.addAttribute("msg",msg);
		return "member/checkPW";
	}
	
	// ��й�ȣ ��ġ���� Ȯ��
	@RequestMapping(value = "/checkPW", method = RequestMethod.POST)
	public String checkPW(String passwd, String insertPW,
			RedirectAttributes attributes) throws Exception {
		
		String msg = null;

		boolean b = mservice.checkPW(passwd,insertPW);

		if(b) msg = "��й�ȣ ��ġ";
		else msg = "��й�ȣ ����ġ";
		
		attributes.addFlashAttribute("msg",msg);
		
		return "redirect:/member/checkPW";
	}
	
	// ��й�ȣ ����ȭ������ �̵�
	@RequestMapping("/moveChangePW")
	public String moveChangePW(MemberDTO dto,Model model) throws Exception {
		model.addAttribute("dto",dto);
		return "member/changePW";
	}
	
	// ��й�ȣ ����
	@RequestMapping("/changePW")
	public String changePW(MemberDTO dto, String oldPW, String newPW,
			RedirectAttributes attributes) throws Exception {
		String msg = mservice.changePW(dto,oldPW,newPW);

		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// ������й�ȣ Ȯ��ȭ������ �̵�
	@RequestMapping("/deletePW")
	public String deletePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "member/deletePW";
	}
	
	// ȸ�� Ż��
	@RequestMapping("/delete")
	public String delete(MemberDTO dto, String insertPW,
			RedirectAttributes attributes) throws Exception {

		String msg = mservice.delete(dto,insertPW);
		attributes.addFlashAttribute("msg",msg);
		
		if(msg =="��й�ȣ�� ��ġ���� �ʽ��ϴ�.") {
			attributes.addFlashAttribute("userid",dto.getUserid());
			return "redirect:/member/modify";
		} 
		
		return "redirect:/board/";
	}
}
