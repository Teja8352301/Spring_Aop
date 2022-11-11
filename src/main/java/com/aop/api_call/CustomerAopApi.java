package com.aop.api_call;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("customerAopApi")
@Order(2)
public class CustomerAopApi {
	
//	@Before("execution(* com.aop.Customer.getCustomerWork())")
//	public void getCustomerWork() {
//		System.out.println(">>>>>>Customer AOP Api getCustomerWork<<<<<<");
//	}

}
