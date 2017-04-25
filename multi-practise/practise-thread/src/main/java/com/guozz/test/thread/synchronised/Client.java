package com.guozz.test.thread.synchronised;

public class Client {

	public static void main(String[] args) {
//		ThreadDomain13 threadDomain13 = new ThreadDomain13();
//		MyThread13_0 myThread13_0 = new MyThread13_0(threadDomain13);
//		MyThread13_1 myThread13_1 = new MyThread13_1(threadDomain13);
//		myThread13_0.start();
//		myThread13_1.start();
		ThreadDomain13 threadDomain131 = new ThreadDomain13();
		ThreadDomain13 threadDomain132 = new ThreadDomain13();
		MyThread13_0 myThread13_0 = new MyThread13_0(threadDomain131);
		MyThread13_1 myThread13_1 = new MyThread13_1(threadDomain132);
		myThread13_0.start();
		myThread13_1.start();
	}
}
