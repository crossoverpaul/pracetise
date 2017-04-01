package com.guozz.designpattern.facade.impl;

import com.guozz.designpattern.facade.Shape;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle :: draw() ");
	}

}
