/**
 * 
 */
package com.guozz.test.thread.synchronised;

/**
 * @author Administrator
 *
 */
public class MyThread13_0 extends Thread {
	
	private ThreadDomain13 threadDomain13;
	
	public MyThread13_0(ThreadDomain13 threadDomain13){
		this.threadDomain13=threadDomain13;
	}

	@Override
	public void run() {
		threadDomain13.addNum("a");
	}
	
	
	

}
