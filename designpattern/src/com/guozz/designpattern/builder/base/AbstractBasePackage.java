package com.guozz.designpattern.builder.base;

import com.guozz.designpattern.builder.model.MobilePackage;

public abstract class AbstractBasePackage {

	//手机套餐实例变量
	protected MobilePackage mobilePackage;
	
	public AbstractBasePackage(){
		this.mobilePackage=new MobilePackage();
	}
	
}
