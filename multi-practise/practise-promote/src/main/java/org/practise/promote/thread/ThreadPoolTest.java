package org.practise.promote.thread;

public class ThreadPoolTest implements Runnable{

	@Override
	public void run() {
		 try{
			 Thread.sleep(300);
			}catch (InterruptedException e)	{
				e.printStackTrace();
			}
	}
}
