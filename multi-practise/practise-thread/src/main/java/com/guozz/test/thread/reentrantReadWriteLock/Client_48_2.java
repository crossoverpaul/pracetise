package com.guozz.test.thread.reentrantReadWriteLock;

public class Client_48_2 {

	
	public static void main(String[] args) {
		/**
		 * 从时间上看，也是10000ms即10s，和代码里面是一致的，证明了读和写之间是互斥的。
		 * 注意一下，"读和写互斥"和"写和读互斥"是两种不同的场景，但是证明方式和结论是一致的，所以就不证明了
		 */
		 final ThreadDomain48_2 td = new ThreadDomain48_2();
	        Runnable readRunnable = new Runnable()
	        {
	            public void run()
	            {
	                td.read();
	            }
	        };
	        Runnable writeRunnable = new Runnable()
	        {
	            public void run()
	            {
	                td.write();
	            }
	        };
	        Thread t0 = new Thread(readRunnable);
	        Thread t1 = new Thread(writeRunnable);
	        t0.start();
	        t1.start();
	}
}
