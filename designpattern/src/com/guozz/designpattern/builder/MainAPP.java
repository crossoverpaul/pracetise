package com.guozz.designpattern.builder;

import com.guozz.designpattern.builder.director.MobileDirector;
import com.guozz.designpattern.builder.itf.IMobileBuilder;
import com.guozz.designpattern.builder.itf.MobileBuilderImp1;
import com.guozz.designpattern.builder.itf.MobileBuilderImp2;
import com.guozz.designpattern.builder.model.MobilePackage;

public class MainAPP {

	public static void main(String[] args) {
		//创建指导者
		MobileDirector mobileDirector = new MobileDirector();
		
		//套餐1
		IMobileBuilder iMobileBuilder1 = new MobileBuilderImp1();
		
		//套餐2
		IMobileBuilder iMobileBuilder2 = new MobileBuilderImp2();
		
		printMassege(mobileDirector.createMobilePackage(iMobileBuilder1));	
		
		printMassege(mobileDirector.createMobilePackage(iMobileBuilder2));	
		
	}

	/**
	 * 打印输出套餐信息
	 * @param createMobilePackage
	 */
	private static void printMassege(MobilePackage 	mobilePackage) {
		System.out.println("---话费"+mobilePackage.getMoney() +"\t---短信"+mobilePackage.getShortInfo()+"\t---彩铃:"+mobilePackage.getMusic());		
	}
}
