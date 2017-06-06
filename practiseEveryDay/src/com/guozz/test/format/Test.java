package com.guozz.test.format;

public class Test {

	public static void main(String[] args) {
		String template ="您的订单已到达【%s】，【%s】验货完成，正在分配配送员";
		String result =String.format(template, "a","b");
		System.out.println(result);		
	}
}
