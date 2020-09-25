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
		// WEB-INF/view/home.jsp�� ����
		return "home";
	}
	
	//01_voidTest.jsp ȣ��
	@RequestMapping(value = "/01_voidTest")
	public void voidMapping() {
		logger.info("void�޼ҵ� ȣ��");
	}
	
	//02_stringTest.jsp ȣ��
	//value �� �ϳ��� ������ value ���� ����
	@RequestMapping("stringTest")
	public String stringMapping() {
		logger.info("string �޼ҵ� ȣ��");
		//return : ���� �� ��(jsp forwardó��)
		// WEB-INF/views/02_stringTest.jsp
		// servlet-context.xml�� prefix,suffix �� ���ǵǾ� �־� ���� ����
		return "02_stringTest";
	}
	
	//03_paramTest.jsp ȣ��
	@RequestMapping("paramTest")
	//defaultValue : ���� ���� �� ����Ʈ�� ����
	public String paramTest(@RequestParam String name, 
			@RequestParam(defaultValue = "20") int age, Model model) {
		
		logger.info("name : "+name);
		logger.info("age : "+age);
		model.addAttribute("nicName",name);
		model.addAttribute("age",age);
		
		return "03_paramTest";
	}
	
	//�ǽ�)login�׽�Ʈ
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
	//�Ķ���͸� view���� ����
	@RequestMapping("04_modelTest")
	public void modelTest(@ModelAttribute("userid") String userid,
			@ModelAttribute("passwd") String passwd) {
		logger.info("userid : "+userid);
		logger.info("passwd : "+passwd);
	}
	
	//05_dtoTest.jsp �������� ���� ���� �޼ҵ�
	@RequestMapping("05_dtoTest")
	public void dtoTest() {
		
	}
	
	//05_dtoTest.jsp - DTO �������� ����
	@RequestMapping("dtoTest")
	public String dtoTest(@ModelAttribute("dto") MemberDTO dto) {
			logger.info(dto.toString());
			return "05_dtoTest";
	}
	
	//05_dtoTest.jsp - MAP �������� ����
	@RequestMapping("dtoTest_map")
	public String dtoTest(@RequestParam HashMap<String,String> map, Model model) {
			logger.info(map.toString());
			model.addAttribute("map",map);
			return "05_dtoTest";
	}
	
	//�����̷�Ʈ �׽�Ʈ
	@RequestMapping("redirectTest")
	public String redirectTest() {
		logger.info("�����̷�Ʈ �׽�Ʈ");
		
		return "redirect:06_redirect";
	}
	
	//06_redirect.jsp �������� ���� ���� �޼ҵ�
	@RequestMapping("06_redirect")
	public void redirect() {
		
	}
	
	//�ǽ�
	//�α��� ���� �� ���� ������ �̵�(redirect)
	//�α��� ���� �� �α��� ������ �̵�(forward)
	
	// WEB-INF/views/06_Test/login.jsp
	@RequestMapping("06_Test/login")
	public void redirectLogin() {}
	
	@RequestMapping("loginCheck")
	public String loginCheck(String userid,String passwd,
				RedirectAttributes redirectAttributes, HttpSession httpSession) {
		String myid = "java";
		String mypw = "1111";
		
		//post������� ���� �����Ͱ� �ѱ��� ��
		//web.xml���� �ѱ��� ó���� ��� ������ �ʰ� ����� ��
		logger.info("userid/passwd : "+userid+"/"+passwd);
		
		if(myid.equals(userid) && mypw.equals(passwd)) {
			//���ǿ� userid ����
			httpSession.setAttribute("userid", userid);
			httpSession.setAttribute("passwd", passwd);
			httpSession.setMaxInactiveInterval(60*10); //�ʴ���(10��)
			
			//�����̷�Ʈ �Ӽ������� �� ����
			//addFlashAttribute : url���� �ѹ� ��� �� ��������
			redirectAttributes.addFlashAttribute("userid",userid);
			redirectAttributes.addFlashAttribute("passwd",passwd);
			redirectAttributes.addFlashAttribute("msg","�α��οϷ�");
			

			return "redirect:06_main";
		} else {
			return "06_Test/login";
		}
	}
	
	//@ModelAttribute : view���� ������ ����
	@RequestMapping("06_main")
	public String mainview(@ModelAttribute("userid") String userid,
			@ModelAttribute("passwd") String passwd,
			@ModelAttribute("msg") String msg) {

		return "06_Test/main";
	}
	
	//json : {"userid":"ȫ�浿","passwd":"1111", "email":"hong@gmail.com"}
	//���̺귯��(Jackson Databind) : json �����ͷ� ��ȯ ���̺귯�� �߰�
	@RequestMapping(value = "jsonTest", method = RequestMethod.GET)
	public String jsonTestCall() {
		return "07_jsonTest";
		}
	
	@RequestMapping(value = "jsonTest", method = RequestMethod.POST)
	public @ResponseBody MemberDTO jsonTest(MemberDTO dto) {
		dto.setUserid("ȫ�浿");
		dto.setPasswd("1111");
		dto.setEmail("hong@gmail.com");
		logger.info(dto.toString());
		return dto;
	}
	
	//�޼ҵ� �׽�Ʈ ȭ������ �̵�
	@RequestMapping("08_methodTest")
	public void methodTestCall() {}
	
	@RequestMapping(value = "methodTest", method = RequestMethod.GET)
	public String methodTestGet(String name, int age) {
		logger.info("GET��� name/age : "+name+"/"+age);
		
		return "08_methodTest";
	}
	
	@RequestMapping(value = "methodTest", method = RequestMethod.POST)
	public String methodTestPost(String name, int age) {
		logger.info("POST��� name/age : "+name+"/"+age);
		
		return "08_methodTest";
	}
	
	//join������ �̵� : GET���
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinTest() {
		
		return "08_Test/join";
	}
	
	//join ������ ���
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinTest(MemberDTO dto,Model model) {
		logger.info(dto.toString());
		model.addAttribute("userid",dto.getUserid());
		model.addAttribute("passwd",dto.getPasswd());
		model.addAttribute("email",dto.getEmail());
		model.addAttribute("msg","ȸ������ �Ϸ�");
		
		return "08_Test/main";
	}
	
}
