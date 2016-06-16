package com.guozz.designpattern.builder.director;

import com.guozz.designpattern.builder.itf.IMobileBuilder;
import com.guozz.designpattern.builder.model.MobilePackage;

/**
 * 手机套餐指导者
 * @author Administrator
 *
 */
public class MobileDirector {

	public MobilePackage createMobilePackage(IMobileBuilder mobileBuilder){
		if(mobileBuilder!=null){
			mobileBuilder.buildMoney();
			mobileBuilder.buildShortInfo();
			mobileBuilder.buildMusic();
			return mobileBuilder.getMobilePackage();
		}
		return null;
	}
	
}
