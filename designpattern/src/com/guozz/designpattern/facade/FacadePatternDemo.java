package com.guozz.designpattern.facade;

import com.guozz.designpattern.facade.facade.Shagepmaker;

public class FacadePatternDemo {

	public static void main(String[] args) {
		Shagepmaker shagepmaker = new Shagepmaker();
		shagepmaker.drawCircle();
		shagepmaker.drawRectangle();
		shagepmaker.drawSquare();
	}
}
