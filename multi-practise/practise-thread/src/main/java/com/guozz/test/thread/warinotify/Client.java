package com.guozz.test.thread.warinotify;

public class Client {

	public static void main(String[] args) throws Exception
	{
	    Object lock = new Object();
	    MyThread30_0 mt0 = new MyThread30_0(lock);
	    mt0.start();
	    Thread.sleep(3000);
	    MyThread30_1 mt1 = new MyThread30_1(lock);
	    mt1.start();
	}
}
