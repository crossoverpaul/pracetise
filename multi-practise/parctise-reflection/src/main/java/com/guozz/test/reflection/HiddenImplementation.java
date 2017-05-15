package com.guozz.test.reflection;

import java.lang.reflect.Method;

import com.guozz.test.reflection.C.HiddenC;

public class HiddenImplementation {

	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
        System.out.println(a.getClass().getName());
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
	    
	}
	
	static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
