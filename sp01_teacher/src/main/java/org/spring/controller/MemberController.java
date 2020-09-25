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
		logger.info("dao����:"+ dao.toString());
		List<MemberDTO> list = dao.selectList();
		logger.info(list.toString());
		model.addAttribute("list", list);
		//forward : �ּ� ���� �ȵȴ�
		return "09_mybatis/memberList";
	}
	//insert������ �̵�
	@RequestMapping(value = "/insert" , method = RequestMethod.GET )
	public String memberInsert() {
		return "09_mybatis/memberInsert";
	}
	
	//��������ϰ� ����Ʈ�� �̵�
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public String memberInsert(MemberDTO dto, RedirectAttributes rdattr) {
		logger.debug(dto.toString());
		int cnt = dao.insert(dto);
		logger.debug(cnt+"�� ����");
		rdattr.addFlashAttribute("msg", "����Ϸ�");
		//redirect : �ּҰ� ����
		return "redirect:/member/list";
	}
	
	
	
}
