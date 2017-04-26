package com.guozz.test.thread.synchronised5;

public class MyThread28 extends Thread {
	
	public volatile  boolean isRunning =true;
	
	public boolean isRunning(){
        return isRunning;
    }
	
	public void setIsRunning(boolean isRunning){
		this.isRunning=isRunning;
	}
	 

	@Override
	public void run() {
		 System.out.println("进入run了");
	     while (isRunning == true){
	     }
	     System.out.println("线程被停止了");
	}
	
}
