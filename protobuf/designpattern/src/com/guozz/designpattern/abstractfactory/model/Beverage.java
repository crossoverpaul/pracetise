package com.guozz.designpattern.abstractfactory.model;

public class Beverage extends AbstractBaseFood implements IFood {

	@Override
	public void printMessage() {
		System.out.println("--"+this.kind+"饮料,\t 单价:" +this.price+",\t 数量:  "+this.num+", \t 合计:" + this.totalPrice());

	}

}
