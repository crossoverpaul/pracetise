package com.guozz.test.thread.threadlocal;

public class Client {

	public static void main(String[] args) {
		ThreadLocalThread a = new ThreadLocalThread("ThreadA");
        ThreadLocalThread b = new ThreadLocalThread("ThreadB");
        ThreadLocalThread c = new ThreadLocalThread("ThreadC");
        a.start();
        b.start();
        c.start();
	}
}
