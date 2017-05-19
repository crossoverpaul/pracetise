package com.guozz.test.spring.interfaces.aop2.impl;

import com.guozz.test.spring.interfaces.aop2.IHelloWorldService2;

public class HelloWorldService2 implements IHelloWorldService2 {

	public void sayBefore(String param) {
		 System.out.println("============say " + param);  
	}

	public boolean sayAfterReturning() {
		System.out.println("============after returning");
		return true;
	}

	public void sayAfterThrowing() {
		System.out.println("============beforeThrowing ");
		throw new RuntimeException();
	}

	public void sayAfterFinally() {
		System.out.println("============before finally");  
        throw new RuntimeException();  
	}

	public void sayAround(String param) {
		 System.out.println("============around param:" + param);  
	}


}
