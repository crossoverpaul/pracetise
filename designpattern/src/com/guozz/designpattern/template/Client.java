package com.guozz.designpattern.template;

public class Client {

	public static void main(String[] args) {
		Father father1 = new ChildA();
		father1.enTrance();
		
		Father father2 = new ChildB();
		father2.enTrance();
	}
}
