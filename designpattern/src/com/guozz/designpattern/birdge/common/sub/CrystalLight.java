package com.guozz.designpattern.birdge.common.sub;

import com.guozz.designpattern.birdge.common.AbstractSwitch;

public class CrystalLight extends AbstractSwitch {

	@Override
	public void turnOn() {
		System.out.println("水晶灯开了");
	}

	@Override
	public void light() {
		System.out.println("水晶照明");
	}

	@Override
	public void turnOff() {
		System.out.println("水晶灯关了");
	}
	
	public final void makeRemoteLight(int operColor){
		//打开开关
		this.turnOn();
		//照明
		this.light();
		String color="";
		switch (operColor) {
		case 1:
			color="暖色";
			break;
		case 2:
			color="蓝色";
			break;
		case 3:
			color="红色";
			break;

		default:
			color="白色";
			break;
		}
		System.out.println("....现在是"+color+"! ");
		//关闭开关，断开电流
		this.turnOff();
	}

}
