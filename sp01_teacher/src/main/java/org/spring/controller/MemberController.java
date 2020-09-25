package org.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dao.MemberDAO;
import org.spring.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource
	private MemberDAO dao;

	@RequestMapping("/list")
	public String memberList(Model model) {
		logger.info("dao주입:"+ dao.toString());
		List<MemberDTO> list = dao.selectList();
		logger.info(list.toString());
		model.addAttribute("list", list);
		//forward : 주소 변경 안된다
		return "09_mybatis/memberList";
	}
	//insert폼으로 이동
	@RequestMapping(value = "/insert" , method = RequestMethod.GET )
	public String memberInsert() {
		return "09_mybatis/memberInsert";
	}
	
	//멤버저장하고 리스트로 이동
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public String memberInsert(MemberDTO dto, RedirectAttributes rdattr) {
		logger.debug(dto.toString());
		int cnt = dao.insert(dto);
		logger.debug(cnt+"건 저장");
		rdattr.addFlashAttribute("msg", "저장완료");
		//redirect : 주소가 변경
		return "redirect:/member/list";
	}
	
	
	
}
