package com.guozz.designpattern.birdge.common;

import com.guozz.designpattern.birdge.common.sub.CrystalLight;
import com.guozz.designpattern.birdge.common.sub.IncandescentLight;

public class Client {

	public static void main(String[] args) {
		//白炽灯
		AbstractSwitch light = new IncandescentLight();
		//水晶灯
		CrystalLight light2 = new CrystalLight();
		System.out.println("----一般开关-----");
		light.makeLight();
		
		System.out.println("----遥控开关----");
		light2.makeRemoteLight(1);
		
		
				
	}
}
