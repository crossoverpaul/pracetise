package com.guozz.designpattern.abstractfactory;

import com.guozz.designpattern.abstractfactory.custom.Customer;
import com.guozz.designpattern.abstractfactory.itf.ChinaKFCFactory;
import com.guozz.designpattern.abstractfactory.itf.IKfcFactory;

public class MainApp {

	public static void main(String[] args) {
		/**
		 * 定义一个肯德基类型
		 */
		IKfcFactory kfcFactory = new ChinaKFCFactory();
		/**
		 * 客户准备点餐
		 */
		Customer customer = new Customer(kfcFactory);
		
		/**
		 * 开始点餐
		 */
		//一个麻辣鸡腿汉堡
		float humberMoney = customer.orderHumburg(1);
		//四个烤鸡翅
		float chickenWingsMoney = customer.orderChickenWings(4);
		//一包薯条
		float frenchFriesMoney = customer.orderFrenchFires(1);
		//两杯可乐
		float beverageMoney = customer.orderBeverage(2);
		
		System.out.println("总共消费"+(humberMoney+chickenWingsMoney+frenchFriesMoney+beverageMoney));
	}
}
