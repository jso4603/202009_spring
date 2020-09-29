package org.spring.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.spring.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chat")
public class ChatController {
	
	@Resource
	private ChatService service;
	
	
	//챗창메인 띄우기
	@RequestMapping("/main")
	public String chatMain() {
		return "17_chat/02_main";
	}
	
	
	//챗창 띄우기
	@RequestMapping("/")
	public String chat() {
		return "17_chat/01_chatTest";
	}
	
	//챗봇에 메시지 전달하고 응답받기
	@RequestMapping(value="/sendMsg", method = RequestMethod.POST, produces="application/text; charset=utf-8")
	public ResponseEntity<String> chatTest(@RequestBody String msg) throws IOException {
		String receiveMsg = service.receiveMsg(msg);
		
		return new ResponseEntity<>(receiveMsg, HttpStatus.OK);
		
	}
}
