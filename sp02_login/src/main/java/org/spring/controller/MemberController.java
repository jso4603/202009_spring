package org.spring.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dto.MemberDTO;
import org.spring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Resource
	private MemberService service;
	
	// ȸ������ ������ �̵�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "Member/join";
	}
	
	// ȸ������ db�� ���� �� login.jsp�� �̵�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO dto,MultipartFile photofile, 
			RedirectAttributes attributes) {
		
		Map<String, Object> map = service.insert(dto,photofile);
		
		attributes.addFlashAttribute("msg",map.get("msg"));
		if((int)map.get("result") == 0) {
			return "redirect:/login/";
		}
		return "redirect:/member/join";
	}
	
	// ���������� ������ �̵�
	@RequestMapping(value ="/modify", method = RequestMethod.GET)
	public String modify(@ModelAttribute("userid") String userid,
			@ModelAttribute("msg") String msg, Model model) {

		MemberDTO dto = service.modify(userid);
		model.addAttribute("dto",dto);
		model.addAttribute("msg",msg);
		return "Member/modify";
	}
	
	// ȸ������ ����
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	public String modify(MemberDTO dto, MultipartFile photofile,
			RedirectAttributes attributes) {
		
		String msg = service.update(dto,photofile);
		
		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// ȸ�� Ż��
	@RequestMapping("/delete")
	public String delete(MemberDTO dto, String insertPW, RedirectAttributes attributes) {
		String msg = service.delete(dto,insertPW);
		attributes.addFlashAttribute("msg",msg);
		
		if(msg =="��й�ȣ�� ��ġ���� �ʽ��ϴ�.") {
			attributes.addFlashAttribute("userid",dto.getUserid());
			return "redirect:/member/modify";
		} 
		
		return "redirect:/login/";
	}
	
	// ��й�ȣ ����
	@RequestMapping("/changePW")
	public String changePW(MemberDTO dto, String oldPW, String newPW,
			RedirectAttributes attributes) {
		String msg = service.changePW(dto,oldPW,newPW);

		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// ��й�ȣ ��ġ���� Ȯ��
	@RequestMapping(value = "/checkPW", method = RequestMethod.POST)
	public String checkPW(String passwd, String insertPW,
			RedirectAttributes attributes) {
		
		String msg = null;

		boolean b = service.checkPW(passwd,insertPW);

		if(b) msg = "��й�ȣ ��ġ";
		else msg = "��й�ȣ ����ġ";
		
		attributes.addFlashAttribute("msg",msg);
		
		return "redirect:/member/checkPW";
	}
	
	// ��й�ȣ Ȯ��ȭ������ �̵�
		@RequestMapping(value = "/checkPW", method = RequestMethod.GET)
		public String checkPW(@ModelAttribute("msg") String msg,Model model) {
			model.addAttribute("msg",msg);
			return "Member/checkPW";
	}
	
	// ��й�ȣ ����ȭ������ �̵�
	@RequestMapping("/moveChangePW")
	public String moveChangePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "Member/changePW";
	}
	
	// ������й�ȣ Ȯ��ȭ������ �̵�
	@RequestMapping("/deletePW")
	public String deletePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "Member/deletePW";
	}
}