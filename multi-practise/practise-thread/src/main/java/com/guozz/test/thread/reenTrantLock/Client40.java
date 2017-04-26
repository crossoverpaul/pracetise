package com.guozz.test.thread.reenTrantLock;

public class Client40 {

	public static void main(String[] args) {
		ThreadDomain40 td = new ThreadDomain40();
	    MyThread40 mt = new MyThread40(td);
	    mt.start();
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    td.signal();
	}
}
