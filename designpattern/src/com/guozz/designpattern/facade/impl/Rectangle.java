package com.guozz.designpattern.facade.impl;

import com.guozz.designpattern.facade.Shape;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle :: draw() ");
	}

}
