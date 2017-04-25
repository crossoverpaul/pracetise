package com.guozz.test.thread;

public class MyThread11 extends Thread{
	
	private int i = 0;

	@Override
	public void run() {
	 try{
            while (true){
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } 
        catch (InterruptedException e){
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		try {
			MyThread11 myThread11 = new MyThread11();
			myThread11.setDaemon(true);
			myThread11.start();
			Thread.sleep(5000);
			System.out.println("我离开thread对象再也不打印了，我停止了！");
		} catch (Exception e) {
		}
	}
}
