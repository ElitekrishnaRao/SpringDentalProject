package com.dentalapp.aspects.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.dentalapp.controller.LoginController.*(..))")
	 public void startOfMethod(JoinPoint joinPoint){
		 System.out.println("Start of method "+ joinPoint.getSignature().getName());
		   
		 Object[] signatureArgs = joinPoint.getArgs();
		   for (Object signatureArg: signatureArgs) {
		      System.out.println("Arg: " + signatureArg);
		   }
	 }
	 
	@After("execution(* com.dentalapp.controller.LoginController.*(..))")
	 public void endOfMethod(JoinPoint joinPoint){
		 System.out.println("End of method "+ joinPoint.getSignature().getName());
	 }
}
