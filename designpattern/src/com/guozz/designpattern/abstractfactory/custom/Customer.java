package com.guozz.designpattern.abstractfactory.custom;

import com.guozz.designpattern.abstractfactory.itf.IKfcFactory;
import com.guozz.designpattern.abstractfactory.model.Beverage;
import com.guozz.designpattern.abstractfactory.model.ChickenWings;
import com.guozz.designpattern.abstractfactory.model.FrenchFries;
import com.guozz.designpattern.abstractfactory.model.Humburg;

/**
 * 客户类
 * @author Administrator
 *
 */
public class Customer {

	/**
	 * 抽象工厂
	 */
	private IKfcFactory kfcFactory;
	
	public Customer (IKfcFactory kfcFactory){
		this.kfcFactory=kfcFactory;
	}
	
	/**
	 * 订购食物
	 */
	//订购麻辣鸡腿汉堡
	public float orderHumburg(int num){
		//获得麻辣鸡腿汉堡
		Humburg humburg = kfcFactory.createHumburg(num);
		//输出订购信息
		humburg.printMessage();
		//返回总价
		return humburg.totalPrice();
	}
	
	
	//订购奥尔良烤鸡翅
	public float orderChickenWings(int num){
		//获得奥尔良烤鸡翅
		ChickenWings chickenWings = kfcFactory.createChickenWing(num);
		//输出订购信息
		chickenWings.printMessage();
		//返回总价
		return chickenWings.totalPrice();
	}
	
	//订购薯条
	public float orderFrenchFires(int num){
		//获得薯条
		FrenchFries frenchFries = kfcFactory.createFrenchFires(num);
		//输出订购信息
		frenchFries.printMessage();
		//返回总价
		return frenchFries.totalPrice();
	}
	
	//订购可乐
	public float orderBeverage(int num){
		//获得可乐
		Beverage beverage = kfcFactory.createBeverage(num);
		//输出订购信息
		beverage.printMessage();
		//返回总价
		return beverage.totalPrice();
	}
	
	
}
