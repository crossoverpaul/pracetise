package com.guozz.test.thread.synchronised4;

public class Client {

	/**
	 * 从运行结果来，对printC()方法的调用和对printA()方法、printB()方法的调用时异步的，
	 * 这说明了静态同步方法和非静态同步方法持有的是不同的锁，前者是类锁，后者是对象锁。
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDomain25 td =new ThreadDomain25();
		MyThread25_0 myThread25_0 = new MyThread25_0();
		MyThread25_1 myThread25_1 = new MyThread25_1();
		MyThread25_2 myThread25_2 = new MyThread25_2(td);
		myThread25_0.start();
		myThread25_1.start();
		myThread25_2.start();
	}
}
