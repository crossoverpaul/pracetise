package com.guozz.test.thread.synchronised2;

public class MyThread14_1 extends Thread {

	private ThreadDomain14_0 td;
    
    public MyThread14_1(ThreadDomain14_0 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.methodB();
    }
}
