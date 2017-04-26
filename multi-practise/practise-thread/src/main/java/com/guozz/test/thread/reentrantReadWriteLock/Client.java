package com.guozz.test.thread.reentrantReadWriteLock;

public class Client {

	
	public static void main(String[] args) {
		//尽管方法加了锁，还休眠了10秒，但是两个线程还是几乎同时执行lock()方法后面的代码，
		//看时间就知道了。说明lock.readLock()读锁可以提高程序运行效率，允许多个线程同时执行lock()方法后面的代码
		//final ThreadDomain48 td = new ThreadDomain48();
		
		//从时间上就可以看出来，10000ms即10s，和代码里一致，证明了读和读之间是互斥的
		final ThreadDomain48_1 td = new ThreadDomain48_1();
	    Runnable readRunnable = new Runnable()
	    {
	        public void run()
	        {
	            td.read();
	        }
	    };
	    Thread t0 = new Thread(readRunnable);
	    Thread t1 = new Thread(readRunnable);
	    t0.start();
	    t1.start();
	}
}
