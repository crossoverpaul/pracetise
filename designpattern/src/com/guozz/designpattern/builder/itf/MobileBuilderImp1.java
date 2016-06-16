package com.guozz.designpattern.builder.itf;

import com.guozz.designpattern.builder.base.AbstractBasePackage;
import com.guozz.designpattern.builder.model.MobilePackage;

public class MobileBuilderImp1 extends AbstractBasePackage implements IMobileBuilder{

	/**
	 * 建造手机套餐的话费
	 */
	@Override
	public void buildMoney() {
		this.mobilePackage.setMoney(20.0f);
	}

	@Override
	public void buildShortInfo() {
		this.mobilePackage.setShortInfo(400);
	}

	@Override
	public void buildMusic() {
		this.mobilePackage.setMusic("天使");
	}

	@Override
	public MobilePackage getMobilePackage() {
		return this.mobilePackage;
	}

}
