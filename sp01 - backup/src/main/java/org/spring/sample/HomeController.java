package org.spring.sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		// WEB-INF/view/home.jsp로 가라
		return "home";
	}
	
	//01_voidTest.jsp 호출
	@RequestMapping(value = "/01_voidTest")
	public void voidMapping() {
		logger.info("void메소드 호출");
	}
	
	//02_stringTest.jsp 호출
	//value 값 하나만 넣으면 value 생략 가능
	@RequestMapping("stringTest")
	public String stringMapping() {
		logger.info("string 메소드 호출");
		//return : 가야 될 곳(jsp forward처럼)
		// WEB-INF/views/02_stringTest.jsp
		// servlet-context.xml에 prefix,suffix 가 정의되어 있어 생략 가능
		return "02_stringTest";
	}
	
	//03_paramTest.jsp 호출
	@RequestMapping("paramTest")
	//defaultValue : 값이 없을 때 디폴트값 지정
	public String paramTest(@RequestParam String name, 
			@RequestParam(defaultValue = "20") int age, Model model) {
		
		logger.info("name : "+name);
		logger.info("age : "+age);
		model.addAttribute("nicName",name);
		model.addAttribute("age",age);
		
		return "03_paramTest";
	}
	
	//실습)login테스트
	@RequestMapping("login")
	public String loginTest() {
		
		return "03_Test/login";
	}
	
	@RequestMapping("main")
	public String main(@RequestParam String userid,
			@RequestParam String passwd, Model model) {
		logger.info("userid : "+userid);
		logger.info("passwd : "+passwd);
		
		model.addAttribute("userid",userid);
		model.addAttribute("passwd",passwd);
		
		return "03_Test/main";
	}
	
	//04_modelTest.jsp
	//파라미터를 view까지 전달
	@RequestMapping("04_modelTest")
	public void modelTest(@ModelAttribute("userid") String userid,
			@ModelAttribute("passwd") String passwd) {
		logger.info("userid : "+userid);
		logger.info("passwd : "+passwd);
	}
	
	//05_dtoTest.jsp 페이지를 띄우기 위한 메소드
	@RequestMapping("05_dtoTest")
	public void dtoTest() {
		
	}
	
	//05_dtoTest.jsp - DTO 형식으로 보냄
	@RequestMapping("dtoTest")
	public String dtoTest(@ModelAttribute("dto") MemberDTO dto) {
			logger.info(dto.toString());
			return "05_dtoTest";
	}
	
	//05_dtoTest.jsp - MAP 형식으로 보냄
	@RequestMapping("dtoTest_map")
	public String dtoTest(@RequestParam HashMap<String,String> map, Model model) {
			logger.info(map.toString());
			model.addAttribute("map",map);
			return "05_dtoTest";
	}
	
	//리다이렉트 테스트
	@RequestMapping("redirectTest")
	public String redirectTest() {
		logger.info("리다이렉트 테스트");
		
		return "redirect:06_redirect";
	}
	
	//06_redirect.jsp 페이지를 띄우기 위한 메소드
	@RequestMapping("06_redirect")
	public void redirect() {
		
	}
	
	//실습
	//로그인 성공 시 메인 폼으로 이동(redirect)
	//로그인 실패 시 로그인 폼으로 이동(forward)
	
	// WEB-INF/views/06_Test/login.jsp
	@RequestMapping("06_Test/login")
	public void redirectLogin() {}
	
	@RequestMapping("loginCheck")
	public String loginCheck(String userid,String passwd,
				RedirectAttributes redirectAttributes, HttpSession httpSession) {
		String myid = "java";
		String mypw = "1111";
		
		//post방식으로 보낸 데이터가 한글일 때
		//web.xml에서 한글을 처리해 줘야 깨지지 않고 출력이 됨
		logger.info("userid/passwd : "+userid+"/"+passwd);
		
		if(myid.equals(userid) && mypw.equals(passwd)) {
			//세션에 userid 저장
			httpSession.setAttribute("userid", userid);
			httpSession.setAttribute("passwd", passwd);
			httpSession.setMaxInactiveInterval(60*10); //초단위(10분)
			
			//리다이렉트 속성값으로 값 전달
			//addFlashAttribute : url에서 한번 사용 후 정보삭제
			redirectAttributes.addFlashAttribute("userid",userid);
			redirectAttributes.addFlashAttribute("passwd",passwd);
			redirectAttributes.addFlashAttribute("msg","로그인완료");
			

			return "redirect:06_main";
		} else {
			return "06_Test/login";
		}
	}
	
	//@ModelAttribute : view까지 데이터 전달
	@RequestMapping("06_main")
	public String mainview(@ModelAttribute("userid") String userid,
			@ModelAttribute("passwd") String passwd,
			@ModelAttribute("msg") String msg) {

		return "06_Test/main";
	}
	
	//json : {"userid":"홍길동","passwd":"1111", "email":"hong@gmail.com"}
	//라이브러리(Jackson Databind) : json 데이터로 변환 라이브러리 추가
	@RequestMapping(value = "jsonTest", method = RequestMethod.GET)
	public String jsonTestCall() {
		return "07_jsonTest";
		}
	
	@RequestMapping(value = "jsonTest", method = RequestMethod.POST)
	public @ResponseBody MemberDTO jsonTest(MemberDTO dto) {
		dto.setUserid("홍길동");
		dto.setPasswd("1111");
		dto.setEmail("hong@gmail.com");
		logger.info(dto.toString());
		return dto;
	}
	
	//메소드 테스트 화면으로 이동
	@RequestMapping("08_methodTest")
	public void methodTestCall() {}
	
	@RequestMapping(value = "methodTest", method = RequestMethod.GET)
	public String methodTestGet(String name, int age) {
		logger.info("GET방식 name/age : "+name+"/"+age);
		
		return "08_methodTest";
	}
	
	@RequestMapping(value = "methodTest", method = RequestMethod.POST)
	public String methodTestPost(String name, int age) {
		logger.info("POST방식 name/age : "+name+"/"+age);
		
		return "08_methodTest";
	}
	
	//join폼으로 이동 : GET방식
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinTest() {
		
		return "08_Test/join";
	}
	
	//join 데이터 출력
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinTest(MemberDTO dto,Model model) {
		logger.info(dto.toString());
		model.addAttribute("userid",dto.getUserid());
		model.addAttribute("passwd",dto.getPasswd());
		model.addAttribute("email",dto.getEmail());
		model.addAttribute("msg","회원가입 완료");
		
		return "08_Test/main";
	}
	
}
