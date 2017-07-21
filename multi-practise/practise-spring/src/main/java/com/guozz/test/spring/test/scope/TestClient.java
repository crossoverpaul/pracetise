package com.guozz.test.spring.test.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoSingletonService demoSingletonService1 = context.getBean(DemoSingletonService.class);
		DemoSingletonService demoSingletonService2 = context.getBean(DemoSingletonService.class);
		
		DemoPrototypeService demoPrototypeService1 = context.getBean(DemoPrototypeService.class);
		DemoPrototypeService demoPrototypeService2 = context.getBean(DemoPrototypeService.class);
		context.close();
		
		System.out.println("s1和s2是否相等"+demoSingletonService1.equals(demoSingletonService2));
		System.out.println("p1和p2是否相等"+demoPrototypeService1.equals(demoPrototypeService2));
	}
}
