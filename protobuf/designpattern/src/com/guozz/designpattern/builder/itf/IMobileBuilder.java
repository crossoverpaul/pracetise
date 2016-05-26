package com.guozz.designpattern.builder.itf;

import com.guozz.designpattern.builder.model.MobilePackage;

/**
 * 手机套餐builder
 * @author Administrator
 *
 */
public interface IMobileBuilder {

	//建立手机套餐的话费
	public 	void buildMoney();
	
	//建立手机套餐的短信
	public void buildShortInfo();
	
	//建立手机套餐的彩铃
	public void buildMusic();
	
	//返回构造的手机套餐对象
	public MobilePackage getMobilePackage();
}
