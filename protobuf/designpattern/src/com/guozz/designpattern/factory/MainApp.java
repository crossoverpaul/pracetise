package com.guozz.designpattern.factory;

import com.guozz.designpattern.factory.itf.ISwordFactory;
import com.guozz.designpattern.factory.model.AbstractSword;

public class MainApp {

	public static void main(String[] args) {
		//创造曹操实例对象，返回类型使用接口类型
		//ISwordFactory swordFactory =new CaoCao();
		ISwordFactory swordFactory =new CaoCao2();
		//获得宝刀示例，七星宝刀
		AbstractSword sword= swordFactory.createSword();
		//刺杀董卓
		System.out.println("曹操使用"+sword.getName()+"刺杀董卓");
	}
}
