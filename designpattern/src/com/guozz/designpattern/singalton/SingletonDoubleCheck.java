package com.guozz.designpattern.singalton;

public class SingletonDoubleCheck {

	private static volatile SingletonDoubleCheck singleton=null;
	
	private SingletonDoubleCheck(){
		System.out.println("--------ππ‘ÏSingleton--------");
	}
	
	public  static SingletonDoubleCheck getInstance(){
		if(singleton==null){
			synchronized (SingletonDoubleCheck.class) {
				if(singleton==null){
					singleton= new SingletonDoubleCheck();
				}
			}
		}
		return singleton;
	}
}
