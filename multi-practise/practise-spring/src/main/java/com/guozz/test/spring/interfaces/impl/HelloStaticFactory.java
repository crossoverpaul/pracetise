package com.guozz.test.spring.interfaces.impl;

import com.guozz.test.spring.interfaces.Hello;

public class HelloStaticFactory {
	
	public static Hello newInstance(String message){
		return new HelloImpl2(message);		
	}
	
}
