package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAOP {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfiguration.class);
		//Creating a  Customer Bean Class
		Customer customer = context.getBean("customer",Customer.class);
		//Triggering Customer Work method
//		customer.customerWork();
		// Customer Set Name -- @Before and JoinPoint
//		customer.setName("Teja Yerraguntla");
		//After Returning and Changing Return Value
//		System.out.println(customer.afterReturningCustomer());
//		After Throwing Exception AND AFTER ASPECT INCLUDES will not handle the Exception It will propagate
//		try {
//		customer.afterThrowingCustomer(true);
//		}
//		catch(Exception e) {
//			System.out.println(">>>>Main Method Throwing Exception<<<"+e);
//		}
		
//		Around Aspect Success And Failure Cases
		System.out.println(customer.aroundCustomer(true));
		
//		To Close the Context 
		context.close();
	}

}
