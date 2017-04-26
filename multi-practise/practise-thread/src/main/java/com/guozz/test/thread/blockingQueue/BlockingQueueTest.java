package com.guozz.test.thread.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		
		final BlockingQueue<String> bq=new ArrayBlockingQueue<String>(10);
		
		Runnable produceRunnable = new Runnable() {
			int i=0;
			public void run() {
				while(true){
					try {
						System.out.println("我生产了一个" + i++);
						bq.put(i+"");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable consumerRunnable = new Runnable() {
			
			public void run() {
				while (true)
	            {
	                try
	                {
	                    System.out.println("我消费了一个" + bq.take());
	                    Thread.sleep(3000);
	                } 
	                catch (InterruptedException e)
	                {
	                    e.printStackTrace();
	                }
	            }
			}
		};
		
		Thread producerThread = new Thread(produceRunnable);
	    Thread customerThread = new Thread(consumerRunnable);
	    producerThread.start();
	    customerThread.start();
	}
}
