package org.practise.upgrade.pattern.proxy.staticMode.impl;

import org.practise.upgrade.pattern.proxy.staticMode.IUserDao;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("保存");
	}

}
