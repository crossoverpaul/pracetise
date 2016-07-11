package com.guozz.designpattern.birdge.lights;

/**
 * 白炽灯实现
 * @author Administrator
 *
 */
public class CrystalLight implements ILight {

	@Override
	public void electricConnected() {
		System.out.println("水晶灯打开");
	}

	@Override
	public void light() {
		System.out.println("水晶灯照明");
	}

	@Override
	public void electricClosed() {
		System.out.println("水晶灯关闭");
	}

}
