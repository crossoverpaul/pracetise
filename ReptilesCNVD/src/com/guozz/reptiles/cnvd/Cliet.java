package com.guozz.reptiles.cnvd;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cliet {

	
	private static ThreadPoolExecutor producerPool = null;// 执行检查的线程池
	
	public static final int CORESIZE = 10;
	public static final int MAXSIZE = 20;
	public static final long KEEPALIVETIME = 1;
	public static final int QUEUESIZE = 80;
	
	static{
		producerPool = new ThreadPoolExecutor(CORESIZE, MAXSIZE, KEEPALIVETIME,  
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(QUEUESIZE),  
				new ThreadPoolExecutor.DiscardOldestPolicy());
	}
	
	public static void main(String[] args) throws Exception {
		//应用程序
		TestReptilesCNVD_WebApplication testReptilesCNVD_WebApplication =new TestReptilesCNVD_WebApplication();
		producerPool.execute(testReptilesCNVD_WebApplication);
		//安全产品
		TestReptilesCNVD_SecurityProduct testReptilesCNVD_SecurityProduct = new TestReptilesCNVD_SecurityProduct();
		producerPool.execute(testReptilesCNVD_SecurityProduct);
		//web应用
		TestReptilesCNVD_ApplicationProgram testReptilesCNVD_ApplicationProgram = new TestReptilesCNVD_ApplicationProgram();
		producerPool.execute(testReptilesCNVD_ApplicationProgram);
		//操作系统
		TestReptilesCNVD_OS testReptilesCNVD_OS = new TestReptilesCNVD_OS();
		producerPool.execute(testReptilesCNVD_OS);
		// 数据库
		TestReptilesCNVD_DB testReptilesCNVD_DB = new TestReptilesCNVD_DB();
		producerPool.execute(testReptilesCNVD_DB);
		//网络设备
		TestReptilesCNVD_NetDevice testReptilesCNVD_NetDevice = new TestReptilesCNVD_NetDevice();
		producerPool.execute(testReptilesCNVD_NetDevice);
	}
}
