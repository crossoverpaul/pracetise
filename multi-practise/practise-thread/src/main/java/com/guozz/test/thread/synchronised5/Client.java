package com.guozz.test.thread.synchronised5;

public class Client {

	public static void main(String[] args) throws Exception{
		MyThread28 myThread28 = new MyThread28();
		myThread28.start();
		myThread28.sleep(2000);
		myThread28.setIsRunning(false);
		System.out.println("已赋值为false");
	}
}
