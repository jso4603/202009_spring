package com.myboard.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ���������� ó���ϴ� Ŭ����
@ControllerAdvice
public class CommonExceptionAdvice {
	@ExceptionHandler
	public String common(Exception e,Model model) {
		System.out.println("���ܹ߻�");
		System.out.println(e.toString());
		e.printStackTrace();
		model.addAttribute("exception",e);
		return "error_common";
	}
}
