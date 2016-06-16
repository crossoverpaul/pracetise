package com.guozz.designpattern.prototypepattern.factory;

import com.guozz.designpattern.prototypepattern.pojo.DayLife;

public class LifeFactoryImp implements ILifeFactory {

	private static DayLife dayLife;
	
	/**
	 * 如果是null的话就手动创建一个
	 * 如果不是null的话就使用clone方法赋值一个对象并返回
	 */
	@Override
	public DayLife getNewInstance() {
		if(dayLife == null){
			dayLife= new DayLife();
			dayLife.setGetUp("7:00起床");
			dayLife.setByBus("7:30坐公交车");
			dayLife.setGetFood("8:00到公司去买早餐");
			dayLife.setNoon("在公司附近吃饭，中午小憩");
			dayLife.setAfternoonWork("13:30开始下午的工作");
			dayLife.setGoHome("17:30回家");
			dayLife.setNight("晚上休闲娱乐");			
		}else{
			//如果不为null，用clone方法产生新对象
			System.out.println("clone DayLife");
			dayLife= dayLife.clone();
		}
		return dayLife;
	}

}
