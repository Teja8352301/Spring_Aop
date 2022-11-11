package com.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	String name;
	
	String age;
	
	public Customer() {
		System.out.println(">>>>Executing the Customer No Arg Constructor....");
	}
	
	public void customerWork() {
		System.out.println(">>>>>Customer is Working on Assignments<<<<<<");
	}
	
	public ArrayList<String> afterReturningCustomer() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Teja");
		list.add("Yerraguntla");
		return list;
	
	}
	
	public Object afterThrowingCustomer(boolean enableError) {
		if(enableError == true) {
			throw new RuntimeException("just randomly throwing Exception");
		}
		return null;
	}
	
	public Object aroundCustomer(boolean enableError) {
		if(enableError == true) {
			throw new RuntimeException("just randomly throwing Exception");
		}
		return "Hello To my Beautiful World";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
