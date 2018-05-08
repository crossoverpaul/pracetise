package org.practise.upgrade.concurrent.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{

	
	private BlockingQueue<String> queue;
    private static final int  DEFAULT_RANGE_FOR_SLEEP = 1000;
    private String cusumerName;

    public Consumer(BlockingQueue<String> queue,String name) {
        this.queue = queue;
        this.cusumerName = name;
    }
    
	@Override
	public void run() {
		System.out.println(cusumerName+"  启动消费者线程！");
        Random r = new Random();
        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println(cusumerName+"    正从队列获取数据...");
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println(cusumerName+"    拿到数据：" + data);
                    System.out.println(cusumerName+"    正在消费数据：" + data);
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                } else {
                    // 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(cusumerName+"    退出消费者线程！");
        }
	}

}