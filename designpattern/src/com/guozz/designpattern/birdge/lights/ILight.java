package com.guozz.designpattern.birdge.lights;

/**
 * 电灯接口
 * @author Administrator
 *
 */
public interface ILight {

	/**
	 * 接通电流
	 */
	public void electricConnected();
	
	/**
	 * 照明
	 */
	public void light();
	
	/**
	 * 断开电流
	 */
	public void electricClosed();
}
