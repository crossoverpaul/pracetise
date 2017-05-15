package com.guozz.test.spring.interfaces.impl;

import com.guozz.test.spring.interfaces.Hello;

public class HelloImpl2 implements Hello {

	private String message;
	
	public HelloImpl2(){
		
	}
	public HelloImpl2(String message){
		this.message=message;
	}

	public void sayHello() {
		System.out.println(message);
	}
}
