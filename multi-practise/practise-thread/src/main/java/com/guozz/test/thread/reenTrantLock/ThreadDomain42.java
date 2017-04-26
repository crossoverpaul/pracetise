package com.guozz.test.thread.reenTrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadDomain42 {

	ReentrantLock lock = new ReentrantLock(true);
	
	public void testMethod(){
		try {
			lock.lock();
			System.out.println("ThreadName" + Thread.currentThread().getName() + "获得锁");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
            lock.unlock();
        }
	}	
}
