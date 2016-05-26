package com.guozz.designpattern.abstractfactory.model;

public class FrenchFries extends AbstractBaseFood implements IFood {

	@Override
	public void printMessage() {
		System.out.println("--"+this.kind+"风味薯条,\t 单价:" +this.price+",\t 数量:  "+this.num+", \t 合计:" + this.totalPrice());

	}

}
