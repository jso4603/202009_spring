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
	
	// 회원가입 폼으로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "Member/join";
	}
	
	// 회원가입 db에 저장 후 login.jsp로 이동
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
	
	// 마이페이지 폼으로 이동
	@RequestMapping(value ="/modify", method = RequestMethod.GET)
	public String modify(@ModelAttribute("userid") String userid,
			@ModelAttribute("msg") String msg, Model model) {

		MemberDTO dto = service.modify(userid);
		model.addAttribute("dto",dto);
		model.addAttribute("msg",msg);
		return "Member/modify";
	}
	
	// 회원정보 수정
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	public String modify(MemberDTO dto, MultipartFile photofile,
			RedirectAttributes attributes) {
		
		String msg = service.update(dto,photofile);
		
		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// 회원 탈퇴
	@RequestMapping("/delete")
	public String delete(MemberDTO dto, String insertPW, RedirectAttributes attributes) {
		String msg = service.delete(dto,insertPW);
		attributes.addFlashAttribute("msg",msg);
		
		if(msg =="비밀번호가 일치하지 않습니다.") {
			attributes.addFlashAttribute("userid",dto.getUserid());
			return "redirect:/member/modify";
		} 
		
		return "redirect:/login/";
	}
	
	// 비밀번호 변경
	@RequestMapping("/changePW")
	public String changePW(MemberDTO dto, String oldPW, String newPW,
			RedirectAttributes attributes) {
		String msg = service.changePW(dto,oldPW,newPW);

		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// 비밀번호 일치여부 확인
	@RequestMapping(value = "/checkPW", method = RequestMethod.POST)
	public String checkPW(String passwd, String insertPW,
			RedirectAttributes attributes) {
		
		String msg = null;

		boolean b = service.checkPW(passwd,insertPW);

		if(b) msg = "비밀번호 일치";
		else msg = "비밀번호 불일치";
		
		attributes.addFlashAttribute("msg",msg);
		
		return "redirect:/member/checkPW";
	}
	
	// 비밀번호 확인화면으로 이동
		@RequestMapping(value = "/checkPW", method = RequestMethod.GET)
		public String checkPW(@ModelAttribute("msg") String msg,Model model) {
			model.addAttribute("msg",msg);
			return "Member/checkPW";
	}
	
	// 비밀번호 변경화면으로 이동
	@RequestMapping("/moveChangePW")
	public String moveChangePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "Member/changePW";
	}
	
	// 삭제비밀번호 확인화면으로 이동
	@RequestMapping("/deletePW")
	public String deletePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "Member/deletePW";
	}
}
