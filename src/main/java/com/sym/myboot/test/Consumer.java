package com.sym.myboot.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: asd
 * @Auther: Suyiming3333
 * @Date: 2019/2/19 0019 16:48
 * @Description:
 * @Version:
 */
public class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private static final int SLEEPTIME = 1000;
    private volatile boolean isRunning = true;
    private static AtomicInteger count = new AtomicInteger();// 总数 原子操作

    private Thread thread;

    public Consumer(BlockingQueue<Integer> queue,AtomicInteger count){
        this.queue = queue;
        this.count = count;
    }

    @Override
    public synchronized void run() {
        System.out.println("start Consumer id :"+Thread.currentThread().getName());
        Random r = new Random();
        try{
            while(true){
                Integer j = queue.take();
                System.out.println(j+"被消费,队列大小："+count.decrementAndGet());
                Thread.sleep(r.nextInt(SLEEPTIME));
            }
        }catch (InterruptedException e) {
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
