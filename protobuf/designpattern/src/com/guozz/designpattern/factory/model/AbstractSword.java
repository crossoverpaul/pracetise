package com.guozz.designpattern.factory.model;
/**
 * 
 * @author Administrator
 * 定义抽象宝刀
 */
public abstract class AbstractSword {

	//宝刀名称
	private String name;
	
	//抽象父类的构造方法
	public AbstractSword(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
