package com.aop.logging;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("customerAopLogging")
@Order(1)
public class CustomerAopLogging {
	
	@Pointcut("execution(* com.aop.Customer.customerWork())")
	public void customerWorkPointCut() {};
	
	@Pointcut("execution(* com.aop.Customer.get*(..))")
	public void getterCustomer(){};
	
	@Pointcut("execution(* com.aop.Customer.set*(..))")
	public void setterCustomer() {};
	
	@Pointcut("execution(* com.aop.Customer.afterReturningCustomer())")
	public void afterReturnCustomer() {};
	
	@Pointcut("execution(* com.aop.Customer.afterThrowingCustomer(..))")
	public void afterThrowingCustomer() {};
	
	@Pointcut("execution(* com.aop.Customer.aroundCustomer(..))")
	public void aroundCustomer() {};

	@Before("customerWorkPointCut()")
	public void getCustomerWork(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().toShortString());
		System.out.println(">>>>>>Customer AOP Logging getCustomerWork<<<<<<");
	}
	
	@Before("setterCustomer()")
	public void setCustomerName(JoinPoint joinPoint) {
		Object[] object = joinPoint.getArgs();
		for(Object i:object) {
			System.out.println(i);
		}
		System.out.println(">>>>>>>>Customer AOP Set Customer Name<<<<<<<<");
	}
	
	@AfterReturning(pointcut="afterReturnCustomer()",returning="result")
	public void afterReturningCustomer(ArrayList<String> result) {
		System.out.println(">>>Customer AOP After Returning..."+result);
		for(int i=0;i<result.size();i++) {
			result.set(i, result.get(i).toUpperCase());
		}
	}
	
	
	@AfterThrowing(pointcut="afterThrowingCustomer()",throwing="error")
	public void afterThrowingExample(JoinPoint joinPoint,Throwable error) {
		System.out.println(">>>Customer AOP after Throwing Error>>"+error);
	}	
	
	@After("afterThrowingCustomer()")
	public void afterAspect(JoinPoint joinPoint) {
		System.out.println(">>>>>>Customer AOP after Aspect Execution<<<<<<<");
	}
	
	@Around("aroundCustomer()")
	public Object aroundAspectCustomer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object obj;
		try {
			obj = proceedingJoinPoint.proceed();
		}
		catch(Exception e) {
			obj = e;
		}
		return obj;
	}
}
