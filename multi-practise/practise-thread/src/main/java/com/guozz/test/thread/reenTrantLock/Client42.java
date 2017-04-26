package com.guozz.test.thread.reenTrantLock;

public class Client42 {

	public static void main(String[] args) {
		
		final ThreadDomain42 td = new ThreadDomain42();
		
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("线程  "  + Thread.currentThread().getName() + " 运行了");
				td.testMethod();
			}
		};
		
		Thread [] threads = new Thread[5];
		for(int i=0;i<5;i++){
			threads[i] = new Thread(runnable);
		}
		
		for(int i=0;i<5;i++){
			threads[i].start();
		}
		
	}
}
