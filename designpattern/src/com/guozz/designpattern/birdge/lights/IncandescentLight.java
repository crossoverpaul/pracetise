package com.guozz.designpattern.birdge.lights;

/**
 * °×³ãµÆÊµÏÖ
 * @author Administrator
 *
 */
public class IncandescentLight implements ILight {

	@Override
	public void electricConnected() {
		System.out.println("°×³ãµÆ´ò¿ª");
	}

	@Override
	public void light() {
		System.out.println("°×³ãµÆÕÕÃ÷");
	}

	@Override
	public void electricClosed() {
		System.out.println("°×³ãµÆ¹Ø±Õ");
	}

}
