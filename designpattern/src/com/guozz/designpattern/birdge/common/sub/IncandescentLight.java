package com.guozz.designpattern.birdge.common.sub;

import com.guozz.designpattern.birdge.common.AbstractSwitch;

public class IncandescentLight extends AbstractSwitch {

	@Override
	public void turnOn() {
		System.out.println("°×³ãµÆ¿ªÁË");
	}

	@Override
	public void light() {
		System.out.println("°×³ãµÆÕÕÃ÷");
	}

	@Override
	public void turnOff() {
		System.out.println("°×³ãµÆ¹ØÁË");
	}

}
