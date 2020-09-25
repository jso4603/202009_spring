package org.spring.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.spring.dao.MemberDAO;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@Resource
	private MemberDAO dao;
	
	//ajax�׽�Ʈ �� ȣ��
	@RequestMapping("/text")
	public String textResult() throws Exception{
		return "13_ajax/01_text";
	}
	
	//ajax�׽�Ʈ
	//produces : ���ϰ��� �ѱ�ó��
	//@ResponseBody : ��ȯ���� ������ ��ü�� �ν�(json/text)
	@ResponseBody
	@RequestMapping(value="/textResult",produces = "application/text; charset=utf-8")
	public String textResult(String userid, int age) throws Exception{
		System.out.println(userid);
		System.out.println(age);
		return "�̸� : "+userid + "<br> ���� : "+age;
	}
	
	//json���� �� �ް� text ����
	@ResponseBody
	@RequestMapping(value="/jsonSend",produces = "application/text; charset=utf-8")
	public String jsonSend(@RequestBody HashMap<String, Object> map) {
		System.out.println(map);
		return "����";
	}
	
	//json���� �� ���� �� ȣ��
	@RequestMapping("/json")
	public String json() throws Exception{
		return "13_ajax/02_json";
	}
	
	//json���� ���� (List<MemberDTO>) ��ü
	@ResponseBody
	@RequestMapping("/jsonResult")
	public List<MemberDTO> jsonResult() throws Exception {
		System.out.println("�������Ʈ ��ȯ");
		List<MemberDTO> list = dao.selectList();
		System.out.println("list : "+list);
		/* jackson-databind���̺귯�� �ʿ� */
		return list;
	}
	
	//rest���� : {userid}�� ����
	//restfull�� ������� ����
	@ResponseBody
	@RequestMapping("/jsonResultOne/{userid}")
	public List<MemberDTO> jsonResultOne(@PathVariable("userid") String userid) throws Exception {
		System.out.println(userid);
		return null;
	}
	/* restfull�� ���� ���
	 * insert : /board/{bnum} : method : post 
	 * update : /board/{bnum} : method : put/ patch 
	 * delete : /board/{bnum} : method : delete 
	 * selectOne : /board/{bnum} : method : get
	 */
}
