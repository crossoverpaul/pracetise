package com.guozz.designpattern.template;

public abstract class Father {
	
	public void stepA(){
		System.out.println("StepA 都一样");
	}
	
	public abstract void stepB();

	public void stepC(){
		System.out.println("StepC 都一样");
	}
	
	public  void enTrance(){
		this.stepA();
		this.stepB();
		this.stepC();
	}
}
