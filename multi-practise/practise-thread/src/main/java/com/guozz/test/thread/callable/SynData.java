package com.guozz.test.thread.callable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;

public class SynData {

	static class MyCallable implements Callable<String> {
		TestService testService = new TestService();
		int threadNum;
		MyCallable(int threadNum) {
            this.threadNum = threadNum;
        }

		@Override
        public String call() {
        	String result = testService.test(threadNum);
            System.out.println(Thread.currentThread().getName() + " : " + threadNum);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> results = executor.invokeAll(asList(new MyCallable(0),new MyCallable(1),new MyCallable(2),new MyCallable(3),new MyCallable(4),new MyCallable(5),new MyCallable(6),new MyCallable(7),new MyCallable(8),new MyCallable(9),new MyCallable(10)));
        executor.shutdown();
//        for (Future<String> result : results) {
//            System.out.println(result.get());
//        }
    }
}
