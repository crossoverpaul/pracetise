package com.guozz.test.thread.reenTrantLock;

public class MyThread38 extends Thread {

	private ThreadDomain38 td;
	
	public MyThread38(ThreadDomain38 td){
		this.td=td;
	}
	 
	@Override
	public void run() {
		td.testMethod();
	}

	
}
