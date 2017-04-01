package com.guozz.designpattern.facade.impl;

import com.guozz.designpattern.facade.Shape;

public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square :: draw() ");
	}

}
