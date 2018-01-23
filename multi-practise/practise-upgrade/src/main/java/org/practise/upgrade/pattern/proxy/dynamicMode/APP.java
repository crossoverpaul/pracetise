package org.practise.upgrade.pattern.proxy.dynamicMode;

import org.practise.upgrade.pattern.proxy.dynamicMode.impl.ProxyFactory;
import org.practise.upgrade.pattern.proxy.dynamicMode.impl.UserDao;

public class APP {

	public static void main(String[] args) {
		//目标对象
		IUserDao target = new UserDao();
		// 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        
        // 给目标对象，创建代理对象
        IUserDao proxy= (IUserDao) new ProxyFactory(target).getProxyInstance();
        
     // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        
        proxy.save();
		
	}
}
