package com.guozz.test.thread.synchronised4;

public class MyThread25_2 extends Thread {
	
	private ThreadDomain25 td; 

	public MyThread25_2(ThreadDomain25 td){
		this.td=td;		
	}
	
	@Override
	public void run() {
		td.printC();
	}
}
