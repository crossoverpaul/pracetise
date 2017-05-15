package com.guozz.spring.test;


import com.guozz.test.spring.interfaces.Hello;
import com.guozz.test.spring.interfaces.impl.HelloImpl;
import com.guozz.test.spring.interfaces.impl.HelloImpl2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test1(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");
		HelloImpl hello = beanFactory.getBean(HelloImpl.class);
		hello.sayHello();
	}


	@Test
	public void test2(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");
		HelloImpl hello = beanFactory.getBean("bean",HelloImpl.class);
		hello.sayHello();
	}
	@Test
	public void testName(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");
		HelloImpl hello = beanFactory.getBean("bean",HelloImpl.class);
		hello.sayHello();
	}

	@Test
	public void test5(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");
		//1根据id获取bean
		Hello bean1 = beanFactory.getBean("bean1", Hello.class);
		bean1.sayHello();
		//2根据别名获取bean
		Hello alias11 = beanFactory.getBean("alias11", Hello.class);
		alias11.sayHello();
		//3验证确实是四个别名
		String[] bean1Alias = beanFactory.getAliases("bean1");
		System.out.println("=======namingbean5.xml bean1 别名========");
		for(String alias : bean1Alias) {
			System.out.println(alias);
		}
		Assert.assertEquals(4, bean1Alias.length);
		//根据id获取bean
		Hello bean2 = beanFactory.getBean("bean2", Hello.class);
		bean2.sayHello();
		//2根据别名获取bean
		Hello alias21 = beanFactory.getBean("alias21", Hello.class);
		alias21.sayHello();
		//验证确实是两个别名
		String[] bean2Alias = beanFactory.getAliases("bean2");
		System.out.println("=======namingbean5.xml bean2 别名========");
		for(String alias : bean2Alias) {
			System.out.println(alias);
		}
		Assert.assertEquals(2, bean2Alias.length);
	}


	/**
	 * 构造器注入
	 */
	@Test
	public void test6(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");

		Hello bean1 = beanFactory.getBean("bean1", HelloImpl2.class);
		bean1.sayHello();

		Hello bean2 = beanFactory.getBean("bean2", HelloImpl2.class);
		bean2.sayHello();		
	}
	

	/**
	 * 工厂方法
	 */
	@Test
	public void test7(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");

		Hello bean1 = beanFactory.getBean("bean3", Hello.class);
		bean1.sayHello();
		
	}
	
	/**
	 * 注入的三种方法
	 */
	@Test
	public void test8(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");

		Hello bean1 = beanFactory.getBean("byIndex", Hello.class);
		bean1.sayHello();
		
		Hello bean2 = beanFactory.getBean("byType", Hello.class);
		bean2.sayHello();
		
		Hello bean3 = beanFactory.getBean("byName", Hello.class);
		bean3.sayHello();
		
	}

	/**
	 * setter
	 */
	@Test
	public void test9(){
		BeanFactory beanFactory =new ClassPathXmlApplicationContext("spring/spring-*.xml");

		Hello bean1 = beanFactory.getBean("bean", Hello.class);
		bean1.sayHello();
		
	}

}
