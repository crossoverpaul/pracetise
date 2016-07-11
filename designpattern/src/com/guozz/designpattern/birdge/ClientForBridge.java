package com.guozz.designpattern.birdge;

import com.guozz.designpattern.birdge.lights.CrystalLight;
import com.guozz.designpattern.birdge.lights.ILight;
import com.guozz.designpattern.birdge.lights.IncandescentLight;
import com.guozz.designpattern.birdge.switchs.BaseSwitch;
import com.guozz.designpattern.birdge.switchs.RemoteControlSwitch;

public class ClientForBridge {

	public static void main(String[] args) {
		//白炽灯实例
		ILight  incadescentLight=new IncandescentLight();
		//水晶灯实例
		ILight  crystalLight=new CrystalLight();
		
		//一版开关
		 BaseSwitch baseSwitch = new BaseSwitch(incadescentLight);
		 baseSwitch.makeLight();
		 
		 //遥控开关
		 RemoteControlSwitch remoteControlSwitch =new RemoteControlSwitch(crystalLight);
		 remoteControlSwitch.makeRemoteLight(1);
		
	}
}
