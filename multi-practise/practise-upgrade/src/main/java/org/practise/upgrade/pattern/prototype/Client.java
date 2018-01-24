package org.practise.upgrade.pattern.prototype;

public class Client {
	public static void main(String[] args) {  
        Prototype prototypeA = new CreatePrototypeA();  
        Prototype prototypeB = prototypeA.clone();  
          
        System.out.println(prototypeB.equals(prototypeA));   // return false  
        System.out.println(prototypeB == prototypeA);   // return false  
        System.out.println(prototypeB.getClass() == prototypeA.getClass());  // return true  
  
    }  
}
