package com.sym.myboot.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: asd
 * @Auther: Suyiming3333
 * @Date: 2019/2/19 0019 16:33
 * @Description:
 * @Version:
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    private BlockingQueue<Integer> queue;// 内存缓冲区

    private static final int SLEEPTIME = 1000;

    private Thread thread;


    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("start producting thread name:" + Thread.currentThread().getName());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                int i = r.nextInt();
                queue.put(i);
                System.out.println(i+"入队列成功，当前队列大小为："+queue.size());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    public void start(){
        if(thread ==null){
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
