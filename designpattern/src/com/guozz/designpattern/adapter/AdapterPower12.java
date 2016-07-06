package com.guozz.designpattern.adapter;

import com.guozz.designpattern.adapter.power.AbsBasePower;
import com.guozz.designpattern.adapter.v12.IPower12;

public class AdapterPower12 implements IPower12{

	private final AbsBasePower absBasePower;
	
	public AdapterPower12(AbsBasePower absBasePower){
		this.absBasePower=absBasePower;
	}

	@Override
	public void output12v() {
		//获取外部电源值
		float powerFloat= absBasePower.getPower();
		//进行电源转换
		if(powerFloat==380){
			powerFloat=powerFloat/31.67f;
		}else if(powerFloat==220){
			powerFloat=powerFloat/18.33f;
		}else if(powerFloat==110){
			powerFloat=powerFloat/9.17f;
		}else{
			System.out.println("----不能适配电源----");
		}
		powerFloat=(int)(powerFloat*10)/10.0f;
		System.out.println("这是["+powerFloat+this.absBasePower.getUnit()+"]的电源");
	}
	
	
}
