package com.guozz.designpattern.adapter.power;

import com.guozz.designpattern.adapter.v220.IPower220;

public class Power220 extends AbsBasePower implements IPower220{

	public Power220(float power) {
		super(power);
	}

	@Override
	public void outPrint220V() {
		
	}

}
