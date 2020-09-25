package org.spring.aop;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAdvice {
	private static final Logger logger = LoggerFactory.getLogger(ServiceAdvice.class);
	
	//�ֽ���Ʈ : ����Ʈ��(��޼ҵ�) + �����̽�(������)
	//��������Ʈ : ������ �Ǵ� ��ü���� ���
//	@Before("execution(* org.spring.service.FileService*.*(..))")
//	public void startLog(JoinPoint jp) {
//		logger.info("------�Ű�����------");
//		logger.info(jp.getSignature().getName() + ":" + Arrays.deepToString(jp.getArgs()));
//	}
	
	//�޼ҵ� ��ȯ�� ���
	//pointcut : ������ ���
	//������ ���������
//	@AfterReturning(pointcut="execution(* org.spring.service.FileService*.*(..))", returning = "rObj")
//	public void afterLog(JoinPoint jp, Object rObj) {
//		logger.info("------���ϰ�------");
//		logger.info(jp.getSignature().getName()+":" + rObj.toString());
//	}
	
	//���ܰ� �߻�
//	@AfterThrowing(pointcut="execution(* org.spring.service.FileService*.*(..))",throwing = "eObj")
//	public void exceptionLog(JoinPoint jp, Exception eObj) {
//		logger.info("------���ܹ߻�------");
//		if (eObj instanceof NullPointerException) {
//			logger.info(jp.getSignature().getName() + ":" + "��ȯ�Ǵ� ��ü�� �����ϴ�.");
//			logger.info("����:" + eObj.toString());
//		}
//	}
	
	//����� �ҿ�ð� üũ
	@Around("execution(* org.spring.service.FileService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("------�ҿ�ð�------");
		//���۽ð�
		long startTime = System.currentTimeMillis();
		
		//��������Ʈ ����Ʈ��(���������� �޼ҵ�)�� ����
		//result : ����޼ҵ��� ��ȯ��
		Object result = pjp.proceed();
		
		//���ð�
		long endTime = System.currentTimeMillis();
		
		//�ҿ�ð�
		logger.info(pjp.getSignature().getName() + ":" + (endTime-startTime));
		
		logger.info(result.toString());
		return result;
		
	}
	
	
	
	
	
	
	
	
}
