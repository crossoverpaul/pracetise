package com.guozz.designpattern.factory;

import com.guozz.designpattern.factory.itf.ISwordFactory;
import com.guozz.designpattern.factory.model.AbstractSword;
import com.guozz.designpattern.factory.object.BaXingSword;
import com.guozz.designpattern.factory.object.QiXingSword;

public class CaoCao2 implements ISwordFactory {

	@Override
	public AbstractSword createSword() {
		
		return new BaXingSword();
	}

}
