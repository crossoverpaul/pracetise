package com.guozz.test.thread.reenTrantLock;

public class Client {

	public static void main(String[] args) {
		
		ThreadDomain38 td = new ThreadDomain38();
		
		MyThread38 myThread38_0=new MyThread38(td);
		MyThread38 myThread38_1=new MyThread38(td);
		MyThread38 myThread38_2=new MyThread38(td);
		
		myThread38_0.start();
		myThread38_1.start();
		myThread38_2.start();
	}
}
