package com.guozz.designpattern.singalton;

public class Client {

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		if(singleton1==singleton2){
			System.out.println("是一个对象");
		}else{
			System.out.println("不是一个对象");
		}
		
	}
}
