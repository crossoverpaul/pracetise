package com.guozz.test.thread.deadLock;

public class Thread1 extends Thread {
	 private DeadLock dl;
	    
	    public Thread1(DeadLock dl){
	        this.dl = dl;
	    }
	    
	    public void run(){
	        try{
	            dl.rightLeft();
	        } 
	        catch (Exception e){
	            e.printStackTrace();
	        }
	    }
}
