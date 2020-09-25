package org.spring.aop;

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
	
	//애스팩트 : 포인트컷(어떤메소드) + 어드바이스(무엇을)
	//조인포인트 : 실행이 되는 구체적인 대상
	@Before("execution(* org.spring.service.FileService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("================매개변수=========================================");
		logger.info(jp.getSignature().getName() + " : " + Arrays.toString(jp.getArgs()));
		logger.info("==================================================================");
	}
	
	// 메소드의 반환값을 출력
	// pointcut : 적용할 대상
	// 적용대상이 정상적으로 수행이 된 다음
	@AfterReturning(pointcut = "execution(* org.spring.service.FileService*.*(..))",
			returning = "rObj")
	public void afterLog(JoinPoint jp, Object rObj) {
		logger.info("===================리턴값=========================================");
		logger.info(jp.getSignature().getName()+" 리턴값 : "+rObj.toString());
		logger.info("==================================================================");
	}
	
	// 예외가 발생 시(예외 발생 시 저장 될 오브젝트 : eObj)
	@AfterThrowing(pointcut = "execution(* org.spring.service.FileService*.*(..))",
			throwing = "eObj")
	public void exceptionLog(JoinPoint jp, Exception eObj) {
		logger.info("===================예외발생=========================================");
		if(eObj instanceof NullPointerException) {			
			logger.info(jp.getSignature().getName() + " : 반환되는 객체가 없습니다.");
			logger.info("예외 : "+eObj.toString());
		}
		logger.info("====================================================================");
	}
	
	//모듈의 소요시간 체크
	@Around("execution(* org.spring.service.FileService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("===================소요시간=========================================");
		
		// 시작시간
		long startTime = System.currentTimeMillis();
			
		// 조인포인트 메소드를 실행
		// result : 실행메소드의 반환값
		Object result = pjp.proceed();
		
		// 끝시간
		long endTime = System.currentTimeMillis();
		
		// 소요시간
		logger.info(pjp.getSignature().getName()+" : "+(endTime-startTime));
		logger.info(result.toString());
		
		logger.info("====================================================================");
		
		return result;
	}
	
}
