package org.practise.upgrade.pattern.strategy;

public class App {
	public static void main(String[] args) {
		 Context context;  
		  
	     System.out.println("----------刚到吴国使用第一个锦囊---------------");  
	     context = new Context(new BackDoorStrategy());  
	     context.operate();  
	     System.out.println("\n");  
	  
	     System.out.println("----------刘备乐不思蜀使用第二个锦囊---------------");  
	     context.setStrategy(new GivenGreenLightStrategy());  
	     context.operate();  
	     System.out.println("\n");  
	  
	     System.out.println("----------孙权的追兵来了，使用第三个锦囊---------------");  
	     context.setStrategy(new BlackEnemyStrategy());  
	     context.operate();  
	     System.out.println("\n");  
	}
}
