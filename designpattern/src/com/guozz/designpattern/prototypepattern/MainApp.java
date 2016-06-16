package com.guozz.designpattern.prototypepattern;

import com.guozz.designpattern.prototypepattern.factory.ILifeFactory;
import com.guozz.designpattern.prototypepattern.factory.LifeFactoryImp;
import com.guozz.designpattern.prototypepattern.pojo.DayLife;

public class MainApp {

	public static void main(String[] args) {
		ILifeFactory lifeFactory = new LifeFactoryImp();
		//打印出默认数据
		lifeFactory.getNewInstance().print();
		
		//再次获得DayLife,修改getUp后输出内容
		System.out.println("--------------------");
		DayLife dayLife = lifeFactory.getNewInstance();
		dayLife.setGetUp("早上懒床了8点才起");
		dayLife.print();
		
		//再次获得DayLife,修改getUp后输出内容
		System.out.println("--------------------");
		DayLife dayLife2 = lifeFactory.getNewInstance();
		dayLife2.setGetUp("早上懒床了9点才起");
		dayLife2.print();
	}
}
