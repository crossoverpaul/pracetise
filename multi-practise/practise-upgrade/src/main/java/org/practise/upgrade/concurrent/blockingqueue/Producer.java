package org.practise.upgrade.concurrent.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

	private BlockingQueue<String> queue;
	private volatile boolean  isRunning  = true;
	private static AtomicInteger count  = new AtomicInteger();
    private static final int  DEFAULT_RANGE_FOR_SLEEP = 1000;
    private String produceName;
    
    public Producer(BlockingQueue<String> queue,String produceName) {
    	this.queue=queue;
    	this.produceName=produceName;
    }
    
	
	@Override
	public void run() {
		String data = null;
		Random r = new Random();
		
		System.out.println(produceName+"    启动生产者线程！");
		
		try {
			while(isRunning) {
				System.out.println(produceName+"    正在生产数据...");
				Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				data = "data:" + count.incrementAndGet();
				System.out.println(produceName+"    将数据：" + data + "放入队列...");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println(produceName+"    放入数据失败：" + data);
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(produceName+"    退出生产者线程！");
		}

	}
	
	public void stop() {
        isRunning = false;
    }
}
