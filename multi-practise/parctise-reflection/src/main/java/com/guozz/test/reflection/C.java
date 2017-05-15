package com.guozz.test.reflection;

public class C implements A {

	   public void f() { 
		   System.out.println("public C.f()"); 
	   }
	   public void g() {
		   System.out.println("public C.g()"); 
	   }
	   protected void v () {
		   System.out.println("protected C.v()"); 
	   }
	   void u() {
		   System.out.println("package C.u()"); 
	   }
	   private void w() {
		   System.out.println("private C.w()"); 
	   }
	   public static class HiddenC {
	        public static A makeA() { return new C(); }
	   }

}
