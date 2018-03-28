package org.practise.guava.function;

import com.google.common.base.Function;

public class FunctionTest {

	static Function<Double, String> power=new Function<Double, String>() {
		@Override
		public String apply(Double input) {
			return "OK";
		}
	};
	
	public static void main(String[] args) {
		
		System.out.println(FunctionTest.power.apply((double) 3L));
	}
}
