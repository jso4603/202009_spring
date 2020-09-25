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
	
	// 회원가입 폼으로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		Map<String,String> map = nservice.getLoginUrl();

		session.setAttribute("state", map.get("state"));
		model.addAttribute("apiURL",map.get("apiURL"));
		return "member/join";
	}
	
	// 네이버 로그인 인증코드 콜백 매핑
	// code : 인증코드, state : 세션에 저장 된 값(클라이언트인증위함)
	@RequestMapping("/callback")
	public String callback(String code,String state,Model model,HttpSession session) throws Exception {
		// 세션의 state값과 넘겨받은 state값 일치
		String saveState = (String)session.getAttribute("state");
		if(saveState.equals(state)) {
			Map<String, String> resultMap = nservice.getUserInfo(code,state); // 개인 정보를 요청할 수 있는 토큰값 요청
			model.addAttribute("resultMap",resultMap);
		} else {
			System.out.println("인증에러");
		}
		
		
		return "member/join";
	}
	
	// 회원가입 db에 저장 후 login.jsp로 이동
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO mdto, MultipartFile photofile,
			RedirectAttributes attributes) throws Exception {

		Map<String, Object> map = mservice.insert(mdto,photofile);
		
		attributes.addFlashAttribute("msg",map.get("msg"));
		// 회원가입 성공
		if((int)map.get("result") == 0) return "redirect:/member/login";
		// 회원가입 실패
		return "redirect:/member/join";
	}
	
	// 마이페이지 폼으로 이동
	@RequestMapping(value ="/modify", method = RequestMethod.GET)
	public String modify(@ModelAttribute("userid") String userid,
			@ModelAttribute("msg") String msg, Model model) throws Exception {
		MemberDTO dto = mservice.modify(userid);
		model.addAttribute("dto",dto);
		model.addAttribute("msg",msg);
		return "member/modify";
	}
	
	// 회원정보 수정
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	public String modify(MemberDTO mdto, MultipartFile photofile,
			RedirectAttributes attributes) throws Exception {
		
		String msg = mservice.update(mdto,photofile);
		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",mdto.getUserid());
		return "redirect:/member/modify";
	}
	
	// 비밀번호 확인화면으로 이동
	@RequestMapping(value = "/checkPW", method = RequestMethod.GET)
	public String checkPW(@ModelAttribute("msg") String msg
			,Model model) throws Exception {
		model.addAttribute("msg",msg);
		return "member/checkPW";
	}
	
	// 비밀번호 일치여부 확인
	@RequestMapping(value = "/checkPW", method = RequestMethod.POST)
	public String checkPW(String passwd, String insertPW,
			RedirectAttributes attributes) throws Exception {
		
		String msg = null;

		boolean b = mservice.checkPW(passwd,insertPW);

		if(b) msg = "비밀번호 일치";
		else msg = "비밀번호 불일치";
		
		attributes.addFlashAttribute("msg",msg);
		
		return "redirect:/member/checkPW";
	}
	
	// 비밀번호 변경화면으로 이동
	@RequestMapping("/moveChangePW")
	public String moveChangePW(MemberDTO dto,Model model) throws Exception {
		model.addAttribute("dto",dto);
		return "member/changePW";
	}
	
	// 비밀번호 변경
	@RequestMapping("/changePW")
	public String changePW(MemberDTO dto, String oldPW, String newPW,
			RedirectAttributes attributes) throws Exception {
		String msg = mservice.changePW(dto,oldPW,newPW);

		attributes.addFlashAttribute("msg",msg);
		attributes.addFlashAttribute("userid",dto.getUserid());
		return "redirect:/member/modify";
	}
	
	// 삭제비밀번호 확인화면으로 이동
	@RequestMapping("/deletePW")
	public String deletePW(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "member/deletePW";
	}
	
	// 회원 탈퇴
	@RequestMapping("/delete")
	public String delete(MemberDTO dto, String insertPW,
			RedirectAttributes attributes) throws Exception {

		String msg = mservice.delete(dto,insertPW);
		attributes.addFlashAttribute("msg",msg);
		
		if(msg =="비밀번호가 일치하지 않습니다.") {
			attributes.addFlashAttribute("userid",dto.getUserid());
			return "redirect:/member/modify";
		} 
		
		return "redirect:/board/";
	}
}
