package org.practise.upgrade.pattern.delegate;

public class Test {

	 public static void main(String[] args) {  
	        new ProfessionalWorker().send();  
	          
	        System.out.println("*********************************************");  
	          
	        new SparetimeWorker().send();  
	    }  
}
