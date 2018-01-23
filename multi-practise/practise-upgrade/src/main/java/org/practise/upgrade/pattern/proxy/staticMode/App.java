package org.practise.upgrade.pattern.proxy.staticMode;

import org.practise.upgrade.pattern.proxy.staticMode.impl.UserDao;
import org.practise.upgrade.pattern.proxy.staticMode.impl.UserDaoProxy;

public class App {

	public static void main(String[] args) {
		
		//目标对象
        UserDao target = new UserDao();
        
        //代理对象，把目标对象传入代理对象，建立关系
        UserDaoProxy userDaoProxy = new UserDaoProxy(target);
        
        //执行的是代理的保存
        userDaoProxy.save();
	}
}
