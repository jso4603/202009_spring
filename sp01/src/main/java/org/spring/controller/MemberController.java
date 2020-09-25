package org.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dao.MemberDAO;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Resource
	private MemberDAO dao;
	
	//09_Mybatis/memberList.jsp ȭ�� ��� & ȸ�� ��ü ��ȸ
	@RequestMapping("/list")
	public String memberList(Model model,@ModelAttribute("msg") String msg) {
		logger.debug("dao���� : "+dao.toString());
		List<MemberDTO> list = dao.selectList();
		logger.debug("memberList list : "+list.toString());
		model.addAttribute("list",list);
		return "09_Mybatis/memberList";
	}
	
	//insert������ �̵�
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String memberInsert() {
		return "09_Mybatis/memberInsert";
	}
	
	//��������ϰ� ����Ʈ�� �̵�
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String memberInsert(MemberDTO dto, Model model,
			RedirectAttributes attributes) {
		int cnt = dao.insert(dto);
		logger.debug("memberInsert cnt : "+cnt);
		attributes.addFlashAttribute("msg",cnt+"�� �߰��Ϸ�");
		
		return "redirect:/member/list";
	}
	
	
	
	
}
