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
	
	//ajax테스트 폼 호출
	@RequestMapping("/text")
	public String textResult() throws Exception{
		return "13_ajax/01_text";
	}
	
	//ajax테스트
	//produces : 리턴값의 한글처리
	//@ResponseBody : 반환값을 데이터 자체로 인식(json/text)
	@ResponseBody
	@RequestMapping(value="/textResult",produces = "application/text; charset=utf-8")
	public String textResult(String userid, int age) throws Exception{
		System.out.println(userid);
		System.out.println(age);
		return "이름 : "+userid + "<br> 나이 : "+age;
	}
	
	//json으로 값 받고 text 리턴
	@ResponseBody
	@RequestMapping(value="/jsonSend",produces = "application/text; charset=utf-8")
	public String jsonSend(@RequestBody HashMap<String, Object> map) {
		System.out.println(map);
		return "성공";
	}
	
	//json으로 값 리턴 폼 호출
	@RequestMapping("/json")
	public String json() throws Exception{
		return "13_ajax/02_json";
	}
	
	//json으로 리턴 (List<MemberDTO>) 전체
	@ResponseBody
	@RequestMapping("/jsonResult")
	public List<MemberDTO> jsonResult() throws Exception {
		System.out.println("멤버리스트 반환");
		List<MemberDTO> list = dao.selectList();
		System.out.println("list : "+list);
		/* jackson-databind라이브러리 필요 */
		return list;
	}
	
	//rest적용 : {userid}는 변수
	//restfull한 방식으로 적용
	@ResponseBody
	@RequestMapping("/jsonResultOne/{userid}")
	public List<MemberDTO> jsonResultOne(@PathVariable("userid") String userid) throws Exception {
		System.out.println(userid);
		return null;
	}
	/* restfull한 설계 방식
	 * insert : /board/{bnum} : method : post 
	 * update : /board/{bnum} : method : put/ patch 
	 * delete : /board/{bnum} : method : delete 
	 * selectOne : /board/{bnum} : method : get
	 */
}
