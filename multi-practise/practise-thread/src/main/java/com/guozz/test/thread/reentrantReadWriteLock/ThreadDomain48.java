package com.guozz.test.thread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDomain48 extends ReentrantReadWriteLock {
	
	public void read(){
		try {
			readLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" + 
			        System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			readLock().unlock();
		}
		
	}	
}
