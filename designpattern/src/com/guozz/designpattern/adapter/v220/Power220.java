package com.guozz.designpattern.adapter.v220;

import com.guozz.designpattern.adapter.power.AbsBasePower;

public class Power220 extends AbsBasePower implements IPower220{

	public Power220() {
		super(220);
	}

	@Override
	public void outPrint220V() {
		System.out.println("这是["+this.getPower()+this.getUnit()+"]的电源");
	}

}
