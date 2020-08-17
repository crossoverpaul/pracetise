package com.guozz.test.upgradejava.thread;

public class TestThread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(i+"thread1");
                }
                System.out.println("thread1 执行完了");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    for(int i=0;i<10;i++){
                        System.out.println(i+"thread2");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 执行完了");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    for(int i=0;i<10;i++){
                        System.out.println(i+"thread3");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 执行完了");
            }
        });


        thread3.start();
        thread2.start();
        thread1.start();

    }
}
