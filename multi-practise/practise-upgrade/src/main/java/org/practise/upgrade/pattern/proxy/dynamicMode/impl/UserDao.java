package org.practise.upgrade.pattern.proxy.dynamicMode.impl;

import org.practise.upgrade.pattern.proxy.dynamicMode.*;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("保存");
	}

}
