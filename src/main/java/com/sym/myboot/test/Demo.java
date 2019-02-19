package com.sym.myboot.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: demo
 * @Auther: Suyiming3333
 * @Date: 2019/2/19 0019 16:54
 * @Description:
 * @Version:
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);

        Consumer c1 = new Consumer(queue);

        p1.start();
        p2.start();
        c1.start();

        Thread.sleep(10*1000);
        p1.stop();
        p2.stop();
        //c1.stop();
        //Thread.sleep(3000);
    }
}
