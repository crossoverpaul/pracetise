package com.guozz.test.upgradejava.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在并发编程时，一般使用runnable，然后扔给线程池完事，这种情况下不需要线程的结果。 
所以run的返回值是void类型。 

如果是一个多线程协作程序，比如菲波拉切数列，1，1，2，3，5，8...使用多线程来计算。 
但后者需要前者的结果，就需要用callable接口了。 
callable用法和runnable一样，只不过调用的是call方法，该方法有一个泛型返回值类型，你可以任意指定。 

线程是属于异步计算模型，所以你不可能直接从别的线程中得到函数返回值。 
这时候，Future就出场了。Futrue可以监视目标线程调用call的情况，当你调用Future的get()方法以获得结果时，当前线程就开始阻塞，直接call方法结束返回结果。 
 * @author 郭智忠
 *
 */
public class FutureTest {

	 public static class Task implements Callable<String> {
	        public String call() throws Exception {
	            String tid = String.valueOf(Thread.currentThread().getId());
	            System.out.printf("Thread#%s : in call\n", tid);
	            return tid;
	        }
	    }	 
	 

	    public static void main(String[] args) throws InterruptedException, ExecutionException {
	        List<Future<String>> results = new ArrayList<Future<String>>();
	        ExecutorService es = Executors.newCachedThreadPool();
	        for(int i=0; i<100;i++)
	            results.add(es.submit(new Task()));

	        for(Future<String> res : results)
	            System.out.println(res.get());
	    }	    

}
