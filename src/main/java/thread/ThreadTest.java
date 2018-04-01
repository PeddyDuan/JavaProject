package main.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 线程池测试
 *
 * @author Peddy
 * @time 2018-03-18 16:10
 */
public class ThreadTest {

    /**
     * 模拟爸爸去饭店
     */
    public static void fatherToRes() {
        System.out.println("爸爸步行去饭店需要3小时。");
    }

    /**
     * 模拟妈妈去饭店
     */
    public static void motherToRes() {
        System.out.println("妈妈挤公交去饭店需要2小时。");
    }

    /**
     * 模拟我去饭店
     */
    public static void meToRes() {
        System.out.println("我乘地铁去饭店需要1小时。");
    }

    /**
     * 模拟一家人到齐了
     */
    public static void togetherToEat() {
        System.out.println("一家人到齐了，开始吃饭");
    }

//    private static volatile int i = 3;
    private static CountDownLatch latch = new CountDownLatch(3);
    
    public static void main(String[] args) throws InterruptedException {
        
        Long startTime = System.currentTimeMillis();
        
        new Thread() {
            @Override
            public void run() {
                fatherToRes();
//                i--;
                latch.countDown();
            }
        }.start();

            new Thread() {
            @Override
            public void run() {
                motherToRes();
//                i--;
                latch.countDown();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                meToRes();
//                i--;
                latch.countDown();
            }
        }.start();

        //忙等，等到三个人都到达，才一起吃饭。但是忙等对于CPU的消耗太巨大了
        /*while (i != 0) {
            System.out.println(i);
        };*/
        latch.await();
        togetherToEat();
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


}
