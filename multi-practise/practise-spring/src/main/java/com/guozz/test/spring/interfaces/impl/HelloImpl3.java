package com.guozz.test.spring.interfaces.impl;

import com.guozz.test.spring.interfaces.Hello;

public class HelloImpl3 implements Hello {

	private String message;
	
	private int index;

	public HelloImpl3(String message,int index){
		this.index=index;
		this.message=message;
	}

	public void sayHello() {
		System.out.println(" index = " + index +" and message = " +message);
	}
}
