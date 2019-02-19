package com.sym.myboot.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: demo
 * @Auther: Suyiming3333
 * @Date: 2019/2/19 0019 16:54
 * @Description:
 * @Version:
 */
public class Demo {

    private static AtomicInteger count = new AtomicInteger();// 总数 原子操作

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);

        Producer p1 = new Producer(queue,count);
        Producer p2 = new Producer(queue,count);

        Consumer c1 = new Consumer(queue,count);

        p1.start();
        p2.start();
        c1.start();

        Thread.sleep(10*1000);
        p1.stop();
        p2.stop();
        //c1.stop();
        Thread.sleep(3000);
    }
}
