package com.guozz.designpattern.abstractfactory.itf;

import com.guozz.designpattern.abstractfactory.model.Beverage;
import com.guozz.designpattern.abstractfactory.model.ChickenWings;
import com.guozz.designpattern.abstractfactory.model.FrenchFries;
import com.guozz.designpattern.abstractfactory.model.Humburg;

/**
 * 肯德基抽象工厂
 * @author Administrator
 *
 */
public interface IKfcFactory {

	//厂产汉堡
	public Humburg createHumburg(int num);
	
	//生产薯条
	public FrenchFries createFrenchFires(int num);
	
	//生产鸡翅
	public ChickenWings createChickenWing(int num);
	
	//生产饮料
	public Beverage createBeverage(int num);
	
	
	
}
