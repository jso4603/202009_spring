package org.spring.sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

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
		// /WEB-INF/views/home.jsp
		return "home";
	}
	
	//01_voidTest.jsp ȣ��
	@RequestMapping(value = "01_voidTest")
	public void voidMapping() {
		logger.info("void�޼ҵ� ȣ��");
	}
	
	//02_stringTest.jsp ȣ��
	@RequestMapping("stringTest")
	public String stringMapping() {
		logger.info("string �޼ҵ� ȣ��");
		//servlet-context.xml�� prefix, suffix ����
		/* /WEB-INF/views/02_stringTest.jsp */
		return "02_stringTest";
	}
	
	//03_paramTest.jsp ȣ��
	@RequestMapping("paramTest")
	public String paramTest(@RequestParam("nicName") String name, 
				@RequestParam(defaultValue = "20") int age , Model model) {
		logger.info("name:" + name);
		logger.info("age:" + age);
		model.addAttribute("nicName", name);
		model.addAttribute("age", age);
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
		model.addAttribute("userid", userid);
		model.addAttribute("passwd", passwd);
		return "03_Test/main";
	}
	
	//04_ModelTest.jsp
	//�Ķ���͸� view���� ����
	@RequestMapping("04_ModelTest")
	public void modelTest(@ModelAttribute("userid") String userid, 
			@ModelAttribute("passwd") String passwd) {
		logger.info("userid:" + userid);
		logger.info("passwd:" + passwd);
	}
	
	//05_DtoTest.jspȣ��
	/* /WEB-INF/views/05_DtoTest.jsp */
	@RequestMapping("05_DtoTest")
	public void dtoTest() {}
	
	//dto���޹޾Ƽ� 05_DtoTest.jspȣ��
	@RequestMapping("dtoTest")
	public String dtoTest(@ModelAttribute("dto") MemberDTO dto) {
		logger.info(dto.toString() );
		return "05_DtoTest";
	}
	//������ ���� �ޱ�
	@RequestMapping("dtoTest_map")
	public String dtoTest(@RequestParam HashMap<String,String> map, Model model) {
		logger.info(map.toString() );
		model.addAttribute("map", map);
		return "05_DtoTest";
	}
	
	//�����̷�Ʈ �׽�Ʈ
	@RequestMapping("redirectTest")
	public String redirectTest() {
		logger.info("�����̷�Ʈ �׽�Ʈ");
		return "redirect:06_redirect";
	}
	@RequestMapping("06_redirect")
	public void redirect() {}
	
	//�ǽ�
	//�α��� �����ϸ� ���� ������ ���� (redirect)
	//�ƴϸ� �α��� ������ �̵� (forward)
	
	/* /WEB-INF/views/06_test/login.jsp */
	@RequestMapping("06_Test/login")
	public void redirctLogin() {}
	
	//@ModelAttribute : view���� ������ ����
	@RequestMapping("06_Test/main")
	public void redirctMain(@ModelAttribute("userid") String userid,
			@ModelAttribute("passwd") String passwd, 
			@ModelAttribute("msg") String msg ) {
	}
	
	@RequestMapping("loginCheck")
	public String loginCheck(String userid,String passwd, 
				RedirectAttributes rdAttr , HttpSession session) {
		String myid = "java";
		String mypw = "1111";
		logger.info(userid + " " + passwd);
		if (userid.equals(myid) && passwd.equals(mypw) ) {
			//���ǿ� userid ����
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(60*10); //10��
			
			//�����̷�Ʈ �Ӽ������� �� ����
			rdAttr.addAttribute("userid", userid);
			rdAttr.addAttribute("passwd", passwd);
			//url���� �ѹ������ ��������
			rdAttr.addFlashAttribute("msg","�α��� �Ϸ�");
			return "redirect:06_Test/main";
		}else {
			return "redirect:06_Test/login";
		}
	}
	
	
	//json : {"userid":"java", "passwd":"1111", "email":"hong@gmail.com"}
	//���̺귯�� : jackson-databind : json�����ͷ� ��ȯ ���̺귯�� �߰�
	@RequestMapping(value="jsonTest", method = RequestMethod.GET)
	public String jsonTestCall() {
		return "07_jsonTest";
	}
	@RequestMapping(value ="jsonTest",method = RequestMethod.POST)
	public @ResponseBody MemberDTO jsonTest(MemberDTO dto) {
		dto.setUserid("java");
		dto.setPasswd("1111");
		dto.setEmail("hong@gmail.com");
		logger.info(dto.toString());
		return dto;
	}
	
	//�޼ҵ� �׽�Ʈ
	@RequestMapping("08_methodTest")
	public void methodCall() {}
	
	@RequestMapping(value="methodTest", method = RequestMethod.GET)
	public String methodTestGet(String name, int age) {
		logger.info("Get���");
		logger.info(name + " " + age);
		return "08_methodTest";
	}

	@RequestMapping(value="methodTest", method = RequestMethod.POST)
	public String methodTestPost(String name, int age) {
		logger.info("POST���");
		logger.info(name + " " + age);
		return "08_methodTest";
	}
	
	//join������ �̵� :GET���
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinTest() {
		return "08_Test/join";
	}
	//join ������ ���
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinTest(MemberDTO dto) {
		logger.info(dto.toString());
		return "08_Test/join";
	}
	
	
	
}
