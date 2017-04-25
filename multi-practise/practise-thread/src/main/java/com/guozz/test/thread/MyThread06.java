package com.guozz.test.thread;

public class MyThread06 extends Thread{

	@Override
	public void run() {
		System.out.println("run = " + this.isAlive());
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		  MyThread06 mt = new MyThread06();
		  System.out.println("begin == " + mt.isAlive());
		  mt.start();
		  Thread.sleep(100);
		  System.out.println("end == " + mt.isAlive());
	}
}
