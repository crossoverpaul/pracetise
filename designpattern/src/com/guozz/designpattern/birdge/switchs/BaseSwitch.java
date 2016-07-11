package com.guozz.designpattern.birdge.switchs;

import com.guozz.designpattern.birdge.lights.ILight;

/**
 * 开关顶层类
 * @author Administrator
 *
 */
public class BaseSwitch {

	//使用组合，设置ILight为内部私有属性，此为桥接
	protected ILight light;
	
	//构造方法将外部的light注入进来
	public BaseSwitch(ILight light){
		this.light=light;
	}
	
	
	public final void makeLight(){
		//打开开关，接通电流
		this.light.electricConnected();
		//照明
		this.light.light();
		//关闭开关，断开电流
		this.light.electricClosed();
	}
	
}
