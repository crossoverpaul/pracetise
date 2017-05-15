package com.guozz.test.spring.interfaces.impl;

import com.guozz.test.spring.interfaces.Hello;

public class HelloImpl4 implements Hello {

	private String message;
	
	private int index;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void sayHello() {
		System.out.println(" index = " + index +" and message = " +message);
	}
}
